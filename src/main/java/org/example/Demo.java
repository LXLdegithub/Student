package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        //Gson可以将Student直接转成gson字符串
        Gson gson = new Gson();
        ArrayList<Student01> students = new ArrayList<>();
        Student01 student = new Student01(123,"张三",18);
        students.add(student);

        System.out.println(gson.toJson(students));
    }
}
