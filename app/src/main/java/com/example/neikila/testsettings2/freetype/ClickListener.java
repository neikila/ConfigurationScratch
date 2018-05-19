package com.example.neikila.testsettings2.freetype;

import android.view.View;
import android.widget.Toast;

import com.example.neikila.testsettings2.arrayobject.ArrayObjectFragment;
import com.example.neikila.testsettings2.MainActivity;
import com.example.neikila.testsettings2.ModelFragment;
import com.example.neikila.testsettings2.model.ArrayNode;
import com.example.neikila.testsettings2.model.FreeTypeNode;
import com.example.neikila.testsettings2.model.Node;
import com.example.neikila.testsettings2.model.NodeMeta;
import com.example.neikila.testsettings2.model.Primitive;

import java.util.List;
import java.util.Random;

/**
 * Created by neikila on 19.05.18.
 */
public class ClickListener<T> implements View.OnClickListener {
    private final MainActivity mActivity;
    private final NodeMeta<T, ?> mNodeMeta;
    private final T mParent;
    private final ModelFragment.OnChangeListener mOnChangeListener;

    public ClickListener(MainActivity mainActivity, NodeMeta<T, ?> nodeMeta, T parent, ModelFragment.OnChangeListener onChangeListener) {
        mNodeMeta = nodeMeta;
        mParent = parent;
        mActivity = mainActivity;
        mOnChangeListener = onChangeListener;
    }

    @Override
    public void onClick(View v) {
        Node node = mNodeMeta.mNode;
        Object o = mNodeMeta.mGetterSetter.get(mParent);

        ModelFragment.OnChangeListener listener = new ModelFragment.OnChangeListener() {
            @Override
            public void onChange(Object val) {
                mNodeMeta.mGetterSetter.set(mParent, val);
                mOnChangeListener.onChange(mParent);
            }
        };

        if (node instanceof FreeTypeNode) {
            FreeTypeObjectFragment fragment =
                    new FreeTypeObjectFragment((FreeTypeNode) node, o);
            fragment.setOnModelChangeListener(listener);
            mActivity.setFragment(fragment);
        } else if (node instanceof ArrayNode) {
            ArrayObjectFragment fragment =
                    ArrayObjectFragment.getInstance((ArrayNode) node, (List)o);
            fragment.setOnModelChangeListener(listener);
            mActivity.setFragment(fragment);
        } else if (node instanceof Primitive) {

            // for test purpose imitating change value via Dialog
            if (o instanceof Integer) {
                Integer val = Integer.valueOf(new Random().nextInt());
                listener.onChange(val);
            } else if (o instanceof Boolean) {
                Boolean val = Boolean.valueOf(new Random().nextInt() % 2 == 0);
                listener.onChange(val);
            } else if (o instanceof String) {
                String val = String.valueOf(new Random().nextInt());
                listener.onChange(val);
            }

        } else {
            Toast.makeText(
                    mActivity,
                    node.getClass().getName(),
                    Toast.LENGTH_LONG).show();
        }
    }
}
