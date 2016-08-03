package com.infinite.framework.entity;

import java.util.HashMap;

public class Temp {

    static void test() {
        A a;
        HashMap<String, A> classMap = null;
        a = classMap.get("a").clone("");
    }

    public abstract class A {
        public abstract A clone(String json);
    }

    public class ASUb extends A {
        @Override
        public ASUb clone(String json) {
            return null;
        }
    }
}
