// This file is generated. Edit android/platform/scripts/generate-style-code.js, then run `make android-style-code`.
package com.mapbox.mapboxsdk.testapp.style;

import android.graphics.Color;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import timber.log.Timber;

import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.testapp.R;
import com.mapbox.mapboxsdk.testapp.activity.style.RuntimeStyleTestActivity;
import com.mapbox.mapboxsdk.testapp.utils.OnMapReadyIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static com.mapbox.mapboxsdk.style.layers.Property.*;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.*;

/**
 * Basic smoke tests for SymbolLayer
 */
@RunWith(AndroidJUnit4.class)
public class SymbolLayerTest extends BaseStyleTest {

    @Rule
    public final ActivityTestRule<RuntimeStyleTestActivity> rule = new ActivityTestRule<>(RuntimeStyleTestActivity.class);

    private SymbolLayer layer;

    private OnMapReadyIdlingResource idlingResource;

    private MapboxMap mapboxMap;

    @Before
    public void setup() {
        idlingResource = new OnMapReadyIdlingResource(rule.getActivity());
        Espresso.registerIdlingResources(idlingResource);
    }

    @Test
    public void testSetVisibility() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("visibility");
        assertNotNull(layer);

        //Get initial
        assertEquals(layer.getVisibility().getValue(), VISIBLE);

