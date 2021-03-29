package Rmit_sadi_s3804687;

import java.util.Date;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  FileNotFoundException {
        Date d1 = new Date(2000,12,7);
        Date d2 = new Date(2001,12,7);
        Date d3 = new Date(2002,12,7);
        Date d4 = new Date(2000,11,7);


        Student Dat = new Student("s3804687","Dat",d1);
        Student Hung = new Student("s3804686","Hung",d2);
        Student Tam = new Student("S3804689","Tam",d3);
        course c1 = new course("cosc2000","intro to IT",12);
        course c2 = new course("cosc2007","intro to pro",12);
        course c3 = new course("cosc2008","intro to IT",12);
//
//        StudentEnrolment SE = StudentEnrolment.getInstance();
//        SE.add_course(c1);
//        SE.add_course(c2);
//        SE.add_course(c3);
//        SE.add_student(Dat);
//        SE.add_student(Tam);
//        SE.add_student(Hung);
//        ArrayList<course>  thelist = SE.getCourseList();
//        for(int i = 0;i < thelist.size();i++){
//            System.out.println(thelist.get(i).getCoursename());
//        }
//
//        ArrayList<Student>  thelist2 = SE.getStudentList();
//        for(int i = 0;i < thelist2.size();i++){
//            System.out.println(thelist2.get(i).getName());
//        }


        keyEnrollment key1 = new keyEnrollment(c1,"2021B");
        EnrollBySem e1 = new EnrollBySem(Dat,"2021B");

        System.out.println(key1.getCourse().getCoursename());
        System.out.println(e1.getSemester());




    }

}
