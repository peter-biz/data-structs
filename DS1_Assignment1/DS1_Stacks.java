import java.util.*;

public class DS1_Stacks {
    public static void main(String args[]) {

        //test cases
        String testCase1 = "[()]"; // output should be: [()] is balanced
        String testCase2 = "()[]"; // output should be: ()[] is balanced
        String testCase3 = "[(]["; // output should be: [)][ is not balanced
        String testCase4 = "()"; //personal test case just to make sure unexpected inputs work
        String testCase5 = ""; 
        String testCase6 = "[(])";

       //run test cases
       isBalanced(testCase1);
       isBalanced(testCase2);
       isBalanced(testCase3);
       isBalanced(testCase4);
       isBalanced(testCase5);
       isBalanced(testCase6);
    }


    // is balanced function that takes a string, makes it into a stack and then finds mathcing pairs of [], and (), to determine if the given string is balanced
    public static void isBalanced(String s)
    {

        Stack<Character> stack = new Stack<Character>(); //create a stack of characters

        for(int i = 0; i < s.length(); i++) //iterate through the string
        {
            char c = s.charAt(i); //get the character at the current index

            if(c == '(' || c == '[') //if the character is a ( or [, push it to the stack
            {
                stack.push(c);
            }
            else if(c == ')') //if the character is a ), check if the top of the stack is a (, if it is, pop it, if not, the string is not balanced
            {
                if(stack.isEmpty() || stack.peek() != '(')
                {
                    System.out.println("\n" + s + " is not balanced");
                    return;
                }
                else  //if the top of the stack is a (, pop it
                {
                    stack.pop();
                }
            }
            else if(c == ']') //if the character is a ], check if the top of the stack is a [, if it is, pop it, if not, the string is not balanced
            {
                if(stack.isEmpty() || stack.peek() != '[')
                {
                    System.out.println("\n" + s + " is not balanced");
                    return;
                }
                else  //if the top of the stack is a [, pop it
                {
                    stack.pop();  
                }
            }
        }

        if(stack.isEmpty()) //if the stack is empty, the string is balanced
        {
            System.out.println("\n" + s + " is balanced");
        }
        else //if the stack is not empty, the string is not balanced
        {
            System.out.println("\n" + s + " is not balanced");
        }
    }
}

/*
 * TIME COMPLEXITY is O(n)
 */
