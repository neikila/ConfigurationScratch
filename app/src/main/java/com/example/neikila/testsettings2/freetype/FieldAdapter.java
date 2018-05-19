package com.example.neikila.testsettings2.freetype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.neikila.testsettings2.MainActivity;
import com.example.neikila.testsettings2.ModelFragment;
import com.example.neikila.testsettings2.R;
import com.example.neikila.testsettings2.model.NodeMeta;
import com.example.neikila.testsettings2.model.Primitive;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by neikila on 19.05.18.
 */
public class FieldAdapter<T> extends BaseAdapter {

    private final MainActivity mContext;
    private final List<Map.Entry<String, NodeMeta<T, ?>>> mFields;
    private T mParent;
    private ModelFragment.OnChangeListener mOnChangeListener;

    public FieldAdapter(MainActivity context, T parent, Map<String, NodeMeta<T, ?>> fields, ModelFragment.OnChangeListener onChangeListener) {
        mContext = context;
        mFields = new ArrayList<>(fields.entrySet());
        mParent = parent;
        mOnChangeListener = onChangeListener;
    }

    @Override
    public int getCount() {
        return mFields.size();
    }

    @Override
    public Object getItem(int position) {
        return mFields.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RelativeLayout view = (RelativeLayout) convertView;
        if (view == null) {
            view = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.form_view, parent, false);
        }
        Map.Entry<String, NodeMeta<T, ?>> mapEntry = (Map.Entry<String, NodeMeta<T, ?>>) getItem(position);

        final NodeMeta<T, ?> nodeMeta = mapEntry.getValue();

        ((TextView)view.findViewById(R.id.key)).setText(mapEntry.getKey());
        String text;
        if (nodeMeta.mNode instanceof Primitive) {
            text = String.valueOf(nodeMeta.mGetterSetter.get(mParent));
        } else {
            text = "";
        }
        ((TextView)view.findViewById(R.id.value)).setText(text);

        view.setOnClickListener(new ClickListener<>(mContext, nodeMeta, mParent, new OnParentChangedListener()));

        return view;
    }

    private class OnParentChangedListener implements ModelFragment.OnChangeListener {
        @Override
        public void onChange(Object val) {
            mParent = (T)val;
            notifyDataSetChanged();
            mOnChangeListener.onChange(mParent);
        }
    }
}
