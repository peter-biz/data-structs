import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class DS1_Stacks {
    public static void main(String args[]) {

        //test cases
        String testCase1 = "[()]"; // output should be: [()] is balanced
        String testCase2 = "()[]"; // output should be: ()[] is balanced
        String testCase3 = "[(]["; // output should be: [)][ is not balanced
        
        
        //run test cases
       isBalanced(testCase1);
       isBalanced(testCase2);
       isBalanced(testCase3);
    }

    public static void isBalanced(String s) {
        Stack<String> stack = new Stack<String>();  //new stack
        int pCount = 0; //parentheses count
        int bCount = 0; //squre bracket count


        for(int x = 0; x < s.length(); x++)  //inserts the chars in the string into the stack
        {
            String c = s.charAt(x) +"";
            stack.push(c);
           
        }

        if(!stack.isEmpty())  //double checks that stack has elements before running
        {
            int size = stack.size(); //initial stack size so that for loop has a constant size
            for(int x = 0; x < size; x++)
            {
                String element = stack.pop();  //pops out the top element from the stack and sets it to element 
                //if statments that check the value of element and change the bCount and pCount values accordingly
                if(element.equals("["))
                {
                    bCount++;
                }
                else if(element.equals("]"))
                {
                    bCount--;
                }
                else if(element.equals("("))
                {
                    pCount++;
                }
                else if(element.equals(")"))
                {
                    pCount--;
                }
            }

            if(bCount == 0 && pCount == 0)  //checks if the amount of brackets/parentheses are balanced
            {
                System.out.println("\n" + s + " is balanced."); 
            }
            else
            {
                System.out.println("\n" + s + " is not balanced.");
            }

           //TODO find time complexity
        }
    }
}
