import java.util.*;

public class DS1_Stacks {
    public static void main(String args[]) {
        //given 

        //test cases
        String testCase1 = "[()]"; // output should be: [()] is balanced
       // String testCase2 = "()[]"; // output should be: ()[] is balanced
       // String testCase3 = "[(]["; // output should be: [)][ is not balanced

       isBalanced(testCase1);
    }

    public static void isBalanced(String s) {
        Stack<String> stack = new Stack<String>();
        int pCount = 0;
        int bCount = 0;


        for(int x = 0; x < s.length(); x++)
        {
            String c = s.charAt(x) +"";
            stack.push(c);
           
        }
        System.out.println(stack);

        // if(stack.pop() == "]")
        // {
        //     bCount++;
        // }
    }
}