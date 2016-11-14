#pragma once

#include <mbgl/util/variant.hpp>
#include <mbgl/style/undefined.hpp>
#include <mbgl/style/function/zoom_function.hpp>
#include <mbgl/style/function/continuous_function.hpp>
#include <mbgl/style/function/discrete_function.hpp>
#include <mbgl/style/function/identity_function.hpp>
#include <mbgl/style/function/composite_function.hpp>

namespace mbgl {
namespace style {

template <class T>
class DataDrivenPropertyValue {
private:
    using Value = variant<
        Undefined,
        T,
        ZoomFunction<T>,
        ContinuousFunction<T>,
        DiscreteFunction<T>,
        IdentityFunction<T>,
        CompositeFunction<ContinuousFunction<T>>,
        CompositeFunction<DiscreteFunction<T>>>;

    Value value;

    friend bool operator==(const DataDrivenPropertyValue& lhs, const DataDrivenPropertyValue& rhs) {
        return lhs.value == rhs.value;
    }

    friend bool operator!=(const DataDrivenPropertyValue& lhs, const DataDrivenPropertyValue& rhs) {
        return !(lhs == rhs);
    }

public:
    DataDrivenPropertyValue() = default;
    DataDrivenPropertyValue(Value v) : value(std::move(v)) {}

    bool isUndefined() const { return value.template is<Undefined>(); }

    template <typename Evaluator>
    auto evaluate(const Evaluator& evaluator) const {
        return Value::visit(value, evaluator);
    }
};

} // namespace style
} // namespace mbgl
