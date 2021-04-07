package Rmit_sadi_s3804687;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Menu {
    private static Menu singleton = null;
    private static validationHandler valH;
    private Menu(){
        this.valH = validationHandler.getInstance();
    }
    private static Scanner sc=new Scanner(System.in);

    public static Menu getInstance(){
        if(singleton == null ){
            singleton = new Menu();
        }
        return singleton;
    }

    public void main_menu(){
        boolean notexit = true;

        while (notexit){
            System.out.println("Welcome to the Main menu please Choose a menu to move to");
            System.out.println("type 1 to move to student management menu");
            System.out.println("type 2 to move to course management menu");
            System.out.println("type 3 to move to enrollment menu");
            System.out.println("type 4 to quit");

            ArrayList<String> validInput = new ArrayList<String>();
            validInput.add("1");
            validInput.add("2");
            validInput.add("3");
            validInput.add("4");


            String choice = sc.next();
            while (!validInput.contains(choice)){
                System.out.println("your input is invalid");
                System.out.println("Please enter your choice");
                choice = sc.next();
            }
            if (choice.equals("1")){
                this.studentMenu();
            }

            if (choice.equals("2"))
                this.CourseMenu();

            if (choice.equals("3")){
                break;
            }
            if (choice.equals("4")){
                break;
            }
        }

    }

    private static void viewAllStudent(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        for(int i =0;i<stuE.getStudentList().size();i++){
            System.out.println(stuE.getStudentList().get(i));
        }
        System.out.println("\n\n");
    }

    public void studentMenu(){
        boolean stay = true;
        while (stay){
            System.out.println("welcome to student Menu");
            System.out.println("type 1 to add a new student");
            System.out.println("type 2 to view a student profile");
            System.out.println("type 3 to generate student report");
            System.out.println("type 4 to view all student's basic infomation ");
            System.out.println("type 5 to quit ");
            System.out.println("please type here");

            ArrayList<String> validIn = new ArrayList<String>();
            validIn.add("1");
            validIn.add("2");
            validIn.add("3");
            validIn.add("4");
            validIn.add("5");

            String choice = sc.next();

            while (!validIn.contains(choice)){
                System.out.println("your input is invalid please retype");
                choice = sc.next();
            }
            if (choice.equals("1")){
                this.adding_student_menu();
            }
            if (choice.equals("2")){
                view_student_profile();
                if(!getback("using student menu")){
                    break;
                }
            }
            if(choice.equals("3")){
                System.out.println("type in the folder");

            }
            if (choice.equals("4")){
                break;
            }
            if (choice.equals("5")){
                break;
            }
        }
    }
    private boolean adding_student_menu(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        boolean keepLoop = true;

        while (keepLoop){
            System.out.println("please type in the student name");
            String name = sc.next();
            System.out.println("please type in the student ID");
            String id = sc.next();
            if (!valH.valid_stuID(id)){
                System.out.println(valH.valid_stuID(id));
                System.out.println("your id input is ot having appropriate format");
                if (getback("add student")){
                    System.out.println("run 1");
                    return adding_student_menu();
                }
                else return false;
            }
            System.out.println(stuE.getStudentList());
            if(stuE.find_student("id",id).size() > 0){

                System.out.println("the id already exist");
                if(getback("add student")){
                    System.out.println("run 2");
                    return adding_student_menu();
                }
                else return false;
            }
            System.out.println("please type in the student date of birth");
            System.out.println("this student were born at day: ");
            String day = sc.next();
            if (!validationHandler.isInteger(day)){
                System.out.println("came here");
                if (getback("add student")){
                    System.out.println("run 3");
                    return adding_student_menu();
                }
                else return false;
            }
            int d = Integer.parseInt(day);
            System.out.println("got d as "+d);
            if (d < 1 || d > 31) {
                System.out.println("come to check day range");
                System.out.println("your day input is out of valid range");
                if (getback("add student")) {
                    System.out.println("run 4");
                    return adding_student_menu();
                }
                else return false;
            }
            System.out.println("please type in the month this student were born (a number)");
            String month = sc.next();
            if (!validationHandler.isInteger(month)){
                System.out.println("your month input should be a number");
                if(getback("add student")){
                    System.out.println("run 5");
                    return adding_student_menu();
                }
                else return false;
            }
            int m = Integer.parseInt(month);
            if (m <1 || m > 12){
                System.out.println("your month input is out of valid range");
                if(getback("add student")){
                    System.out.println("run 6");
                    return adding_student_menu();
                }
                else return false;
            }
            System.out.println("please type in the year this student were born");
            String year = sc.next();
            if (!validationHandler.isInteger(year)){
                System.out.println("your year input is not a number");
                if(getback("add student")){
                    System.out.println("run 7");
                    return adding_student_menu();
                }
                else return false;
            }
            int y = Integer.parseInt(year);
            Date dd = new Date();
            if (y < 1950 || y >dd.getYear() + 1882  ){
                System.out.println("your year input is ot of valid age range the student age should be more than 18");
                if (getback("add student")){
                    System.out.println("run 8");
                    return adding_student_menu();
                }
                else return false;
            }
            Date dob = new Date(y,m,d);
            Student newS = new Student(id,name,dob);
            stuE.add_student(newS);

            if (!getback("add student")){
                System.out.println("run 9");
                keepLoop = false;
            }
        }
        return true;
    }

    private static void view_student_profile(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        System.out.println("please type in the student id that you want to view");
        String id = sc.next();
        if (stuE.find_student("id",id).size() == 0){
            System.out.println("this student is not exist in the systems");
        }
        else {
            System.out.println("this student info is");
            System.out.println(stuE.find_student("id",id).get(0));
            System.out.println("These are enrollments this student made");
            for(int i = 0;i<stuE.getEnrollments_his().size();i++){
                if (stuE.getEnrollments_his().get(i).getStuID().equals(id)){
                    System.out.println(stuE.getEnrollments_his().get(i));
                }
            }
        }
        System.out.println("\n\n");


    }
    public void CourseMenu(){
        boolean stay = true;
        while (stay){
            System.out.println("welcome to course Menu");
            System.out.println("type 1 to add a new course");
            System.out.println("type 2 to view a course profile");
            System.out.println("type 3 to generate course report");
            System.out.println("type 4 to quit ");
            System.out.println("please type here");

            ArrayList<String> validIn = new ArrayList<String>();
            validIn.add("1");
            validIn.add("2");
            validIn.add("3");
            validIn.add("4");
            validIn.add("5");
            validIn.add("6");
            String choice = sc.next();

            while (!validIn.contains(choice)){
                System.out.println("your input is invalid please retype");
                choice = sc.next();
            }
            if (choice.equals("1")){
                System.out.println("add a student");
            }
            if (choice.equals("2")){
                System.out.println("view who");
            }
            if(choice.equals("3")){
                System.out.println("type in the folder");

            }
            if (choice.equals("4")){
                System.out.println("4");
            }
            if (choice.equals("5")){
                break;
            }
        }

    }

    private static boolean getback(String action){
        System.out.println("Do you want to redo " + action+" (Y/N)");
        String ans = sc.next();
        if (ans.toLowerCase().equals("y")){
            return true;
        }
        if (ans.toLowerCase().equals("n")){
            return false;
        }

        System.out.println("your input is incorrect, please type again");
        return getback(action);
    }

    private static void enrollment_Menu(){
        System.out.println("welcome to student Menu");
        System.out.println("type 1 to add a new enrollment");
        System.out.println("type 2 to view a enrollment");
        System.out.println("type 3 to generate an enrollment report");
        System.out.println("type 4 to view all enrollment ");
        System.out.println("type 5 to quit ");
        System.out.println("please type here");

        ArrayList<String> validIn = new ArrayList<String>();
        validIn.add("1");
        validIn.add("2");
        validIn.add("3");
        validIn.add("4");
        validIn.add("5");
    }

    private static boolean adding_enrollment(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        System.out.println("Welcome to adding enrollment");
        System.out.println("Please input the student Id :");
        String id = sc.next();
        if (stuE.find_student("id",id).size() == 0){
            System.out.println("This student id is not on the systems ");
            if (getback("adding enrollment")){
                return adding_enrollment();
            }
            else {
                return false;
            }
        }
        System.out.println("please type in the course Id");
        String cid = sc.next();
        boolean coursenotExist = true;
        for (int i = 0; i< stuE.getCourseList().size();i++){
            if (stuE.getCourseList().get(i).getCouseID().equals(cid)){
                coursenotExist = false;
                break;
            }
        }

        if (coursenotExist){
            System.out.println("the courseID is not existed");
            if(getback("adding enrollment")){
                return adding_enrollment();
            }else {
                return false;
            }
        }

        System.out.println("please type in the semester");
        String semester = sc.next();

        if(!stuE.getSemester().contains(semester)){
            System.out.println("the semeter does not exist in the system yet, please double check");
            if(getback("adding enrollment")){
                return adding_enrollment();
            }else {
                return false;
            }
        }

        enrollment e = new enrollment(id,cid,semester);
        stuE.addEnrollment(e);
        return true;
    }

    private static void View_a_enrollment(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        System.out.println("please type in the student id");
        String id = sc.next();
        System.out.println("please type in the coure id");
        String cid = sc.next();
        System.out.println("please type in the semester");
        String semester = sc.next();
        ArrayList<enrollment> enr = stuE.get_enrolment(id,cid,semester);
        if (enr.size() == 0){
            System.out.println("there are no match of your input");
        }

    }

    private static void View_all_enrollment(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        for (int i = 0;i< stuE.getEnrollments_his().size();i++){
            System.out.println(stuE.getEnrollments_his().get(i));
        }
    }

    private static boolean View_course_of_Student_Sem(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        System.out.println("Let type in the student ID that you're looking for");
        System.out.println("Let enter the student ID");
        String id = sc.next();
        if (stuE.find_student("id",id).size() == 0 ){
            System.out.println("the student haven't been add to the system yet");
            if (getback("view all courses of a student")){
                return View_course_of_Student_Sem();
            }else return false;
        }

        System.out.println("Let enter the semester");
        String sem = sc.next();

        if (!stuE.getSemester().contains(sem)){
            if (getback("view all courses of a student")){
                return View_course_of_Student_Sem();
            }else return false;
        }

        if (stuE.get_course_for_ss(id,sem).size() == 0){
            System.out.println("the student doesn't have a course in this semester");
        }else {
            for (int i = 0;i<stuE.get_course_for_ss(id,sem).size();i++){
                System.out.println(stuE.get_course_for_ss(id,sem));
            }
        }
        return true;
    }

    private static boolean View_Course_enrolled_in_a_sem(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        System.out.println("Let type in the course ID and semester that you're looking for");
        System.out.println("Let enter the coure ID");
        String cid = sc.next();
        boolean coursenotExist = true;
        for (int i = 0; i< stuE.getCourseList().size();i++){
            if (stuE.getCourseList().get(i).getCouseID().equals(cid)){
                coursenotExist = false;
                break;
            }
        }

        if (coursenotExist){
            System.out.println("the courseID is not existed");
            if(getback("adding enrollment")){
                return View_Course_enrolled_in_a_sem();
            }else {
                return false;
            }
        }

        System.out.println("Let enter the semester");
        String sem = sc.next();

        if (!stuE.getSemester().contains(sem)){
            if (getback("view all courses of a student")){
                return View_Course_enrolled_in_a_sem();
            }else return false;
        }

        if (stuE.get_stu_enrolled(sem,cid).size() == 0){
            System.out.println("the student doesn't have a course in this semester");
        }else {
            for (int i = 0;i<stuE.get_stu_enrolled(sem,cid).size();i++){
                System.out.println(stuE.get_stu_enrolled(sem,cid).get(i));
            }
        }
        return true;
    }








//    private add_stu(){
//
//    }
}
