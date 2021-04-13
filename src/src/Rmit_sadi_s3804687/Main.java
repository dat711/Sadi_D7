package Rmit_sadi_s3804687;

import java.text.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws  IOException, ParseException {

        StudentEnrolment stuE = StudentEnrolment.getInstance();
        Date Dob = new Date(2000,11,7);
        Student s1 = new Student("s3804687","Dat",Dob);
        Date Dob2 = new Date(2000,11,7);
        Student s2 = new Student("s3804690","Dung",Dob2);
        stuE.add_student(s1);
        stuE.add_student(s2);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        course c1 = new course("cosc2000","web programming",12);
        course c2 = new course("cosc2440","further programming",12);
        stuE.add_course(c1);
        stuE.add_course(c2);
        enrollment e1 = new enrollment("s3804687","2021A","cosc2000");
        enrollment e2 = new enrollment("s3804690","2021A","cosc2000");
        stuE.addEnrollment(e1);
        stuE.addEnrollment(e2);
        System.out.println(students);
        System.out.println("_________________");
        System.out.println(stuE.get_stu_enrolled("2021A","cosc2000"));




    }

}
