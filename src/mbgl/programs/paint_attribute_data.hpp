#pragma once

#include <mbgl/style/paint_property.hpp>
#include <mbgl/util/type_list.hpp>

namespace mbgl {

template <class AllProperties, class DataDrivenProperties>
class PaintAttributeData;

template <class... Ps, class... DDPs>
class PaintAttributeData<TypeList<Ps...>, TypeList<DDPs...>> {
public:
    using EvaluatedProperties = typename style::PaintProperties<Ps...>::Evaluated;
    using Attributes = gl::Attributes<typename DDPs::Attribute...>;
    using AttributeBindings = typename Attributes::Bindings;

    PaintAttributeData(EvaluatedProperties properties_, float z)
        : properties(std::move(properties_)),
          zoom(z),
          vertexVectors(DDPs::vertexVector(properties.template get<DDPs>())...)
    {}

    void populateVertexVectors(const GeometryTileFeature& feature,
                               std::size_t length) {
        util::ignore({
            (DDPs::populateVertexVector(vertexVectors.template get<DDPs>(),
                                        properties.template get<DDPs>(),
                                        feature, zoom, length), 0)...
        });
    }

    void upload(gl::Context& context) {
        vertexBuffers = VertexBuffers {
            DDPs::vertexBuffer(context, std::move(vertexVectors.template get<DDPs>()))...
        };
    }

    AttributeBindings attributeBindings(const EvaluatedProperties& currentProperties) {
        return AttributeBindings {
            DDPs::attributeBinding(currentProperties.template get<DDPs>(),
                                   properties.template get<DDPs>(),
                                   vertexBuffers.template get<DDPs>())...
        };
    }

private:
    EvaluatedProperties properties;
    float zoom;

    template <class... Ts>
    using Tuple = IndexedTuple<TypeList<DDPs...>, TypeList<Ts...>>;

    using VertexVectors = Tuple<optional<typename DDPs::VertexVector>...>;
    using VertexBuffers = Tuple<optional<typename DDPs::VertexBuffer>...>;

    VertexVectors vertexVectors;
    VertexBuffers vertexBuffers;
};

}
