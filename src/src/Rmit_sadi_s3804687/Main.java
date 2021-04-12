package Rmit_sadi_s3804687;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.ParseException;
import java.util.Date;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException, ParseException {
//        StudentEnrolment stuE = StudentEnrolment.getInstance();
//        stuE.populate_from_default_file("Csv/default.csv");
//        Menu menu = Menu.getInstance();
//
//        menu.main_menu();

        ArrayList<String> a = new ArrayList<String>();
        a.add("0");
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
//
//        ArrayList<String> temp = new ArrayList<String>();
//        temp.addAll(a.subList(0,2));
//        temp.addAll(a.subList(3,a.size()));
//        System.out.println(temp);
        StudentEnrolment stuE = StudentEnrolment.getInstance();
        stuE.Generate_Report("Csv","anotherDefault.csv",a,true);

    }

}
