import java.util.Stack;
import java.lang.StringBuilder;

public class DS1_TagRemover {
    public static void main(String[] args) {
        //test cases
        String test1 = "<h1>Nayeem loves counseling</h1>"; 
        String test2 = "<h1><h2>Sanjay has no watch</h2></h1><par>So wait for a while</par>"; 
        String test3 = "<Amee>safat codes like a ninja</amee>"; 
        String test4 = "<h1><h2>valid</h2><h3>valid</h3></h1>";
        String test5 = "<SA premium>Imtiaz has a secret crush</SA premium>"; 

        //run test cases
        System.out.println("\nGiven text(1): " + test1 + "\nString with tags removed: " + removeTags(test1)); // output: Nayeem loves counseling
        System.out.println("\nGiven text(2): " + test2 + "\nString with tags removed: " + removeTags(test2)); // output: Sanjay has nowatch So wait for a while
        System.out.println("\nGiven text(3): " + test3 + "\nString with tags removed: " + removeTags(test3)); // output: None
        System.out.println("\nGiven text(4): " + test4 + "\nString with tags removed: " + removeTags(test4));  // output: valid valid
        System.out.println("\nGiven text(5): " + test5 + "\nString with tags removed: " + removeTags(test5) + "\n"); // output: Imtiaz has a secret crush
        
    }

    public static String removeTags(String str) { 
        Stack<String> stack = new Stack<String>(); // stack to store tags
        StringBuilder sb = new StringBuilder(); // string builder to store string without tags
        String[] strArr = str.split(">"); // split string by > to get tags and text
        
        for (int i = 0; i < strArr.length; i++) { // loop through array
            if (strArr[i].contains("<")) { // if tag is found
                String[] temp = strArr[i].split("<");
                if (temp[0].length() > 0) { // if text is found
                    sb.append(temp[0]); // append text to string builder
                }
                if (temp[1].contains("/")) { // if closing tag is found
                    if (stack.size() > 0) { 
                        if (stack.peek().equals(temp[1].substring(1))) { // if closing tag matches top of stack
                            stack.pop();
                        } else {
                            stack.push(temp[1].substring(1)); // push tag to stack
                        }
                    } else {
                        stack.push(temp[1].substring(1)); // push tag to stack
                    }
                } else {
                    stack.push(temp[1]); // push tag to stack
                }
            } else {
                sb.append(strArr[i]);   // append text to string builder
            }
        }
        if (stack.size() > 0) { // if stack is not empty
            return "None";
        } else { // if stack is empty
            return sb.toString();
        }
    }
}