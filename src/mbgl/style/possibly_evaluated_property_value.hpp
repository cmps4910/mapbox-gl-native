#pragma once

#include <mbgl/style/function/continuous_function.hpp>
#include <mbgl/style/function/discrete_function.hpp>
#include <mbgl/style/function/identity_function.hpp>
#include <mbgl/style/function/composite_function.hpp>
#include <mbgl/util/interpolate.hpp>
#include <mbgl/util/variant.hpp>

namespace mbgl {

class GeometryTileFeature;

namespace style {

template <class T>
class PossiblyEvaluatedPropertyValue {
private:
    using Value = variant<
        T,
        ContinuousFunction<T>,
        DiscreteFunction<T>,
        IdentityFunction<T>,
        CompositeFunction<ContinuousFunction<T>>,
        CompositeFunction<DiscreteFunction<T>>>;

    Value value;

public:
    PossiblyEvaluatedPropertyValue() = default;
    PossiblyEvaluatedPropertyValue(Value v) : value(std::move(v)) {}

    bool isConstant() const { return value.template is<T>(); };
    bool isVariable() const { return !value.template is<T>(); };

    optional<T> constant() const {
        return value.match(
            [&] (const T& t) { return optional<T>(t); },
            [&] (const auto&) { return optional<T>(); });
    }

    T constantOr(const T& t) const {
        return constant().value_or(t);
    }

    T evaluate(float z, const GeometryTileFeature& feature) const {
        return value.match(
            [&] (const T& t) { return t; },
            [&] (const auto& t) { return t.evaluate(z, feature); });
    }
};

} // namespace style

namespace util {

template <typename T>
struct Interpolator<style::PossiblyEvaluatedPropertyValue<T>> {
    style::PossiblyEvaluatedPropertyValue<T> operator()(const style::PossiblyEvaluatedPropertyValue<T>& a,
                                                        const style::PossiblyEvaluatedPropertyValue<T>& b,
                                                        const double t) const {
        if (a.isConstant() && b.isConstant()) {
            return { interpolate(*a.constant(), *b.constant(), t) };
        } else {
            return { a };
        }
    }
};

} // namespace util

} // namespace mbgl
