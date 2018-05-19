package com.example.neikila.testsettings2.arrayobject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.neikila.testsettings2.ModelFragment;
import com.example.neikila.testsettings2.R;
import com.example.neikila.testsettings2.model.ArrayNode;
import com.example.neikila.testsettings2.model.Types;

import java.util.ArrayList;
import java.util.List;


public class ArrayObjectFragment<T> extends ModelFragment<List<T>> {
    protected List<T> mList;
    protected ArrayNode<T> mNode;

    public ArrayObjectFragment() {
    }

    @SuppressLint("ValidFragment")
    public ArrayObjectFragment(ArrayNode<T> node, List<T> values) {
        mList = new ArrayList<>(values);
        mNode = node;
    }

    public static <T> ArrayObjectFragment<T> getInstance(ArrayNode<T> node, List<T> values) {
        if (node.mType instanceof Types.Primitive) {
            return new PrimitiveArrayFragment<>(node, values);
        } else {
            // todo
            return null;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_array_object, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.array_object, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit) {
            Toast.makeText(getContext(), "Add array item", Toast.LENGTH_LONG).show();
            addElement();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addElement() {
        T element = mNode.mType.defaultVal();
        mList.add(element);
        onElementAdd(element);
    }

    protected void onElementAdd(T el) {
        mOnChangeListener.onChange(mList);
    }
}

