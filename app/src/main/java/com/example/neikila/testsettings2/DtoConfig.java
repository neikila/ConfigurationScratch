package com.example.neikila.testsettings2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by neikila on 18.05.18.
 */

// Model that is already created for MailAppConfiguration
public class DtoConfig {

    private boolean isWebViewEnabled;
    private Ads mAds = new Ads();

    public boolean isWebViewEnabled() {
        return isWebViewEnabled;
    }

    public void setWebViewEnabled(boolean webViewEnabled) {
        isWebViewEnabled = webViewEnabled;
    }

    public Ads getAds() {
        return mAds;
    }

    public void setAds(Ads ads) {
        mAds = ads;
    }

    public static class Ads {
        String mKey = "defaultVal";
        int mRate = 1234;
        List<String> mBanners = Arrays.asList("Test", "Play");

        public List<String> getBanners() {
            return mBanners;
        }

        public void setBanners(List<String> banners) {
            mBanners = banners;
        }

        public String getKey() {
            return mKey;
        }

        public void setKey(String key) {
            this.mKey = key;
        }

        public int getRate() {
            return mRate;
        }

        public void setRate(int rate) {
            this.mRate = rate;
        }

        // FOR_TEST_PURPOSE
        @Override
        public String toString() {
            return "Ads{" +
                    "mKey='" + mKey + '\'' +
                    ", mRate=" + mRate +
                    ", mBanners=" + mBanners +
                    '}';
        }
    }

    // FOR_TEST_PURPOSE
    @Override
    public String toString() {
        return "DtoConfig{" +
                "isWebViewEnabled=" + isWebViewEnabled +
                ", mAds=" + mAds +
                '}';
    }
}
