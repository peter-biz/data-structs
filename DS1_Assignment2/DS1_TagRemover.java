import java.util.Stack;
import java.lang.StringBuilder;

public class DS1_TagRemover {
    public static void main(String[] args) {

        // sample input
        // String test1 = "4\n<h1>John loves counseling</h1>\n<h1><h1>John has no watch"
        // +
        // "</h1></h1>\n<par>So wait for a while</par>\n<Amee>Tom codes like a
        // ninja</amee>" +
        // "\n<SA premium>Tom likes to read books</SA premium>";
        /*
         * OUTPUT
         * John loves counseling
         * John has no watch
         * So wait for a while
         * None
         * Tom likes to read books
         */


        String test2 = "<h1>Nayeem loves counseling</h1>"; 
        String test3 = "<h1><h2>Sanjay has no watch</h2></h1><par>So wait for a while</par>"; 
        String test4 = "<Amee>safat codes like a ninja</amee>"; 
        String test5 = "<h1><par>So wait for a while</par> <Amee>safat codes like a ninja</amee></h1>"; 
        String test6 = "<h1><h2>valid</h2><h3>valid</h3></h1>";
        String test7 = "<SA premium>Imtiaz has a secret crush</SA premium>"; 

        // System.out.println("Given text(1): " + test1 + "\nString with tags removed: " + removeTags(test1));
        System.out.println("\nGiven text(2): " + test2 + "\nString with tags removed: " + removeTags(test2)); // output: Nayeem loves counseling
        System.out.println("\nGiven text(3): " + test3 + "\nString with tags removed: " + removeTags(test3)); // output: Sanjay has nowatch So wait for a while
        System.out.println("\nGiven text(4): " + test4 + "\nString with tags removed: " + removeTags(test4)); // output: None
        System.out.println("\nGiven text(5): " + test5 + "\nString with tags removed: " + removeTags(test5)); // output: So wait for a while None
        System.out.println("\nGiven text(6): " + test6 + "\nString with tags removed: " + removeTags(test6));  // output: valid valid
        System.out.println("\nGiven text(7): " + test7 + "\nString with tags removed: " + removeTags(test7) + "\n"); // output: Imtiaz has a secret crush
        
    }


    /*<h1><h2> hello world </h2></h1> 
In terms of the Stack problem from Assignment 1, <h1> and <h2> would both be considered as  open “brackets”. And your program will need to keep reading through the input and find it’s  corresponding closing " brackets”. And if it’s found, your program will need to print the String in  between the open and closing tags. After that, that entire substring is out of the equation. 
 */
    public static String removeTags(String s) {
        Stack<String> stack = new Stack<String>();

        StringBuilder output = new StringBuilder();
        output.append(" ");
        Boolean match = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                stack.push("<");
            } else if (s.charAt(i) == '>') {
                stack.pop();
                match = true;
            } else if (stack.isEmpty()) {
                output.append(s.charAt(i));
            }
        }

        if (match == false) {
            output.setLength(0);
            output.append("None");
        }

        return output.toString();

        /*
         * (2): Excpected output: Nayeem loves counseling, current output: Nayeem loves counseling   (good)
         * (3): Excpected output: Sanjay has nowatch So wait for a while, current output: Sanjay has nowatchSo wait for a while   (needs a space in between, ok)
         * (4): Excpected output: None, current output: safat codes like a ninja   (bad)
         * (5): Excpected output: So wait for a while None, current output: So wait for a while safat codes like a ninja   (bad)
         * (6): Excpected output: valid valid, current output: validvalid   (needs a space in between, ok)
         * (7): Excpected output: Imtiaz has a secret crush, current output: Imtiaz has a secret crush   (good)
         */

        
    }

}
