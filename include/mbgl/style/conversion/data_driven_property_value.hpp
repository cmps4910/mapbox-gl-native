#pragma once

#include <mbgl/style/data_driven_property_value.hpp>
#include <mbgl/style/conversion.hpp>
#include <mbgl/style/conversion/constant.hpp>
#include <mbgl/style/conversion/function.hpp>

namespace mbgl {
namespace style {
namespace conversion {

template <class T>
struct Converter<DataDrivenPropertyValue<T>> {
    template <class V>
    Result<DataDrivenPropertyValue<T>> operator()(const V& value) const {
        if (isUndefined(value)) {
            return {};
        } else if (!isObject(value)) {
            Result<T> constant = convert<T>(value);
            if (!constant) {
                return constant.error();
            }
            return DataDrivenPropertyValue<T>(*constant);
        }

        auto type = objectMember(value, "type");
        if (type && toString(*type) == std::string("identity")) {
            Result<IdentityFunction<T>> function = convert<IdentityFunction<T>>(value);
            if (!function) {
                return function.error();
            }
            return DataDrivenPropertyValue<T>(*function);
        } else if (type && toString(*type) == std::string("categorical")) {
            Result<CompositeFunction<DiscreteFunction<T>>> composite =
                convert<CompositeFunction<DiscreteFunction<T>>>(value);
            if (composite) {
                return DataDrivenPropertyValue<T>(*composite);
            }
            Result<DiscreteFunction<T>> function = convert<DiscreteFunction<T>>(value);
            if (!function) {
                return function.error();
            }
            return DataDrivenPropertyValue<T>(*function);
        } else if (!objectMember(value, "property")) {
            Result<ZoomFunction<T>> function = convert<ZoomFunction<T>>(value);
            if (!function) {
                return function.error();
            }
            return DataDrivenPropertyValue<T>(*function);
        } else {
            Result<CompositeFunction<ContinuousFunction<T>>> composite =
                convert<CompositeFunction<ContinuousFunction<T>>>(value);
            if (composite) {
                return DataDrivenPropertyValue<T>(*composite);
            }
            Result<ContinuousFunction<T>> function = convert<ContinuousFunction<T>>(value);
            if (!function) {
                return function.error();
            }
            return DataDrivenPropertyValue<T>(*function);
        }
    }
};

} // namespace conversion
} // namespace style
} // namespace mbgl
