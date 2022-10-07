public class DS1_Palindromes {
    public static void main(String[] args) {

        //given test cases
        String test1 = "aabbaa"; //output: true
        String test2 = "aba";   //output: true
        String test3 = "aabb";  //output: false

	    //my test cases
	    String myTest1 = ""; //output: true
        String myTest2 = "a"; //output: true
        String myTest3 = "ab"; //output: false
        String myTest4 = "abacaca"; //output: 

        //run and output test cases
        System.out.println("Given Test Cases: \n");
        System.out.println("Input: " + test1 + "\t (true)Output: " + isPalindrome(test1));
        System.out.println("Input: " + test2 + "\t (true)Output: " + isPalindrome(test2));
        System.out.println("Input: " + test3 + "\t (false)Output: " + isPalindrome(test3));
        System.out.println("\nMy Test Cases: \n");
        System.out.println("Input: " + myTest1 + "\t\t (true)Output: " + isPalindrome(myTest1));
        System.out.println("Input: " + myTest2 + "\t (true)Output: " + isPalindrome(myTest2));
        System.out.println("Input: " + myTest3 + "\t (false)Output: " + isPalindrome(myTest3));
        System.out.println("Input: " + myTest4 + "\t (false)Output: " + isPalindrome(myTest4));
    }

    public static boolean isPalindrome(String s) {
        Boolean b = true;
        if(s.length() == 0 || s.length() == 1) {   //logic for this is that if a string is read the same backwards
           b = true;			   //it's a palindrome, therefore a length of 1 and or 0 is a palindrome
        }
        else {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    b = false;
                }
           }
        }
        return b;  
    }
}