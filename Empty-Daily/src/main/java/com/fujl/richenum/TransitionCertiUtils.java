package com.fujl.richenum;

import java.util.HashMap;
import java.util.Objects;

public class TransitionCertiUtils {

    private static final CertiType c = CertiType.getInstance();

    //中文描述转换为码值
    public static void setTypeDesc(String type){
        TransCertiType.valueOf(c.certiMap.get(type)).getEnumInterface().transCertiType(new HashMap<>());
    }

    public static void main(String[] args) {
        TransitionCertiUtils.setTypeDesc("1");
    }
}