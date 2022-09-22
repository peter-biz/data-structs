import java.util.*;

public class DS1_LinkedList {
    public static void main(String arg[])
    {
        //test cases
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int x = 0; x < 5; x++)
        {
            list.add(x); //0, 1, 2, 3, 4
        } // output should be: 0,1,3,4

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        for(int x = 0; x < 4; x++)  //unironically not sure what the output should be for this, cause it technically doesnt have a mid point, maybe throw an error? or 2 mid?
        {
            list2.add(x);  //0, 1, 2, 3
        } //TODO idk ask bluwho
        
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        for(int x = 0; x < 3; x++)
        {
            list3.add(x); //0, 1, 2
        } // output should be: 0, 2



        //run test cases
        removeMid(list);
        removeMid(list2);
        removeMid(list3);
    }

    public static void removeMid(LinkedList<Integer> l)
    {
        //removes the middle element of the list
        System.out.println("init list: " + l);
        int size = l.size();
        int mid = size/2;
        l.remove(mid);
        System.out.println("List with mid removed: " + l);
    }
}
