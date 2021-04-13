package Rmit_sadi_s3804687;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;



public class StudentEnrolment {


    private static StudentEnrolment stuE = null;
    private ArrayList<course>  courseList;
    private ArrayList<Student> studentList;
    private ArrayList<String> Semesters;
    private HashMap<String,ArrayList<course>> semester_course;
    private ArrayList<enrollment> enrollments_his;

    private StudentEnrolment() {
//        this.Semester = new String[]{"A","B","C"};
        this.Semesters = new ArrayList<String>();
        this.courseList = new ArrayList<course>();
        this.studentList = new ArrayList<Student>();
        this.semester_course = new HashMap<String,ArrayList<course>>();
        this.enrollments_his = new ArrayList<enrollment>();



    }

    public void reset(){
        stuE = null;
    }

// get semester for displaying
    // tested
    public ArrayList<String> getSemester() {
        return Semesters;
    }
// add semester to schedule future program
    // tested
    public void addSemester(Integer year,String semester){
        String newStr = year.toString()+semester;
        this.Semesters.add(newStr);
    }
// get the hashmap for displaying purpose
    // tested
    public HashMap<String, ArrayList<course>> getSemester_course() {
        return semester_course;
    }


//// Course list represent the available course in the system, the same for studentlist
    // tested
    public ArrayList<course> getCourseList() {
        return courseList;
    }
    //tested
    public ArrayList<Student> getStudentList() {
        return studentList;
    }


    //tested
    public static StudentEnrolment getInstance(){
        if (stuE == null){
            stuE = new StudentEnrolment();
        }
        return stuE;
    }
/////////////// create function for adding course and student
    //tested
    public void add_student(Student s){
        this.studentList.add(s);
    }
    //tested
    public void add_course(course c){
        this.courseList.add(c);
    }




    /// query student and course method, return many student for select with name
    // tested
    public ArrayList<Student> find_student(String mode,String input){
        boolean use_id = true;
        boolean use_name = false;
        if (mode.equals("name")){
            use_id = false;
            use_name = true;
        }
        ArrayList<Student> returnStu = new ArrayList<Student>();


        if (use_id){
            for (int i = 0;i<this.studentList.size();i++){

                if (this.studentList.get(i).getId().equals(input)){
                    returnStu.add(this.studentList.get(i));
                    break;
                }
            }
        }

        if(use_name){
            for (int i = 0;i <this.studentList.size();i++){
                if (this.studentList.get(i).getName().equals(input)){
                    returnStu.add(this.studentList.get(i));
                }
            }
        }
        return  returnStu;
    }
// return course from id or name, allow only one return
    // tested
    public course find_course(String mode,String input){
        boolean use_id = true;
        boolean use_name = false;
        if (mode.equals("name")){
            use_id = false;
            use_name = true;
        }

        course returnCoure  = null;

        if (use_id){
            for (int i = 0;i<this.courseList.size();i++){

                if (this.courseList.get(i).getCouseID().equals(input) ){
                    returnCoure = this.courseList.get(i);
                    break;
                }
            }
        }

        if(use_name){
            for (int i = 0;i <this.courseList.size();i++){
                if (this.courseList.get(i).getCoursename().equals(input)){
                    returnCoure = this.courseList.get(i);
                    break;
                }
            }
        }
        return  returnCoure;
    }

    // get lsist of enrollment
    // tested
    public ArrayList<enrollment> getEnrollments_his() {
        return enrollments_his;
    }
    // tested
    public void addEnrollment(enrollment e){
        this.enrollments_his.add(e);
    }
    // tested
    public void delete_enrolment(String student,String course,String sem){
        ArrayList<enrollment> temp = new ArrayList<enrollment>() ;
        if (this.getEnrollments_his().size() > 1){
            for (int i = 0; i< this.enrollments_his.size();i++){
                enrollment this_e = this.enrollments_his.get(i);
                if ((this_e.getCourseID().equals(course)) && (this_e.getStuID().equals(student) && this_e.getSemester().equals(sem))) {
                    temp.addAll(this.enrollments_his.subList(0,i));
                    temp.addAll(this.enrollments_his.subList(i+1,this.enrollments_his.size()));
                    break;
                }
            }
        }


        this.enrollments_his = temp;
    }
    // tested
    public void addSemeser(String semester){
        if (this.Semesters.contains(semester)){
            System.out.println("this semester are already in the system");
        }
        else {
            this.Semesters.add(semester);
            ArrayList<course> this_sem_c = new ArrayList<course>();
            this.semester_course.put(semester,this_sem_c);
        }

    }


// tested
    public void add_course_to_sem(String courseid,String semester){
        boolean notFound = true;
        int index_course = 0;
        for (int i =0;i<this.courseList.size();i++){
            course temp = this.courseList.get(i);
            if (temp.getCouseID().equals(courseid)){
                notFound = false;
                index_course = i;
                break;
            }
        }


        if (this.Semesters.contains(semester)){
            if (notFound){
                System.out.println("This course is not available on the sys tem");
            }

            else {
                ArrayList<course> temp_sem = this.semester_course.get(semester);
                boolean in_Sem = false;
                for (int i = 0;i < temp_sem.size();i++){
                    if (temp_sem.get(i).getCouseID().equals(courseid)){
                        System.out.println("the course are already added to the systems");
                        break;
                    }
                }
                if (!in_Sem){
                    temp_sem.add(this.courseList.get(index_course));
                }
                this.semester_course.put(semester,temp_sem);

            }
        }
        else {
            System.out.println("the semester is not on the systems ");
        }

    }
    // tested
    public ArrayList<enrollment> get_enrolment(String student,String course,String semester){
        boolean notfound = true;
        ArrayList<enrollment> returnEnroll = new ArrayList<enrollment>();
//        enrollment returnEnroll = new enrollment();
        for (int i = 0; i< this.enrollments_his.size();i++){
            enrollment this_e = this.enrollments_his.get(i);

            if ((this_e.getCourseID().equals(course) ) && (this_e.getStuID().equals(student)) && (this_e.getSemester().equals(semester))) {
                returnEnroll.add(this_e) ;
                notfound = false;
                break;
            }
        }
        if (notfound){
            System.out.println("didn't found the enrollment");
        }
        return returnEnroll;
    }
    // tested
    public ArrayList<course> get_course_for_ss(String sid,String semester){
//        System.out.println("have called");
        ArrayList<course> returnCourses = new ArrayList<course>();
        ArrayList<String> courseid = new ArrayList<String>();
        for (int i = 0; i < this.enrollments_his.size();i++){
            enrollment this_e = this.enrollments_his.get(i);
            if ((this_e.getStuID().equals(sid)) && (this_e.getSemester().equals(semester))){
                courseid.add(this_e.getCourseID());
//                System.out.println("found a course");
            }
        }
//        System.out.println(courseid);

        for (int i = 0;i<this.courseList.size();i++){
            course this_course = this.courseList.get(i);
            if(courseid.contains(this_course.getCouseID())){
                returnCourses.add(this_course);
            }
        }
        return  returnCourses;
    }
    // tested
    public ArrayList<course> get_course_Avai_for_sem(String semester){
        return this.semester_course.get(semester);
    }

