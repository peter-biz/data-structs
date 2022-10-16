public class DS1_TagRemover {
    public static void main(String[] args) {

        //sample input
        String test1 = "4\n<h1>John loves counseling</h1>\n<h1><h1>John has no watch" + 
        "</h1></h1>\n<par>So wait for a while</par>\n<Amee>Tom codes like a ninja</amee>" + 
        "\n<SA premium>Tom likes to read books</SA premium>"; 
        /*OUTPUT
         * John loves counseling
         * John has no watch
         * So wait for a while
         * None
         * Tom likes to read books
         */

         System.out.println("Given text: " + test1 + "\nString with tags removed: " + removeTags(test1));
    }


    //function that takes the given string, removes the HTML tags, both opening and closing, and numbers at the beggining of a line, and then returns the String without tags
    //if the string is empty or does not match any of the conditions, it returns "None"
    public static String removeTags(String s) {
       

        //if the string is empty, return "None"
        if(s.isEmpty()) {
            return "None";
        }
        //if the string does not contain any tags, return "None"
        if(!s.contains("<") && !s.contains(">")) {
            return "None";
        }

        
        
        
    

      


    }
}