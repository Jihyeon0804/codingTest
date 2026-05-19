import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String str = "";
        for (char s : a.toCharArray()) {
            if (Character.isUpperCase(s)) {
                str += Character.toLowerCase(s);
            } else {
                str += Character.toUpperCase(s);
            }
        }
        System.out.print(str);
    }
}