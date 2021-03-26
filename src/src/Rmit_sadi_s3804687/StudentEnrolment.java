package Rmit_sadi_s3804687;

public class StudentEnrolment {
    private static StudentEnrolment stuE = null;
    private StudentEnrolment() {
    }

    public static StudentEnrolment getInstance(){
        if (stuE == null){
            stuE = new StudentEnrolment();
        }
        return stuE;
    }


}
