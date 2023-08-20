import java.lang.*;
import java.util.Scanner;

public class Main {
    public static int love(String str3,int index,int res) {
        if (str3.length() == 1) {
            return str3.charAt(0);
        }
        else {
            int adjustedRes = (res + index - 1) % str3.length();
            str3 = str3.substring(0, adjustedRes) + str3.substring(adjustedRes + 1);
            return love(str3, adjustedRes, res);
        }
    }
    public static void main(String[] args) {
        // Inputting the strings
        int count = 0;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String str11 = sc.next();
        str1.append(str11);

        System.out.println("Enter your love name: ");
        String str22 = sc.next();
        str2.append(str22);

        // Calculating the length of the strings
        int len1 = str1.length();
        int len2 = str2.length();

        // Comparing and deleting common characters
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    count++;
                    str1.deleteCharAt(i);
                    str2.deleteCharAt(j);
                    i--; // Adjust the index after deletion
                    break;
                }
            }
        }

        int res = len1 + len2 - 2* count; // Count is doubled as we remove from both strings
        String str3 ="flames";

       int finalAnswer = love(str3,0,res);
        switch (finalAnswer) {
            case 'f' -> System.out.println("you are FRIENDS");
            case 'l' -> System.out.println("you are LOVERS");
            case 'a' -> System.out.println("you are ANCESTORS");
            case 'm' -> System.out.println("you are going to be MARRIED");
            case 'e' -> System.out.println("you are ENEMIES");
            case 's' -> System.out.println("you are SIBLINGS");
        }
    }
}
