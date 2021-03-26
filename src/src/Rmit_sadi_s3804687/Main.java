package Rmit_sadi_s3804687;

import java.util.Date;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  FileNotFoundException {
//        Date dob_s1 = new Date(2000,11,7);
//        Student S1 = new Student("3804687","Dat",dob_s1);
//        System.out.println(S1);
//        course sadi = new course("cosc2440","Software something",12);
//        System.out.println(sadi);
        CsvHandler ch = CsvHandler.get_instance();
        ch.get_header("./Csv/us_stock.csv");
//        System.out.println(ch.filenames);
//        System.out.println(ch.headers);
//        String a = "1234567";
//        System.out.println(a.substring(1));


    }

}
