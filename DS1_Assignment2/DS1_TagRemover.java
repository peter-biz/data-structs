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

         System.out.println("String with tags removed: " + removeTags(test1));
    }

    public static String removeTags(String s) {
        
        return s;
    }
}