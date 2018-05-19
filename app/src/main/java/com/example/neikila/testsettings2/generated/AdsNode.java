package com.example.neikila.testsettings2.generated;

import com.example.neikila.testsettings2.DtoConfig;
import com.example.neikila.testsettings2.model.Types;
import com.example.neikila.testsettings2.model.ArrayNode;
import com.example.neikila.testsettings2.model.FreeTypeNode;
import com.example.neikila.testsettings2.model.GetterSetter;
import com.example.neikila.testsettings2.model.Primitive;

import java.util.List;

public class AdsNode extends FreeTypeNode<DtoConfig.Ads> {
    AdsNode() {
        addNode("mKey", Primitive.string(), new KeyGetterSetter());
        addNode("mRate", Primitive.integer(), new RateGetterSetter());
        addNode("mBanners", new ArrayNode<>(Types.str()), new BannerGetterSetter());
    }

    private static class KeyGetterSetter implements GetterSetter<DtoConfig.Ads, String> {
        @Override
        public String get(DtoConfig.Ads obj) {
            return obj.getKey();
        }

        @Override
        public void set(DtoConfig.Ads obj, Object field) {
            obj.setKey((String)field);
        }
    }

    private static class RateGetterSetter implements GetterSetter<DtoConfig.Ads, Integer> {
        @Override
        public Integer get(DtoConfig.Ads obj) {
            return obj.getRate();
        }

        @Override
        public void set(DtoConfig.Ads obj, Object field) {
            obj.setRate((Integer)field);
        }
    }

    private static class BannerGetterSetter implements GetterSetter<DtoConfig.Ads, List<String>> {

        @Override
        public List<String> get(DtoConfig.Ads obj) {
            return obj.getBanners();
        }

        @Override
        public void set(DtoConfig.Ads obj, Object field) {
            obj.setBanners((List<String>)field);
        }
    }
}