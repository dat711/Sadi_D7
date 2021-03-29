package Rmit_sadi_s3804687;

public class keyEnrollment {
    private course course;
    private String semester;

    public keyEnrollment(Rmit_sadi_s3804687.course course, String semester) {
        this.course = course;
        this.semester = semester;
    }

    public Rmit_sadi_s3804687.course getCourse() {
        return course;
    }

    public void setCourse(Rmit_sadi_s3804687.course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
