import java.util.*;

public class DS1_Palindromes {
    public static void main(String[] args) {
        //test cases
        String test1 = "aabbaa"; //output true
        String test2 = "aba";   //output: true
        String test3 = "aabb";  //output: false


        //run and output test cases
        System.out.println("Input: " + test1 + "\t Output: " + isPalindrome(test1));
        System.out.println("Input: " + test2 + "\t Output: " + isPalindrome(test2));
        System.out.println("Input: " + test3 + "\t Output: " + isPalindrome(test3));
    }

    public static boolean isPalindrome(String s) {
        boolean b;
        String copy = s;
        if(s.length() == 0 || s.length() == 1) {
            b = true;
        }
        else {
            for(int i = 0; i < s.length(); i++) {
                
            }
        }

        return b;
    }

}