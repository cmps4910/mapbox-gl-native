#pragma once

#include <mbgl/util/variant.hpp>

#include <string>
#include <map>

namespace mbgl {

class GeometryTileFeature;

namespace style {

class DiscreteValue : public variant<bool, int64_t, std::string> {
public:
    using variant<bool, int64_t, std::string>::variant;
};

template <class T>
class DiscreteFunction {
public:
    using DomainType = DiscreteValue;
    using RangeType = T;
    using Stops = std::map<DomainType, RangeType>;

    DiscreteFunction(std::string property_, Stops stops_)
        : property(std::move(property_)), stops(std::move(stops_)) {}

    const std::string& getProperty() const { return property; }
    const Stops& getStops() const { return stops; }

    T evaluate(float z, const GeometryTileFeature&) const;

    friend bool operator==(const DiscreteFunction& lhs, const DiscreteFunction& rhs) {
        return lhs.property == rhs.property && lhs.stops == rhs.stops;
    }

    friend bool operator!=(const DiscreteFunction& lhs, const DiscreteFunction& rhs) {
        return !(lhs == rhs);
    }

private:
    std::string property;
    Stops stops;
};

} // namespace style
} // namespace mbgl
