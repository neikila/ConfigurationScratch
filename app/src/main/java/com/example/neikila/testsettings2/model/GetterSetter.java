package com.example.neikila.testsettings2.model;

public interface GetterSetter<Base, T> {
    T get(Base obj);
    void set(Base obj, Object field);
}
