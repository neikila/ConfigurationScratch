package com.example.neikila.testsettings2.model;

/**
 * Created by neikila on 19.05.18.
 */


public class Types {
    public static abstract class ValueType<T> {
        public abstract T defaultVal();
    }

    public static <T> CustomType<T> custom(String className) {
        return new CustomType<>(className);
    }

    public static Primitive<Integer> integer() {
        return new IntType();
    }

    public static Primitive<Boolean> bool() {
        return new BooleanType();
    }

    public static Primitive<String> str() {
        return new StringType();
    }

    public static class CustomType<T> extends ValueType<T> {
        String mClassName;

        public CustomType(String className) {
            mClassName = className;
        }

        @Override
        public T defaultVal() {
            try {
                //noinspection unchecked
                return (T)Class.forName(mClassName).getConstructor().newInstance();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static abstract class Primitive<T> extends ValueType<T> {
        public abstract T valueOf(String repr);
    }

    private static class IntType extends Primitive<Integer> {
        @Override
        public Integer valueOf(String repr) {
            return Integer.valueOf(repr);
        }

        @Override
        public Integer defaultVal() {
            return 0;
        }
    }

    private static class BooleanType extends Primitive<Boolean> {
        @Override
        public Boolean valueOf(String repr) {
            return Boolean.valueOf(repr);
        }

        @Override
        public Boolean defaultVal() {
            return false;
        }
    }

    private static class StringType extends Primitive<String> {
        @Override
        public String valueOf(String repr) {
            return repr;
        }

        @Override
        public String defaultVal() {
            return "test_default";
        }
    }
}

