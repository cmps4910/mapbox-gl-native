#pragma once

#include <vector>
#include <utility>
#include <string>

namespace mbgl {

class GeometryTileFeature;

namespace style {

template <typename T>
class ContinuousFunction {
public:
    using DomainType = float;
    using RangeType = T;
    using Stop = std::pair<float, T>;
    using Stops = std::vector<Stop>;

    ContinuousFunction(std::string property_, Stops stops_, float base_)
        : property(std::move(property_)), base(base_), stops(std::move(stops_)) {}

    const std::string& getProperty() const { return property; }
    float getBase() const { return base; }
    const std::vector<std::pair<float, T>>& getStops() const { return stops; }

    T evaluate(float z, const GeometryTileFeature&) const;

    friend bool operator==(const ContinuousFunction& lhs, const ContinuousFunction& rhs) {
        return lhs.property == rhs.property && lhs.base == rhs.base && lhs.stops == rhs.stops;
    }

    friend bool operator!=(const ContinuousFunction& lhs, const ContinuousFunction& rhs) {
        return !(lhs == rhs);
    }

private:
    std::string property;
    float base = 1;
    std::vector<std::pair<float, T>> stops;
};

} // namespace style
} // namespace mbgl
