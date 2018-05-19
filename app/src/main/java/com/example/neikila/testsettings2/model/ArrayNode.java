package com.example.neikila.testsettings2.model;

import java.util.List;

public class ArrayNode<T> extends Node<List<T>> {
    public Types.ValueType<T> mType;

    public ArrayNode(Types.ValueType<T> type) {
        mType = type;
    }
}
