package Rmit_sadi_s3804687;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;


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


    // main menu
    public void main_menu() throws ParseException{
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
                enrollment_Menu();
            }
            if (choice.equals("4")){
                break;
            }
        }

    }

    // student menu


    // main menu for student management
    public void studentMenu() throws ParseException{
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
                ViewALlStudent();
            }
            if (choice.equals("5")){
                break;
            }
        }
    }

    // adding student menu
    private boolean adding_student_menu() throws ParseException {
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
            if (m < 10){
                month = "0"+month;
            }
            if (d < 10){
                day = "0"+day;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String finalStr = day+"/"+month + "/"+year;
            Date dob = formatter.parse(finalStr);
            Student newS = new Student(id,name,dob);
            stuE.add_student(newS);

            if (!getback("add student")){
                System.out.println("run 9");
                keepLoop = false;
            }
        }
        return true;
    }

    // function for brwose and search student profile
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



    // View all student
    private static void ViewALlStudent(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        if (stuE.getStudentList().size() == 0){
            System.out.println("There are no student in the system");
        }
        else {
            for (int i = 0; i< stuE.getStudentList().size();i++){
                System.out.println(stuE.getStudentList().get(i));
            }
        }

    }

    // Course Menu

    // Main course menu
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
                break;
            }
            if (choice.equals("5")){
                break;
            }
        }

    }


    // add course menu
    private static boolean add_course(){
        System.out.println("Adding coure menu ");
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        System.out.println("Please type in the course id");
        String cid = sc.next();
        boolean overlap = false;
        for (int i = 0;i<stuE.getCourseList().size();i++){
            if (stuE.getCourseList().get(i).getCouseID().equals(cid)){
                overlap = true;
                break;
            }
        }

        if (overlap){
            System.out.println("This course ID is already exists");
            return false;
        }

        System.out.println("please type in the course name");
        String cname = sc.next();
        System.out.println("Please type in the credit number of this course");
        String credit = sc.next();
        boolean parsable = validationHandler.isInteger(credit);
        while (!parsable){
            System.out.println("your credit input is not valid, please retype the credit num");
            credit = sc.next();
            parsable = validationHandler.isInteger(credit);
        }

        course newc = new course(cid,cname,Integer.parseInt(credit));

        stuE.add_course(newc);

        return true;
    }

    // function to add the user to redo a task they are doing
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


    // enrollment menu

    // main enrollment menu
    private static void enrollment_Menu(){
        System.out.println("welcome to student Menu");
        System.out.println("type 1 to add a new enrollment");
        System.out.println("type 2 to view a enrollment");
        System.out.println("type 3 to generate an enrollment report");
        System.out.println("type 4 to view all enrollment ");
        System.out.println("type 5 to browse a student enrollment ");
        System.out.println("type 6 to view offered course at a semeter ");
        System.out.println("type 7 to update enrollment of a student in a semeter");
        System.out.println("type 8 to quit ");
        System.out.println("please type here");

        ArrayList<String> validIn = new ArrayList<String>();
        validIn.add("1");
        validIn.add("2");
        validIn.add("3");
        validIn.add("4");
        validIn.add("5");
        validIn.add("6");
        validIn.add("7");
        validIn.add("8");
        validIn.add("9");


        String choice = sc.next();

        while (!validIn.contains(choice)){
            System.out.println("your input is invalid please retype");
            choice = sc.next();
        }
        if (choice.equals("1")){
//            this.adding_student_menu();
        }
        if (choice.equals("2")){
            view_student_profile();
            if(!getback("using student menu")){
//                break;
            }
        }
        if(choice.equals("3")){
            System.out.println("type in the folder");

        }
        if (choice.equals("4")){
            View_all_enrollment();
        }
        if (choice.equals("5")){
//            View_course_of_Student_Sem();
        }
        if (choice.equals("6")){
            getCourseOffered();
        }
        if (choice.equals("7")){
            getCourseOffered();
        }
        if (choice.equals("8")){
            System.out.println("8");
        }
        if (choice.equals("9")){
            getCourseOffered();
        }
        if (choice.equals("10")){
            getCourseOffered();
        }
        if (choice.equals("11")){
            getCourseOffered();
        }

    }



    // funtion for adding enrollment

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


    // function for browing and view a enrollment
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

    // function for view all enrollment

    private static void View_all_enrollment(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        for (int i = 0;i< stuE.getEnrollments_his().size();i++){
            System.out.println(stuE.getEnrollments_his().get(i));
        }
    }

    // funtion for view courses list a student enroll in a semester

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


    // function to view list of students enrolled a course in a semester
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

    // function to view course offered to a student in a semester
    private static boolean getCourseOffered(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        System.out.println("please enter the semester you are looking for");
        String sem = sc.next();
        System.out.println();
        ArrayList<course> thiOffer = stuE.get_course_Avai_for_sem(sem);

        thiOffer.forEach(course -> {
            System.out.println(course.getCoursename());
        });
        return true;
    }

    // function to update course offered for a semester

    private static  boolean updateCourseOffered(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        System.out.println("Update course offered menu");
        System.out.println("please type in the semester you want to have courses offered update");
        String sem = sc.next();
        while (!stuE.getSemester().contains(sem)){
            System.out.println("your semester is not on the systems yet ?");
            if (getback("update course offered")){
                return updateCourseOffered();
            }else {
                return false;
            }
        }
        System.out.println("Here are the course that your system offered in the semester "+sem);
        for(int i =0;i<stuE.get_course_Avai_for_sem(sem).size();i++){
            System.out.println(stuE.get_course_Avai_for_sem(sem).get(i));
        };

        System.out.println("Please pick an action to do");
        System.out.println("type 1 to delete a course from the offered list of this semeter");
        System.out.println("type 2 to add a course to the offered list of this semester");
        System.out.println("type 3 if you want to quit this function");
        String choice = sc.next();

        switch (choice){
            default:
                System.out.println("your choice is not valid");
                if (getback("update course offered")){
                    return updateCourseOffered();
                } else return false;
            case "1":
                System.out.println("pleae type in the courses id you want to delete");
                String cid = sc.next();
                while (!stuE.get_course_Avai_for_sem(sem).contains(cid)){
                    System.out.println("Your ID is not in the planned course of this semester ");
                    if (getback("update course offered")){
                        return updateCourseOffered();
                    }else return false;
                }
                ArrayList<course> temp = new ArrayList<course>();
                for (int i = 0;i <stuE.get_course_Avai_for_sem(sem).size();i++){
                    course this_c = stuE.get_course_Avai_for_sem(sem).get(i);
                    if (this_c.getCouseID().equals(cid)){
                        temp.addAll(stuE.get_course_Avai_for_sem(sem).subList(0,i));
                        temp.addAll(stuE.get_course_Avai_for_sem(sem).subList(i+1,stuE.get_course_Avai_for_sem(sem).size() -1));
                    }
                }
                stuE.getSemester_course().put(sem,temp);
            case "2":
                System.out.println("pleae type in the courses id you want to delete");
                String addid = sc.next();
                while (stuE.get_course_Avai_for_sem(sem).contains(addid)){
                    System.out.println("Your ID is already in the planned course of this semester ");
                    if (getback("update course offered")){
                        return updateCourseOffered();
                    }else return false;
                }
                boolean exist = false;

                for (int i = 0;i < stuE.getCourseList().size();i++){
                    course this_course = stuE.getCourseList().get(i);
                    if (this_course.getCouseID().equals(addid)){
                        exist = true;
                    }
                }

                if (!exist){
                    System.out.println("your course id is not available in the system yet");
                    if (getback("update course offered")){
                        return updateCourseOffered();
                    }else {
                        return false;
                    }
                }

                ArrayList<course> temps = stuE.get_course_Avai_for_sem(sem);
                course addCourse = stuE.find_course("id",addid);
                temps.add(addCourse);
                stuE.getSemester_course().put(sem,temps);


            case "3":
                break;

        }
        return true;

    }

    // function to update course a student enrolled in a semester

    private static boolean updateStudentEnrolled(){
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        System.out.println("Update enrollment of student:");
        System.out.println("please type in the student ID");
        String sid = sc.next();
        if (stuE.find_student("id",sid).size() == 0){
            System.out.println("your student id is not exist");
            if (getback("update a student enrollment")){
                return updateStudentEnrolled();
            }else return false;
        }



        System.out.println("please type in the semester");
        String sem = sc.next();
        if (!stuE.getSemester().contains(sem)){
            System.out.println("your semester is not on the systems");
            if (getback("update student Enrolled")){
                return updateStudentEnrolled();
            }else {
                return false;
            }
        }

        boolean deletable = true;
        if (stuE.get_course_for_ss(sid,sem).size() == 0){
            System.out.println("this student haven't enrolled any course in semester "+sem);
            deletable = false;
        }else {
            System.out.println("This is the course thí student have enrolled");
            for (int i = 0;i<stuE.get_course_for_ss(sid,sem).size();i++){
                System.out.println(stuE.get_course_for_ss(sid,sem).get(i));
            }
        }

        System.out.println("Please type in a function for the system to activate ");
        System.out.println("type 1 for adding a new course");
        System.out.println("type 2 for deleting a course");
        System.out.println("type 3 to quit");
        String choice = sc.next();
        switch (choice){
            default:
                System.out.println("your input is not match any valid input value");
                if (getback("update student Enrolled")){
                    return updateStudentEnrolled();
                }else return false;

            case "1":
                System.out.println("please type in the courseID");
                String cid = sc.next();
                if (!stuE.get_course_Avai_for_sem(sem).contains(cid)){
                    System.out.println("the system is not offered the course in this semesters");
                    if (getback("update student Enrolled")){
                        return updateStudentEnrolled();
                    }else return false;
                };
                enrollment adde = new enrollment(sid,sem,cid);
                stuE.addEnrollment(adde);
                break;

            case "2":
                if (!deletable){
                    System.out.println("There are no course to delete ");
                    if (getback("update student Enrolled")){
                        return updateStudentEnrolled();
                    }else return false;
                }
                System.out.println("please type in the course id you want to delete");
                String delCid = sc.next();
                if (!stuE.get_stu_enrolled(sid,sem).contains(delCid)){
                    System.out.println("the student with the id "+sid+" did not enroll the course with id "+delCid+" in the semester "+sem);
                    if (getback("update student Enrolled")){
                        return updateStudentEnrolled();
                    }return false;
                }
                stuE.delete_enrolment(sid,delCid,sem);
                break;

            case "3":
                break;
        }
        return true;
    }


}
