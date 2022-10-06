public class DS1_Palindromes {
    public static void main(String[] args) {

        //given test cases
        String test1 = "aabbaa"; //output: true
        String test2 = "aba";   //output: true
        String test3 = "aabb";  //output: false

	    //my test cases
	    String myTest1 = ""; //output: true

        //run and output test cases
        System.out.println("Input: " + test1 + "\t Output: " + isPalindrome(test1));
        System.out.println("Input: " + test2 + "\t Output: " + isPalindrome(test2));
        System.out.println("Input: " + test3 + "\t Output: " + isPalindrome(test3));
    }

    public static boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) {   //logic for this is that if a string is read the same backwards
            return true;			   //it's a palindrome, therefore a length of 1 and or 0 is a palindrome
        }
        else {
            for(int i = 0; i < s.length(); i++) {
                for(int k = s.length() - 1; k > 0; k--) {
                    if((s.charAt(i) == (s.charAt(k)))) {   //checks if the value at i is equal to value at k within the string
                        return true;   //if the value is equal, returns true
                    }
                    else if(!(s.charAt(i) == s.charAt(k))) {   //checks if the value at i is not equal to value at k within the string
                        return false;   //if the value is not equal, returns false
                    }
                }
            }
        }
        return false;  //TODO: probably have to change this, kind of a "default" value if the other statments dont get anywhere...

        
    }

}