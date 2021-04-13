package Rmit_sadi_s3804687;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class unitTest {
//    private static StudentEnrolment stuE = StudentEnrolment.getInstance();


    @Test
    void testAddStudent(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();

        Date Dob = new Date(2000,11,7);
        Student s = new Student("s3804687","Dat",Dob);
        stuE.add_student(s);
        assertEquals(s,stuE.getStudentList().get(0));
        stuE.reset();
    }

    @Test
    void testAddCourse(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        course c = new course("cosc2440","intro to IT",12);
        stuE.add_course(c);
        assertEquals(c,stuE.getCourseList().get(0));
        stuE.reset();
    }

    @Test
    void testAddSemester(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        stuE.addSemeser("2020A");
        assertEquals("2020A",stuE.getSemester().get(0));
        stuE.reset();
    }

    @Test
    void testAddEnrollment(){

        StudentEnrolment stuE = StudentEnrolment.getInstance();
        enrollment e = new enrollment("s3804687","2020A","cosc2440");
        stuE.addEnrollment(e);
        assertEquals(e,stuE.getEnrollments_his().get(0));
        stuE.reset();
    }

    @Test
    void testAddCourseOffered(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        course c1 = new course("cosc2000","web programming",12);
        course c2 = new course("cosc2440","further programming",12);
        stuE.add_course(c1);
        stuE.add_course(c2);
        ArrayList<course> courses = new ArrayList<course>();
        courses.add(c1);
        courses.add(c2);
        stuE.getSemester_course().put("2020A",courses);
        assertEquals(courses,stuE.get_course_Avai_for_sem("2020A"));
        stuE.reset();
    }

    @Test
    void testGetOneStudentMethod(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        Date Dob = new Date(2000,12,8);
        Student s1 = new Student("s3804689","Tam",Dob);
        stuE.add_student(s1);
        assertEquals(s1,stuE.find_student("id","s3804689").get(0));
        stuE.reset();
    }


    @Test
    void testFindaCourseMethod(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        course c2 = new course("cosc2000","web programming",12);
        stuE.add_course(c2);
        assertEquals(c2,stuE.find_course("id","cosc2000"));
        stuE.reset();
    }

    @Test
    void testFindaErollmentMethod(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        enrollment e = new enrollment("s3804689","2020A","cosc2000");
        stuE.addEnrollment(e);
        assertEquals(e,stuE.get_enrolment("s3804689","cosc2000","2020A").get(0));
        stuE.reset();
    }

    @Test
    void testGetAllStudentMethod(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        course c1 = new course("cosc2000","web programming",12);
        course c2 = new course("cosc2440","further programming",12);
        stuE.add_course(c1);
        stuE.add_course(c2);
        ArrayList<course> courses = new ArrayList<course>();
        courses.add(c1);
        courses.add(c2);
        assertEquals(courses,stuE.getCourseList());
        stuE.reset();
    }

    @Test
    void testGetAllCourseMethod(){
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
        assertEquals(students,stuE.getStudentList());
        stuE.reset();
    }

    @Test
    void TestGetAllEnrollment(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        enrollment e1 = new enrollment("s3804689","2020A","cosc2000");
        enrollment e2 = new enrollment("s3804690","2020B","cosc2440");
        ArrayList<enrollment> enrollments = new ArrayList<enrollment>();
        enrollments.add(e1);
        enrollments.add(e2);
        stuE.addEnrollment(e1);
        stuE.addEnrollment(e2);
        assertEquals(enrollments,stuE.getEnrollments_his());
        stuE.reset();
    }

    @Test
    void TestGetAllStudentEnrolledCourse(){
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
        assertEquals(students,stuE.get_stu_enrolled("2021A","cosc2000"));
        stuE.reset();

    }

    @Test
    void TestGetAllCourseaStudentEnrolled(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        Date Dob = new Date(2000,11,7);
        Student s1 = new Student("s3804687","Dat",Dob);
        Date Dob2 = new Date(2000,11,7);
        Student s2 = new Student("s3804690","Dung",Dob2);
        stuE.add_student(s1);
        stuE.add_student(s2);
        course c1 = new course("cosc2000","web programming",12);
        course c2 = new course("cosc2440","further programming",12);
        stuE.add_course(c1);
        stuE.add_course(c2);
        ArrayList<course> courses = new ArrayList<course>();
        courses.add(c1);
        courses.add(c2);
        enrollment e1 = new enrollment("s3804687","2021A","cosc2000");
        enrollment e2 = new enrollment("s3804687","2021A","cosc2440");
        stuE.addEnrollment(e1);
        stuE.addEnrollment(e2);
        assertEquals(courses,stuE.get_course_for_ss("s3804687","2021A"));
        stuE.reset();
    }

    @Test
    void TestDeleteEnrollment(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        enrollment e1 = new enrollment("s3804689","2020A","cosc2000");
        enrollment e2 = new enrollment("s3804690","2020B","cosc2440");
        ArrayList<enrollment> enrollments = new ArrayList<enrollment>();
        enrollments.add(e1);
        stuE.addEnrollment(e1);
        stuE.addEnrollment(e2);
        stuE.delete_enrolment("s3804690","cosc2440","2020B");
        assertEquals(enrollments,stuE.getEnrollments_his());
        stuE.reset();
    }









}
