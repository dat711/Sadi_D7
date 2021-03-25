package Rmit_sadi_s3804687;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String Id;
    private String name;
    private Date Dob;

    public Student() {
    }

    public Student(String id, String name, Date dob) {
        Id = id;
        this.name = name;
        Dob = dob;
    }

    public Student(String id, String name) {
        Id = id;
        this.name = name;
    }

    public Student(Student s){
        this.Dob = s.getDob();
        this.name = s.getName();
//        this.Id = s.getId();
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date dob) {
        Dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", Dob=" + Dob +
                '}';
    }
}
