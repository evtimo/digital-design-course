package com.digdes.school;

import com.digdes.school.homework1.WriteToCSV;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        //run Homework1

        //WriteToCSV.main(args);
        WriteToCSV hw1 = new WriteToCSV();
        hw1.convert(args);


    }
}