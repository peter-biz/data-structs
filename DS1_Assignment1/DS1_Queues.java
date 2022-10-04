import java.util.*;

public class DS1_Queues {
   
    //RecentCounter, has a ping function that takes a varaibe, t, and returns the number of requests made in the last 3000 milliseconds
    
    public static class RecentCounter {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] arr = new int[3000];
        ArrayList<Integer> requests = new ArrayList<Integer>();
        
        public int ping(int t) {
            q.add(t);  
            while(q.peek() < t - 3000)  //while the first element in the queue is less than t - 3000, remove the first element
            {
                q.remove();
            }

            //sends t to printRequests and printRange to store the t value inside the requests arraylist and print the range
            printRequests(t);
            printRange(t);
            return q.size();  //return the size of the queue
        }

        public void printRequests (int r) //adds the t value to the requests arraylist and prints
        {  
            requests.add(r);
            System.out.print("Requests: " + requests + "\t");
        }

        public void printRange(int t) //prints the range of the t value
        {
            System.out.print("Range: [" + (t - 3000) + ", " + t + "]\t");
        }
    }

    public static void main(String args[])  
    {
        //run and print test cases
        RecentCounter rc = new RecentCounter();
        System.out.println("returns: " + rc.ping(0)); //output return 1
        System.out.println("returns: " + rc.ping(1)); //output return 1
        System.out.println("returns: " + rc.ping(100)); // output return 1
        System.out.println("returns: " + rc.ping(3001)); //output return 2
        System.out.println("returns: " + rc.ping(3002));  // output return 3  
       
    }    
}


/*
 * TIME COMPLEXITY is O(n)
 */
