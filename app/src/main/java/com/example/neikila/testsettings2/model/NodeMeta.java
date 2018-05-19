package com.example.neikila.testsettings2.model;

public class NodeMeta<Base, T> {
    public Node<T> mNode;
    public GetterSetter<Base, T> mGetterSetter;

    public NodeMeta(Node<T> node, GetterSetter<Base, T> getterSetter) {
        mNode = node;
        mGetterSetter = getterSetter;
    }
}
