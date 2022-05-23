package com.fujl.javabase.accessmodifier.two;

import com.fujl.javabase.accessmodifier.one.Father;

public class Son2 extends Father {

    public int age(){
        return super.getAge();
    }

    public String love(){
        return super.getLove();
    }

    public String name(){
        return super.getName();
    }


    public static void main(String[] args) {

    }


}
