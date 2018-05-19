package com.example.neikila.testsettings2.arrayobject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.neikila.testsettings2.R;
import com.example.neikila.testsettings2.arrayobject.ArrayObjectFragment;
import com.example.neikila.testsettings2.model.ArrayNode;
import com.example.neikila.testsettings2.model.Types;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by neikila on 19.05.18.
 */

public class PrimitiveArrayFragment<T> extends ArrayObjectFragment<T> {

    private ArrayAdapter<String> mAdapter;

    public PrimitiveArrayFragment() {

    }

    @SuppressLint("ValidFragment")
    public PrimitiveArrayFragment(ArrayNode<T> node, List<T> values) {
        super(node, values);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ListView list = view.findViewById(R.id.arraylist);

        mAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        list.setAdapter(mAdapter);
        refreshAdapter();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String inputVal = String.valueOf(new Random(position).nextInt());
                Types.Primitive<T> type = (Types.Primitive<T>) mNode.mType;
                mList.set(position, type.valueOf(inputVal));
                refreshAdapter();
                mOnChangeListener.onChange(mList);
            }
        });

        return view;
    }

    private void refreshAdapter() {
         mAdapter.clear();
         mAdapter.addAll(asString(mList));
    }

    private static <T> List<String> asString(List<T> vals) {
        List<String> strings = new ArrayList<>();
        for (T val : vals) {
            strings.add(String.valueOf(val));
        }
        return strings;
    }

    @Override
    protected void onElementAdd(T el) {
        mAdapter.add(String.valueOf(el));
        super.onElementAdd(el);
    }
}
