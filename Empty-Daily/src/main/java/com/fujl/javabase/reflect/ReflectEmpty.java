package com.fujl.javabase.reflect;

import lombok.Data;

public class ReflectEmpty {

    @Data
    static class Student{
        private int id;
        String name;
        protected boolean sex;
        public float score;
    }

    public static void main(String[] args) throws Exception{
        Student student = new Student();
        student.setId(1);
        Class<? extends Student> classObj1 = student.getClass();
        System.out.println(classObj1.getName());



        Class<?> classObj2 = Class.forName("com.fujl.javabase.reflect.ReflectEmpty$Student");
        Student stu = (Student) classObj2.getDeclaredConstructor().newInstance();
        stu.setId(2);
        stu.setName("hah");
        System.out.println(stu);
        System.out.println(classObj2.getName());

        Class<Student> classObj3 = Student.class;
        System.out.println(classObj3.getName());
    }
}
