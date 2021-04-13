package Rmit_sadi_s3804687;

public class validationHandler {
    private static validationHandler singleton = null;
    private validationHandler(){}
    public static validationHandler getInstance (){
        if(singleton == null){
            singleton = new validationHandler();
        }
        return singleton;
    }


    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    // tested
    public boolean valid_stuID(String stuid){

        if (stuid.substring(0,1).toLowerCase().equals("s")){
            if (stuid.length() != 8){
//                System.out.println("condition 1 active");
                return false;
            }
            if(!isInteger(stuid.substring(1))){
//                System.out.println("condition 2 active");
                return false;
            }
        } else {
            if (!isInteger(stuid)){
//                System.out.println("condition 3 active");
                return false;
            }
            if (stuid.length() != 7){
//                System.out.println("condition 4 active");
                return false;
            }
        }
        return true;
    }
}
