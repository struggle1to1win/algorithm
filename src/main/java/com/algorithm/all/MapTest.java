package com.algorithm.all;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNameMapTest
 * @Description
 * @Author Yao Xin
 * @Date2020/9/27 9:51
 **/
public class MapTest {
    public static void main(String[] args) {
        Map<Student,Integer> map = new HashMap<>();
        Student student = new Student(10,"张三");
        map.put(student,1);
        student.setName("李四");
        System.out.println(map.get(student));
    }
    public static class Student{
        private int age;
        private String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
