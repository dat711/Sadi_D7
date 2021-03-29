package Rmit_sadi_s3804687;

public class course {
    private   String CouseID;
    private String Coursename;
    private int num_credit ;

    public course(String couseID, String coursename, int num_credit) {
        CouseID = couseID;
        Coursename = coursename;
        this.num_credit = num_credit;
    }

    public String getCouseID() {
        return CouseID;
    }

    public void setCouseID(String couseID) {
        CouseID = couseID;
    }

    public String getCoursename() {
        return Coursename;
    }

    public void setCoursename(String coursename) {
        Coursename = coursename;
    }

    public int getNum_credit() {
        return num_credit;
    }

    public void setNum_credit(int num_credit) {
        this.num_credit = num_credit;
    }

    @Override
    public String toString() {
        return "course{" +
                "CouseID='" + CouseID + '\'' +
                ", Coursename='" + Coursename + '\'' +
                ", num_credit=" + num_credit +
                '}';
    }



}
