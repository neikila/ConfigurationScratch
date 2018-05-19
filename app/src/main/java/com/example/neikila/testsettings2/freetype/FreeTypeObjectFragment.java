package com.example.neikila.testsettings2.freetype;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.neikila.testsettings2.MainActivity;
import com.example.neikila.testsettings2.ModelFragment;
import com.example.neikila.testsettings2.R;
import com.example.neikila.testsettings2.model.FreeTypeNode;

public class FreeTypeObjectFragment<T> extends ModelFragment<T> {
    FreeTypeNode<T> mNode;
    T mValue;

    public FreeTypeObjectFragment() {
    }


    @SuppressLint("ValidFragment")
    public FreeTypeObjectFragment(FreeTypeNode<T> node, T value) {
        this();
        // Required empty public constructor
        mNode = node;
        mValue = value;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        ListView list = view.findViewById(R.id.free_type_fragment);

        list.setAdapter(new FieldAdapter<>(
                (MainActivity)getActivity(),
                mValue,
                mNode.mSubFields,
                new OnParentChangedListener()));

        return view;
    }

    private class OnParentChangedListener implements ModelFragment.OnChangeListener {
        @Override
        public void onChange(Object val) {
            mValue = (T)val;
            mOnChangeListener.onChange(mValue);
        }
    }
}

