package Rmit_sadi_s3804687;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentEnrolment {

    /* the attribute name and explanied
    stuE is used as the only instance of this class
    courseList store the available course on the system
    studentlist store the available student on the system
    Semesters store all the semesters that stored on the systems
    semester_course store a pair of semester and list of available course in that semester
    enrollmentStudentHashMap store data about the student list enrolled to a course at a specific semester
    courseEnrolled store data about the course a student enrolled at a specific semester
    * */
    private static StudentEnrolment stuE = null;
    private ArrayList<course> courseList;
    private ArrayList<Student> studentList;
    private ArrayList<String> Semesters;
    private HashMap<String,ArrayList<course>> semester_course;

    private HashMap<keyEnrollment,ArrayList<Student>> enrollmentStudentHashMap;
    private HashMap<EnrollBySem,ArrayList<course>> courseEnrolled;
    private StudentEnrolment() {
//        this.Semester = new String[]{"A","B","C"};
        this.Semesters = new ArrayList<String>();
        this.courseList = new ArrayList<course>();
        this.studentList = new ArrayList<Student>();
        this.semester_course = new HashMap<String,ArrayList<course>>();
        this.enrollmentStudentHashMap = new HashMap<keyEnrollment,ArrayList<Student>>();
        this.courseEnrolled = new HashMap<EnrollBySem,ArrayList<course>>();


    }

//////// Hashmap for the pair of list_course and semester

    public ArrayList<String> getSemester() {
        return Semesters;
    }

    public void addSemester(Integer year,String semester){
        String newStr = year.toString()+semester;
        this.Semesters.add(newStr);
    }

    public HashMap<keyEnrollment, ArrayList<Student>> getEnrollmentStudentHashMap() {
        return enrollmentStudentHashMap;
    }

    public HashMap<EnrollBySem, ArrayList<course>> getCourseEnrolled() {
        return courseEnrolled;
    }

    public HashMap<String, ArrayList<course>> getSemester_course() {
        return semester_course;
    }


//// Course list represent the available course in the system, the same for studentlist
    public ArrayList<course> getCourseList() {
        return courseList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }



    public static StudentEnrolment getInstance(){
        if (stuE == null){
            stuE = new StudentEnrolment();
        }
        return stuE;
    }
/////////////// create function for course and student
    public void add_student(Student s){
        this.studentList.add(s);
    }

    public void add_course(course c){
        this.courseList.add(c);
    }


/// query student and course method
    public ArrayList<Student> find_student(String mode,String input){
        boolean use_id = true;
        boolean use_name = false;
        if (mode == "name"){
            use_id = false;
            use_name = true;
        }
        ArrayList<Student> returnStu = new ArrayList<Student>();


        if (use_id){
            for (int i = 0;i<this.studentList.size();i++){

                if (this.studentList.get(i).getId() == input){
                    returnStu.add(this.studentList.get(i));
                    break;
                }
            }
        }

        if(use_name){
            for (int i = 0;i <this.studentList.size();i++){
                if (this.studentList.get(i).getName() == input){
                    returnStu.add(this.studentList.get(i));
                }
            }
        }
        return  returnStu;
    }

    public course find_course(String mode,String input){
        boolean use_id = true;
        boolean use_name = false;
        if (mode == "name"){
            use_id = false;
            use_name = true;
        }

        course returnCoure  = null;

        if (use_id){
            for (int i = 0;i<this.courseList.size();i++){

                if (this.courseList.get(i).getCouseID() == input){
                    returnCoure = this.courseList.get(i);
                    break;
                }
            }
        }

        if(use_name){
            for (int i = 0;i <this.courseList.size();i++){
                if (this.courseList.get(i).getCoursename() == input){
                    returnCoure = this.courseList.get(i);
                    break;
                }
            }
        }
        return  returnCoure;
    }


}
