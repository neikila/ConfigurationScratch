package com.example.neikila.testsettings2;

import android.support.v4.app.Fragment;

/**
 * Created by neikila on 19.05.18.
 */

public abstract class ModelFragment<T> extends Fragment {
    protected OnChangeListener mOnChangeListener = new DoNothingListener<>();

    public void setOnModelChangeListener(OnChangeListener listener) {
        mOnChangeListener = listener;
    }

    public interface OnChangeListener {
        void onChange(Object val);
    }

    private static class DoNothingListener<T> implements OnChangeListener {

        @Override
        public void onChange(Object val) {

        }
    }
}
