package com.example.neikila.testsettings2.model;

public class Primitive<T> extends Node<T> {
    private Types.Primitive<T> mType;

    private Primitive(Types.Primitive<T> type) {
        mType = type;
    }

    public Types.Primitive<T> getType() {
        return mType;
    }

    public static Primitive<Integer> integer() {
        return new Primitive<>(Types.integer());
    }

    public static Primitive<String> string() {
        return new Primitive<>(Types.str());
    }

    public static Primitive<Boolean> bool() {
        return new Primitive<>(Types.bool());
    }
}
