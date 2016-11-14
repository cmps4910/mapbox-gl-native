#pragma once

#include <vector>
#include <utility>
#include <string>

namespace mbgl {

class GeometryTileFeature;

namespace style {

// A CompositeFunction consists of an outer zoom function whose stop range values are
// "inner" functions, which can be continuous or discrete. It provides the GL Native
// implementation of "zoom-and-property" functions from the style spec.

template <class InnerFunction>
class CompositeValue {
public:
    float zoomValue;
    typename InnerFunction::DomainType propertyValue;

    friend bool operator==(const CompositeValue& lhs, const CompositeValue& rhs) {
        return lhs.zoomValue == rhs.zoomValue && lhs.propertyValue == rhs.propertyValue;
    }
};

template <class InnerFunction>
class CompositeFunction {
public:
    using DomainType = CompositeValue<InnerFunction>;
    using RangeType = typename InnerFunction::RangeType;
    using Stop = std::pair<DomainType, RangeType>;
    using Stops = std::vector<Stop>;

    CompositeFunction(std::string property_, Stops stops_, float base_)
        : property(std::move(property_)), base(base_), stops(std::move(stops_)) {}

    const std::string& getProperty() const { return property; }
    float getBase() const { return base; }
    const Stops& getStops() const { return stops; }

    typename InnerFunction::RangeType
    evaluate(float, const GeometryTileFeature&) const {
        return typename InnerFunction::RangeType();
    }

    friend bool operator==(const CompositeFunction& lhs, const CompositeFunction& rhs) {
        return lhs.property == rhs.property && lhs.base == rhs.base && lhs.stops == rhs.stops;
    }

    friend bool operator!=(const CompositeFunction& lhs, const CompositeFunction& rhs) {
        return !(lhs == rhs);
    }

private:
    std::string property;
    float base = 1;
    Stops stops;
};

} // namespace style
} // namespace mbgl
