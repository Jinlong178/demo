package com.example.demo.demo.model;

import lombok.Data;

/**
 * @Author JinLong
 * @Date 2019/9/2 16:31
 * @Version 1.0
 */
@Data
public class Student implements Comparable<Student>{
        private int id;
        private int age;
        private String name;

        public Student(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
        @Override
        public int compareTo(Student o) {
            //升序
            return this.age - o.age;
        }
        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
}
