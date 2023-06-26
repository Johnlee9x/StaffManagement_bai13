package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class MyUtil {
    static Scanner sc = new Scanner(System.in);
    public static String getAString(String msg, String error, String regex){
        String str;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        while (true){
            System.out.println(msg);
            str = sc.nextLine();
            matcher = pattern.matcher(str);
            if( matcher.matches()){
                return str;
            }
            else{
                System.out.println(error);
            }
        }
    }
    public static int getAnInteger(String inputMsg, String errorMsg, int minNum, int maxNum) {
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < minNum || n > maxNum)
                    throw new Exception();
                return n;
            }
            catch (NumberFormatException e){
                System.out.println("NumberFormatException and Try again");
            }
            catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    public static String getString(String inputMsg, String errMsg){
        String str;
        System.out.println(inputMsg);
        while (true){
            str = sc.nextLine();
            if(str.isEmpty()){
                System.out.println(errMsg);
            }
            else {
                return str;
            }
        }
    }
    public static int getAnInteger(String inputMsg, String errMsg){
        int num;
        System.out.println(inputMsg);
        while (true){
            try{
                num = Integer.parseInt(sc.nextLine());
                return num;
            }
            catch (NumberFormatException e){
                System.out.println("NumberFormatException and Try again");
            }
            catch (Exception e){
                System.out.println(errMsg);
            }

        }
    }
}
