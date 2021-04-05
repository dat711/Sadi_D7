package Rmit_sadi_s3804687;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;

public class CsvHandler {
    private ArrayList<Scanner> sc_list;
    private ArrayList<ArrayList<String>> headers;
    private ArrayList<String> filenames;
    private static CsvHandler singleton = null;
    private ArrayList<ArrayList<String>> content;

    public ArrayList<Scanner> getSc_list() {
        return sc_list;
    }

    public void setSc_list(ArrayList<Scanner> sc_list) {
        this.sc_list = sc_list;
    }

    public ArrayList<ArrayList<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(ArrayList<ArrayList<String>> headers) {
        this.headers = headers;
    }

    public ArrayList<String> getFilenames() {
        return filenames;
    }

    public void setFilenames(ArrayList<String> filenames) {
        this.filenames = filenames;
    }

    private CsvHandler() {
        this.headers = new ArrayList<ArrayList<String>>();
        this.sc_list = new ArrayList<Scanner>();
        this.filenames = new ArrayList<String>();
    }

    public static CsvHandler get_instance(){
        if (singleton == null){
            singleton = new CsvHandler();
        }
        return singleton;
    }

    private void add_file_name(String File_name){
        File f = new File(File_name);
        boolean Readable = false;
        if(f.exists() && !f.isDirectory()) {
            Readable = true;
        }
        if (Readable){
            this.filenames.add(File_name);
        }
    }

    public void Init_file(String File_name) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(File_name);
        Scanner this_Sc = new Scanner(fis);
        String First_line = this_Sc.nextLine();
        ArrayList<String> this_header = new ArrayList<String>();
        if (First_line.charAt(0) == ','){
            this_header.add("Id");
            String temp = First_line.substring(1);
            First_line = temp;
        }
        String[] parts = First_line.split(",");
        for (int i = 0;i< parts.length;i++){
            this_header.add(parts[i]);
        }
        this.headers.add(this_header);
        this.sc_list.add(this_Sc);
        this.filenames.add(File_name);
    }

    public void print_data(String file_name){
        int index = this.filenames.indexOf(file_name);

        Scanner this_sc = this.sc_list.get(index);
        while (this_sc.hasNextLine()){
            System.out.println(this_sc.nextLine());
        }
    }

    public ArrayList<String[]> get_data(String file_name){
        int index = this.filenames.indexOf(file_name);
        Scanner this_sc = this.sc_list.get(index);
        ArrayList<String[]> returnArr =  new ArrayList<String[]>();

        while(this_sc.hasNextLine()){
            String thisLine = this_sc.nextLine();
            returnArr.add(thisLine.split(","));
        }

        return returnArr;
    }



    public boolean save_Data(String file_name,ArrayList<ArrayList<String>> data,ArrayList<String> headers) throws IOException {
        if (data.get(0).size() != headers.size()){
            System.out.println("The data and the headers have the wrong data shape");
            return false;

        }

        FileWriter csvWriter = new FileWriter(file_name);
        for (int i = 0;i<headers.size();i++){
            csvWriter.append(headers.get(i));
            if (i == headers.size()-1){
                break;
            }
            csvWriter.append(",");
        }

        for (ArrayList<String> row:data){
            csvWriter.append(String.join(",",row));
        }
        csvWriter.flush();
        csvWriter.close();
        return true;
    }
}
