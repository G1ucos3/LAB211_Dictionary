package common;

import java.util.HashMap;
import java.util.Scanner;
import model.Translate_Words;

/**
 *
 * @author ASUS
 */
public class Validate {

    public String checkString(String s) {
        String str = "";
        while (str.isBlank() || str.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print(s + ": ");
            str = sc.nextLine();
            return str;
        }
        System.err.println("Please enter something.");
        return "";
    }

    public boolean inputYN(String s) {
        while (true) {
            String str = checkString(s);
            if (str.equalsIgnoreCase("Y")) {
                return true;
            } else if (str.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please enter Y or N");
        }
    }

    public boolean checkExist(HashMap<String, Translate_Words> tMap, String engWord) {
        if (tMap.containsKey(engWord)) {
            return true;
        }
        return false;
    }
}
