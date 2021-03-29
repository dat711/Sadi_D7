package Rmit_sadi_s3804687;

public class EnrollBySem {
    private Student student;
    private String semester;

    public EnrollBySem(Student student, String semester) {
        this.student = student;
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
