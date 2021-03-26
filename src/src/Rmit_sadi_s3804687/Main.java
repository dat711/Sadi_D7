package Rmit_sadi_s3804687;

import java.util.Date;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  FileNotFoundException {
//        ArrayList<String> list_name = new ArrayList<String>();
//        list_name.add("aaaa");
//        System.out.println(list_name.indexOf("aaaa"));
        CsvHandler ch = CsvHandler.get_instance();
        ch.get_header("./Csv/us_stock.csv");
        System.out.println(ch.getFilenames().indexOf("./Csv/us_stock.csv"));
        Scanner sc = ch.getSc_list().get(0);
        ch.print_data("./Csv/us_stock.csv");


    }

}
