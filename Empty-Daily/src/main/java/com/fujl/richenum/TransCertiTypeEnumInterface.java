package com.fujl.richenum;

import java.util.Map;

public interface TransCertiTypeEnumInterface {

    void transCertiType(Map<String, Object> map);

    static TransCertiTypeEnumInterface byTransOne() {
        return map -> System.out.println("byTransOne");
    }

    static TransCertiTypeEnumInterface byTransTwo() {
        return map -> System.out.println("byTransTwo");
    }
}
