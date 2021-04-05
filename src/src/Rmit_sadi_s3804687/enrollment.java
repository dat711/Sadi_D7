package Rmit_sadi_s3804687;

public class enrollment {
    private String stuID;
    private String Semester;
    private String courseID;

    public enrollment() {
    }

    public enrollment(String stuID, String semester, String courseID) {
        this.stuID = stuID;
        this.Semester = semester;
        this.courseID = courseID;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
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
