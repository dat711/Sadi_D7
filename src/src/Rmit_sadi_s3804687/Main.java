package Rmit_sadi_s3804687;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Date;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  FileNotFoundException {
//        Date d1 = new Date(2000,12,7);
//        Date d2 = new Date(2001,12,7);
//        Date d3 = new Date(2002,12,7);
//        Date d4 = new Date(2000,11,7);
//
//
//        Student Dat = new Student("s3804687","Dat",d1);
//        Student Hung = new Student("s3804686","Hung",d2);
//        Student Tam = new Student("S3804689","Tam",d3);
//        course c1 = new course("cosc2000","intro to IT",12);
//        course c2 = new course("cosc2007","intro to pro",12);
//        course c3 = new course("cosc2008","intro to IT",12);
//
//        StudentEnrolment SE = StudentEnrolment.getInstance();
//        SE.add_course(c1);
//        SE.add_course(c2);
//        SE.add_course(c3);
//        SE.add_student(Dat);
//        SE.add_student(Tam);
//        SE.add_student(Hung);
//
//        SE.addSemeser("2021A");
//        SE.add_course_to_sem("cosc2000","2021A");
//        System.out.println(SE.getSemester_course().get("2021A"));
//        System.out.println(SE.getSemester());
//
//        SE.addSemester(2020,"B");
//        System.out.println(SE.getSemester());
//        for (int i = 0; i < SE.getStudentList().size();i++){
//            System.out.println(SE.getStudentList().get(i).getName());
//            System.out.println(SE.getStudentList().get(i).getId());
//            System.out.println("__________________________\n");
//        }
//
////        System.out.println(SE.find_course("ID","cosc2000").getCoursename());
////        System.out.println(SE.find_course("name","intro to IT").getCouseID());
//        enrollment e1 = new enrollment("s3804687","2020B","cosc2000");
//        SE.addEnrollment(e1);
//        for (int i = 0;i < SE.getEnrollments_his().size();i++){
//            System.out.println(SE.getEnrollments_his());
//        }
//        System.out.println(SE.get_enrolment("s3804687","cosc2000").getSemester());
//        SE.delete_enrolment("s3804687","cosc2000");
//        System.out.println(SE.get_enrolment("s3804687","cosc2000"));
//        System.out.println("______________A____________________");
//        enrollment e2 = new enrollment("S3804689","2021A","cosc2000");
//        SE.addEnrollment(e1);
//        SE.addEnrollment(e2);
//        for (int i = 0;i<SE.get_course_for_ss("s3804687","2020B").size();i++){
//            System.out.println(SE.get_course_for_ss("s3804687","2020B").get(i).getCoursename());
//        }
////        System.out.println(SE.get_course_for_ss("s3804687","2020B"));
////        System.out.println(SE.getEnrollments_his());
//
//        SE.addSemester(2021,"A");
//        SE.add_course_to_sem("cosc2007","2021A");
//        SE.add_course_to_sem("cosc2000","2021A");
//        SE.add_course_to_sem("cosc1999","2021A");
//        System.out.println(SE.getSemester_course());
//        System.out.println(SE.get_course_Avai_for_sem("2021A"));
//        System.out.println("______________________________");
//        System.out.println(SE.get_stu_enrolled("2021A","cosc2000"));


//        Menu m = Menu.getInstance();
//        m.main_menu();

//        int i = Integer.parseInt("070");
//        System.out.println(i);
//        Date j = new Date();
//        System.out.println(j.getYear()+1900);

        Menu m =Menu.getInstance();
        m.main_menu();


    }

}
