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
        String test2 = "<h1>Hello World</h1>"; //output: Hello World
        String test3 = "<h1>Hello World</h1><h2>Good bye</h2>"; //output: Hello World Good bye
        String test4 = "<h1><h2>cruel world</h2></h1>"; //output: cruel world


         System.out.println("String with tags removed: " + removeTags(test1));
         System.out.println("String with tags removed: " + removeTags(test2));
         System.out.println("String with tags removed: " + removeTags(test3));
         System.out.println("String with tags removed: " + removeTags(test4));

    }

    public static String removeTags(String s) {
        String startTag;
        String endTag;
        for(int x = 0; x < s.length(); x++) {
            if(s.charAt(x) == '<') {
                for(int y = x; y < x + 10; y++) {
                    if(s.charAt(y) == '>') {
                        startTag = s.substring(x, y);
                        break;
                    }
                }
            }
        }
        return s;
    }
}