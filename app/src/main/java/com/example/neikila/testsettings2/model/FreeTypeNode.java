package com.example.neikila.testsettings2.model;

import java.util.HashMap;
import java.util.Map;

public class FreeTypeNode<T> extends Node<T> {
    public Map<String, NodeMeta<T, ?>> mSubFields = new HashMap<>();

    public <K> void addNode(String key, Node<K> node, GetterSetter<T, K> getterSetter) {
        mSubFields.put(key, new NodeMeta<>(node, getterSetter));
    }
}
