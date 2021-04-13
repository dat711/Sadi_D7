package Rmit_sadi_s3804687;

public class enrollment {
    private String stuID;
    private String Semester;
    private String courseID;

    public enrollment(String stuID, String semester, String courseID) {
        this.stuID = stuID;
        this.Semester = semester;
        this.courseID = courseID;
    }

    public String getStuID() {
        return stuID;
    }


    public String getSemester() {
        return Semester;
    }


    public String getCourseID() {
        return courseID;
    }


    @Override
    public String toString() {
        return "enrollment{" +
                "stuID='" + stuID + '\'' +
                ", Semester='" + Semester + '\'' +
                ", courseID='" + courseID + '\'' +
                '}';
    }
}
