package Rmit_sadi_s3804687;

import java.util.ArrayList;

public class StudentEnrolment {
    private static StudentEnrolment stuE = null;
    private ArrayList<course> courseList;
    private ArrayList<Student> studentList;
    private String[] Semester;

    private StudentEnrolment() {
        this.Semester = new String[]{"A","B","C"};
        this.courseList = new ArrayList<course>();
        this.studentList = new ArrayList<Student>();

    }

    public ArrayList<course> getCourseList() {
        return courseList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public String[] getSemester() {
        return Semester;
    }

    public static StudentEnrolment getInstance(){
        if (stuE == null){
            stuE = new StudentEnrolment();
        }
        return stuE;
    }

    public void add_student(Student s){
        this.studentList.add(s);
    }

    public void add_course(course c){
        this.courseList.add(c);
    }



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