    //
    public ArrayList<Student> get_stu_enrolled(String semester,String courseid){
        ArrayList<String> stuId = new ArrayList<String>();
        ArrayList<Student> stu = new ArrayList<Student>();
        for (int i = 0;i < this.enrollments_his.size();i++){
            enrollment this_e = this.enrollments_his.get(i);
            if ((this_e.getCourseID().equals(courseid)) && (this_e.getSemester().equals(semester))){
                stuId.add(this_e.getStuID());
            }
        }

        for (int i = 0; i < this.studentList.size();i++){
            Student this_Stu = this.studentList.get(i);
            if (stuId.contains(this_Stu.getId())){
                stu.add(this_Stu);
            }
        }

        return stu;
    }


    public boolean populate_from_default_file(String FileName) throws IOException,ParseException{
        File f = new File(FileName);
        boolean readable = f.exists() && !f.isDirectory();
        if (!readable){
            System.out.println("the file is not detected by the systems");
            return false;
        }else {
            Scanner sc = new Scanner(f);
            sc.useDelimiter(",");
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                populateFromData(data);
            }
            sc.close();

        }
        return true;
    }

    private static void populateFromData(String data) throws ParseException{
        StudentEnrolment stuE = StudentEnrolment.getInstance();

        String[] StrL = data.split(",");
        String sid = StrL[0];
        String sname = StrL[1];
        String dobStr = StrL[2];
        String cid = StrL[3];
        String cname = StrL[4];
        String credit = StrL[5];
        String semester = StrL[6];
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String[] dobList = dobStr.split("/");
        String month = dobList[0];
        String day = dobList[1];
        String year = dobList[2];
        if (month.length() == 1){
            month = "0"+month;
        }
        if (day.length() == 0){
            day = "0"+day;
        }
        String FinalDay = day+"-"+month+"-"+year;
        Date dob = formatter.parse(FinalDay);
        if (stuE.find_student("id",sid).size() == 0){
            Student s = new Student(sid,sname,dob);
            stuE.add_student(s);
        }
        boolean exist = false;
        for(int i = 0;i< stuE.getCourseList().size();i++){
            if (stuE.getCourseList().get(i).getCouseID().equals(cid)){
                exist = true;
                break;
            }
        }
        course c = new course(cid,cname,Integer.parseInt(credit));
        if(!exist){
            stuE.add_course(c);
        }

        if (stuE.getSemester_course().containsKey(semester)){

            boolean added = false;
            for(int i =0;i< stuE.getSemester_course().get(semester).size();i++){
                if (stuE.getSemester_course().get(semester).get(i).getCouseID().equals(cid)){
                    added = true;
                    break;
                }
            }
            if (!added){
                stuE.add_course_to_sem(cid,semester);
            }
        }else {
            if (!stuE.getSemester().contains(semester)){
                stuE.addSemeser(semester);
            }
            ArrayList<course> MTC = new ArrayList<course>();
            MTC.add(c);
            stuE.getSemester_course().put(semester,MTC);
        }

        enrollment e = new enrollment(sid,semester,cid);
        stuE.addEnrollment(e);
    }


    public boolean Generate_Report(String Dirname,String Filename,ArrayList<String> data,boolean newline) throws IOException{
        File f = new File(Dirname);
        if (!f.exists() && !f.isDirectory()){
            System.out.println("this directory is not exists, double check your path please");
            return false;
        }

        String path = Dirname+"/"+Filename;

        try {
            File myobj = new File(path);
            if (myobj.createNewFile()){
                System.out.println("file created");
            }
            else {
                System.out.println("this file is already exist");
            }
            FileWriter fw = new FileWriter(path);
            String listString = "";
            if (!newline){

                for (int i = 0;i<data.size();i++){
                    listString  = listString +data.get(i);
                    if (i != data.size()-1 ){
                        listString  = listString+",";
                    }
                }

                fw.write(listString);
            }else {
                for (int i = 0;i<data.size();i++){
                    fw.write(data.get(i));
                    fw.write("\n");
                    }
            }


            fw.close();
        }catch (IOException e){
            System.out.println("Problem occured");
            e.printStackTrace();
            return false;
        }

    return true;
    }
}
