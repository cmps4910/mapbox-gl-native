#include <mbgl/style/function/discrete_function.hpp>
#include <mbgl/style/types.hpp>
#include <mbgl/tile/geometry_tile_data.hpp>
#include <mbgl/util/color.hpp>

namespace mbgl {
namespace style {

optional<DiscreteValue> discreteValue(const optional<Value>& value) {
    if (!value) {
        return {};
    }

    return (*value).match(
        [] (bool t) { return optional<DiscreteValue>(t); },
        [] (uint64_t t) { return optional<DiscreteValue>(int64_t(t)); },
        [] (int64_t t) { return optional<DiscreteValue>(t); },
        [] (double t) { return optional<DiscreteValue>(int64_t(t)); },
        [] (const std::string& t) { return optional<DiscreteValue>(t); },
        [] (const auto&) { return optional<DiscreteValue>(); }
    );
}

template <>
float DiscreteFunction<float>::evaluate(float, const GeometryTileFeature& feature) const {
    auto v = discreteValue(feature.getValue(property));
    if (!v) {
        return 0.0f;
    }

    auto it = stops.find(*v);
    return it == stops.end() ? 0.0f : it->second;
}

template <>
Color DiscreteFunction<Color>::evaluate(float, const GeometryTileFeature& feature) const {
    auto v = discreteValue(feature.getValue(property));
    if (!v) {
        return Color::black();
    }

    auto it = stops.find(*v);
    return it == stops.end() ? Color::black() : it->second;
}

} // namespace style
} // namespace mbgl
