#pragma once

#include <mbgl/style/function/zoom_function.hpp>
#include <mbgl/style/function/continuous_function.hpp>
#include <mbgl/style/function/discrete_function.hpp>
#include <mbgl/style/function/identity_function.hpp>
#include <mbgl/style/function/composite_function.hpp>
#include <mbgl/style/conversion.hpp>
#include <mbgl/style/conversion/constant.hpp>

namespace mbgl {
namespace style {
namespace conversion {

template <class FunctionType, class V>
Result<typename FunctionType::Stops> convertStops(const V& value) {
    auto stopsValue = objectMember(value, "stops");
    if (!stopsValue) {
        return Error { "function value must specify stops" };
    }

    if (!isArray(*stopsValue)) {
        return Error { "function stops must be an array" };
    }

    if (arrayLength(*stopsValue) == 0) {
        return Error { "function must have at least one stop" };
    }

    using Stops = typename FunctionType::Stops;
    using D = typename FunctionType::DomainType;
    using R = typename FunctionType::RangeType;

    Stops stops;
    for (std::size_t i = 0; i < arrayLength(*stopsValue); ++i) {
        const auto& stopValue = arrayMember(*stopsValue, i);

        if (!isArray(stopValue)) {
            return Error { "function stop must be an array" };
        }

        if (arrayLength(stopValue) != 2) {
            return Error { "function stop must have two elements" };
        }

        Result<D> d = convert<D>(arrayMember(stopValue, 0));
        if (!d) {
            return d.error();
        }

        Result<R> r = convert<R>(arrayMember(stopValue, 1));
        if (!r) {
            return r.error();
        }

        stops.insert(stops.end(), std::make_pair(*d, *r));
    }

    return stops;
}

template <class V>
Result<float> convertBase(const V& value) {
    auto baseValue = objectMember(value, "base");
    if (!baseValue) {
        return 1.0f;
    }

    optional<float> base = toNumber(*baseValue);
    if (!base) {
        return Error { "function base must be a number"};
    }

    return *base;
}

template <class T>
struct Converter<ZoomFunction<T>> {
    template <class V>
    Result<ZoomFunction<T>> operator()(const V& value) const {
        if (!isObject(value)) {
            return Error { "function must be an object" };
        }

        auto stops = convertStops<ZoomFunction<T>>(value);
        if (!stops) {
            return stops.error();
        }

        auto base = convertBase(value);
        if (!base) {
            return base.error();
        }

        return ZoomFunction<T>(*stops, *base);
    }
};

template <class T>
struct Converter<ContinuousFunction<T>> {
    template <class V>
    Result<ContinuousFunction<T>> operator()(const V& value) const {
        if (!isObject(value)) {
            return Error { "function must be an object" };
        }

        auto stops = convertStops<ContinuousFunction<T>>(value);
        if (!stops) {
            return stops.error();
        }

        auto base = convertBase(value);
        if (!base) {
            return base.error();
        }

        auto propertyValue = objectMember(value, "property");
        if (!propertyValue) {
            return Error { "function must specify property" };
        }

        auto propertyString = toString(*propertyValue);
        if (!propertyString) {
            return Error { "function property must be a string" };
        }

        return ContinuousFunction<T>(*propertyString, *stops, *base);
    }
};

template <class T>
struct Converter<IdentityFunction<T>> {
    template <class V>
    Result<IdentityFunction<T>> operator()(const V& value) const {
        if (!isObject(value)) {
            return Error { "function must be an object" };
        }

        auto propertyValue = objectMember(value, "property");
        if (!propertyValue) {
            return Error { "function must specify property" };
        }

        auto propertyString = toString(*propertyValue);
        if (!propertyString) {
            return Error { "function property must be a string" };
        }

        return IdentityFunction<T>(*propertyString);
    }
};

template <>
struct Converter<DiscreteValue> {
    template <class V>
    Result<DiscreteValue> operator()(const V& value) const {
        auto b = toBool(value);
        if (b) {
            return *b;
        }

        auto n = toNumber(value);
        if (n) {
            return int64_t(*n);
        }

        auto s = toString(value);
        if (s) {
            return *s;
        }

        return Error { "stop domain value must be a number, string, or boolean" };
    }
};

template <class T>
struct Converter<DiscreteFunction<T>> {
    template <class V>
    Result<DiscreteFunction<T>> operator()(const V& value) const {
        if (!isObject(value)) {
            return Error { "function must be an object" };
        }

        auto stops = convertStops<DiscreteFunction<T>>(value);
        if (!stops) {
            return stops.error();
        }

        auto propertyValue = objectMember(value, "property");
        if (!propertyValue) {
            return Error { "function must specify property" };
        }

        auto propertyString = toString(*propertyValue);
        if (!propertyString) {
            return Error { "function property must be a string" };
        }

        return DiscreteFunction<T>(*propertyString, *stops);
    }
};

template <class InnerFunction>
struct Converter<CompositeValue<InnerFunction>> {
    template <class V>
    Result<CompositeValue<InnerFunction>> operator()(const V& value) const {
        if (!isObject(value)) {
            return Error { "stop must be an object" };
        }

        auto zoomValue = objectMember(value, "zoom");
        if (!zoomValue) {
            return Error { "stop must specify zoom" };
        }

        auto propertyValue = objectMember(value, "value");
        if (!propertyValue) {
            return Error { "stop must specify value" };
        }

        Result<float> z = convert<float>(*zoomValue);
        if (!z) {
            return z.error();
        }

        using P = typename InnerFunction::DomainType;
        Result<P> p = convert<P>(*propertyValue);
        if (!p) {
            return p.error();
        }

        return CompositeValue<InnerFunction> { *z, *p };
    }
};

template <class InnerFunction>
struct Converter<CompositeFunction<InnerFunction>> {
    template <class V>
    Result<CompositeFunction<InnerFunction>> operator()(const V& value) const {
        if (!isObject(value)) {
            return Error { "function must be an object" };
        }

        auto stops = convertStops<CompositeFunction<InnerFunction>>(value);
        if (!stops) {
            return stops.error();
        }

        auto base = convertBase(value);
        if (!base) {
            return base.error();
        }

        auto propertyValue = objectMember(value, "property");
        if (!propertyValue) {
            return Error { "function must specify property" };
        }

        auto propertyString = toString(*propertyValue);
        if (!propertyString) {
            return Error { "function property must be a string" };
        }

        return CompositeFunction<InnerFunction>(*propertyString, *stops, *base);
    }
};

} // namespace conversion
} // namespace style
} // namespace mbgl
