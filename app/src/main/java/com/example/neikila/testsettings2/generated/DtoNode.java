package com.example.neikila.testsettings2.generated;

import com.example.neikila.testsettings2.DtoConfig;
import com.example.neikila.testsettings2.model.FreeTypeNode;
import com.example.neikila.testsettings2.model.GetterSetter;
import com.example.neikila.testsettings2.model.Primitive;

/**
 * Created by neikila on 18.05.18.
 */

public class DtoNode extends FreeTypeNode<DtoConfig> {
    public DtoNode() {
        addNode("isWebViewEnabled", Primitive.bool(), new WevViewEnabledGetterSetter());
        addNode("mAds", new AdsNode(), new AdsGetterSetter());
    }

    private static class WevViewEnabledGetterSetter implements GetterSetter<DtoConfig, Boolean> {
        @Override
        public Boolean get(DtoConfig obj) {
            return obj.isWebViewEnabled();
        }

        @Override
        public void set(DtoConfig obj, Object field) {
            obj.setWebViewEnabled((Boolean)field);
        }
    }

    private static class AdsGetterSetter implements GetterSetter<DtoConfig, DtoConfig.Ads> {
        @Override
        public DtoConfig.Ads get(DtoConfig obj) {
            return obj.getAds();
        }

        @Override
        public void set(DtoConfig obj, Object field) {
            obj.setAds((DtoConfig.Ads)field);
        }
    }
}