        //Set
        layer.setProperties(visibility(NONE));
        assertEquals(layer.getVisibility().getValue(), NONE);
    }

    @Test
    public void testSymbolPlacement() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("symbol-placement");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(symbolPlacement(SYMBOL_PLACEMENT_POINT));
        assertEquals((String) layer.getSymbolPlacement().getValue(), (String) SYMBOL_PLACEMENT_POINT);
    }

    @Test
    public void testSymbolSpacing() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("symbol-spacing");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(symbolSpacing(0.3f));
        assertEquals((Float) layer.getSymbolSpacing().getValue(), (Float) 0.3f);
    }

    @Test
    public void testSymbolAvoidEdges() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("symbol-avoid-edges");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(symbolAvoidEdges(true));
        assertEquals((Boolean) layer.getSymbolAvoidEdges().getValue(), (Boolean) true);
    }

    @Test
    public void testIconAllowOverlap() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-allow-overlap");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconAllowOverlap(true));
        assertEquals((Boolean) layer.getIconAllowOverlap().getValue(), (Boolean) true);
    }

    @Test
    public void testIconIgnorePlacement() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-ignore-placement");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconIgnorePlacement(true));
        assertEquals((Boolean) layer.getIconIgnorePlacement().getValue(), (Boolean) true);
    }

    @Test
    public void testIconOptional() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-optional");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconOptional(true));
        assertEquals((Boolean) layer.getIconOptional().getValue(), (Boolean) true);
    }

    @Test
    public void testIconRotationAlignment() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-rotation-alignment");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconRotationAlignment(ICON_ROTATION_ALIGNMENT_MAP));
        assertEquals((String) layer.getIconRotationAlignment().getValue(), (String) ICON_ROTATION_ALIGNMENT_MAP);
    }

    @Test
    public void testIconSize() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-size");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconSize(0.3f));
        assertEquals((Float) layer.getIconSize().getValue(), (Float) 0.3f);
    }

    @Test
    public void testIconTextFit() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-text-fit");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconTextFit(ICON_TEXT_FIT_NONE));
        assertEquals((String) layer.getIconTextFit().getValue(), (String) ICON_TEXT_FIT_NONE);
    }

    @Test
    public void testIconTextFitPadding() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-text-fit-padding");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconTextFitPadding(new Float[]{0f,0f,0f,0f}));
        assertEquals((Float[]) layer.getIconTextFitPadding().getValue(), (Float[]) new Float[]{0f,0f,0f,0f});
    }

    @Test
    public void testIconImage() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-image");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconImage("undefined"));
        assertEquals((String) layer.getIconImage().getValue(), (String) "undefined");
    }

    @Test
    public void testIconRotate() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-rotate");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconRotate(0.3f));
        assertEquals((Float) layer.getIconRotate().getValue(), (Float) 0.3f);
    }

    @Test
    public void testIconPadding() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-padding");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconPadding(0.3f));
        assertEquals((Float) layer.getIconPadding().getValue(), (Float) 0.3f);
    }

    @Test
    public void testIconKeepUpright() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-keep-upright");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconKeepUpright(true));
        assertEquals((Boolean) layer.getIconKeepUpright().getValue(), (Boolean) true);
    }

    @Test
    public void testIconOffset() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-offset");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconOffset(new Float[]{0f,0f}));
        assertEquals((Float[]) layer.getIconOffset().getValue(), (Float[]) new Float[]{0f,0f});
    }

    @Test
    public void testTextPitchAlignment() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-pitch-alignment");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textPitchAlignment(TEXT_PITCH_ALIGNMENT_MAP));
        assertEquals((String) layer.getTextPitchAlignment().getValue(), (String) TEXT_PITCH_ALIGNMENT_MAP);
    }

    @Test
    public void testTextRotationAlignment() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-rotation-alignment");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textRotationAlignment(TEXT_ROTATION_ALIGNMENT_MAP));
        assertEquals((String) layer.getTextRotationAlignment().getValue(), (String) TEXT_ROTATION_ALIGNMENT_MAP);
    }

    @Test
    public void testTextField() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-field");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textField(""));
        assertEquals((String) layer.getTextField().getValue(), (String) "");
    }

    @Test
    public void testTextFont() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-font");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textFont(new String[]{"Open Sans Regular", "Arial Unicode MS Regular"}));
        assertEquals((String[]) layer.getTextFont().getValue(), (String[]) new String[]{"Open Sans Regular", "Arial Unicode MS Regular"});
    }

    @Test
    public void testTextSize() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-size");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textSize(0.3f));
        assertEquals((Float) layer.getTextSize().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextMaxWidth() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-max-width");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textMaxWidth(0.3f));
        assertEquals((Float) layer.getTextMaxWidth().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextLineHeight() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-line-height");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textLineHeight(0.3f));
        assertEquals((Float) layer.getTextLineHeight().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextLetterSpacing() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-letter-spacing");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textLetterSpacing(0.3f));
        assertEquals((Float) layer.getTextLetterSpacing().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextJustify() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-justify");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textJustify(TEXT_JUSTIFY_LEFT));
        assertEquals((String) layer.getTextJustify().getValue(), (String) TEXT_JUSTIFY_LEFT);
    }

    @Test
    public void testTextAnchor() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-anchor");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textAnchor(TEXT_ANCHOR_CENTER));
        assertEquals((String) layer.getTextAnchor().getValue(), (String) TEXT_ANCHOR_CENTER);
    }

    @Test
    public void testTextMaxAngle() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-max-angle");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textMaxAngle(0.3f));
        assertEquals((Float) layer.getTextMaxAngle().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextRotate() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-rotate");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textRotate(0.3f));
        assertEquals((Float) layer.getTextRotate().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextPadding() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-padding");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textPadding(0.3f));
        assertEquals((Float) layer.getTextPadding().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextKeepUpright() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-keep-upright");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textKeepUpright(true));
        assertEquals((Boolean) layer.getTextKeepUpright().getValue(), (Boolean) true);
    }

    @Test
    public void testTextTransform() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-transform");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textTransform(TEXT_TRANSFORM_NONE));
        assertEquals((String) layer.getTextTransform().getValue(), (String) TEXT_TRANSFORM_NONE);
    }

    @Test
    public void testTextOffset() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-offset");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textOffset(new Float[]{0f,0f}));
        assertEquals((Float[]) layer.getTextOffset().getValue(), (Float[]) new Float[]{0f,0f});
    }

    @Test
    public void testTextAllowOverlap() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-allow-overlap");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textAllowOverlap(true));
        assertEquals((Boolean) layer.getTextAllowOverlap().getValue(), (Boolean) true);
    }

    @Test
    public void testTextIgnorePlacement() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-ignore-placement");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textIgnorePlacement(true));
        assertEquals((Boolean) layer.getTextIgnorePlacement().getValue(), (Boolean) true);
    }

    @Test
    public void testTextOptional() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-optional");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textOptional(true));
        assertEquals((Boolean) layer.getTextOptional().getValue(), (Boolean) true);
    }

    @Test
    public void testIconOpacity() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-opacity");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconOpacity(0.3f));
        assertEquals((Float) layer.getIconOpacity().getValue(), (Float) 0.3f);
    }

    @Test
    public void testIconColor() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-color");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconColor("rgba(0, 0, 0, 1)"));
        assertEquals((String) layer.getIconColor().getValue(), (String) "rgba(0, 0, 0, 1)");
    }

    @Test
    public void testIconColorAsInt() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-color");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconColor(Color.RED));
        assertEquals(layer.getIconColorAsInt(), Color.RED);
    }

    @Test
    public void testIconHaloColor() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-halo-color");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconHaloColor("rgba(0, 0, 0, 1)"));
        assertEquals((String) layer.getIconHaloColor().getValue(), (String) "rgba(0, 0, 0, 1)");
    }

    @Test
    public void testIconHaloColorAsInt() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-halo-color");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconHaloColor(Color.RED));
        assertEquals(layer.getIconHaloColorAsInt(), Color.RED);
    }

    @Test
    public void testIconHaloWidth() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-halo-width");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconHaloWidth(0.3f));
        assertEquals((Float) layer.getIconHaloWidth().getValue(), (Float) 0.3f);
    }

    @Test
    public void testIconHaloBlur() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-halo-blur");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconHaloBlur(0.3f));
        assertEquals((Float) layer.getIconHaloBlur().getValue(), (Float) 0.3f);
    }

    @Test
    public void testIconTranslate() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-translate");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconTranslate(new Float[]{0f,0f}));
        assertEquals((Float[]) layer.getIconTranslate().getValue(), (Float[]) new Float[]{0f,0f});
    }

    @Test
    public void testIconTranslateAnchor() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("icon-translate-anchor");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(iconTranslateAnchor(ICON_TRANSLATE_ANCHOR_MAP));
        assertEquals((String) layer.getIconTranslateAnchor().getValue(), (String) ICON_TRANSLATE_ANCHOR_MAP);
    }

    @Test
    public void testTextOpacity() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-opacity");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textOpacity(0.3f));
        assertEquals((Float) layer.getTextOpacity().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextColor() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-color");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textColor("rgba(0, 0, 0, 1)"));
        assertEquals((String) layer.getTextColor().getValue(), (String) "rgba(0, 0, 0, 1)");
    }

    @Test
    public void testTextColorAsInt() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-color");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textColor(Color.RED));
        assertEquals(layer.getTextColorAsInt(), Color.RED);
    }

    @Test
    public void testTextHaloColor() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-halo-color");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textHaloColor("rgba(0, 0, 0, 1)"));
        assertEquals((String) layer.getTextHaloColor().getValue(), (String) "rgba(0, 0, 0, 1)");
    }

    @Test
    public void testTextHaloColorAsInt() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-halo-color");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textHaloColor(Color.RED));
        assertEquals(layer.getTextHaloColorAsInt(), Color.RED);
    }

    @Test
    public void testTextHaloWidth() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-halo-width");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textHaloWidth(0.3f));
        assertEquals((Float) layer.getTextHaloWidth().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextHaloBlur() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-halo-blur");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textHaloBlur(0.3f));
        assertEquals((Float) layer.getTextHaloBlur().getValue(), (Float) 0.3f);
    }

    @Test
    public void testTextTranslate() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-translate");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textTranslate(new Float[]{0f,0f}));
        assertEquals((Float[]) layer.getTextTranslate().getValue(), (Float[]) new Float[]{0f,0f});
    }

    @Test
    public void testTextTranslateAnchor() {
        checkViewIsDisplayed(R.id.mapView);

        mapboxMap = rule.getActivity().getMapboxMap();

        if ((layer = mapboxMap.getLayerAs("my-layer")) == null) {
            Timber.i("Adding layer");
            layer = new SymbolLayer("my-layer", "composite");
            layer.setSourceLayer("composite");
            mapboxMap.addLayer(layer);
            //Layer reference is now stale, get new reference
            layer = mapboxMap.getLayerAs("my-layer");
        }
        Timber.i("text-translate-anchor");
        assertNotNull(layer);

        //Set and Get
        layer.setProperties(textTranslateAnchor(TEXT_TRANSLATE_ANCHOR_MAP));
        assertEquals((String) layer.getTextTranslateAnchor().getValue(), (String) TEXT_TRANSLATE_ANCHOR_MAP);
    }


   @After
   public void unregisterIntentServiceIdlingResource() {
       Espresso.unregisterIdlingResources(idlingResource);
   }
}
