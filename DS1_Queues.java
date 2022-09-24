import java.util.*;

public class DS1_Queues {
   
    //RecentCounter, has a ping function that takes a varaibe, t, and returns the number of requests made in the last 3000 milliseconds
    
    public static class RecentCounter {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] arr = new int[3000];
        ArrayList<Integer> requests = new ArrayList<Integer>();
        public RecentCounter() {
            
        }
        
        public int ping(int t) {
            q.add(t);
            while(q.peek() < t - 3000)
            {
                q.remove();
            }

            printRequests(t);
            printRange(t);
            return q.size();
        }

        public void printRequests (int r)
        {  
            requests.add(r);
            System.out.print("Requests: " + requests + "\t");
        }

        public void printRange(int t)
        {
            System.out.print("Range: [" + (t - 3000) + ", " + t + "]\t");
        }

    }

    public static void main(String args[])  //idk
    {
        //run test cases
        RecentCounter rc = new RecentCounter();
        System.out.println("returns: " + rc.ping(1)); //output return 1
        System.out.println("returns: " + rc.ping(100)); // output return 1
        System.out.println("returns: " + rc.ping(3001)); //output return 2
        System.out.println("returns: " + rc.ping(3002));  // output return 3
        //System.out.println(rc.ping(testCase4));
    

    }    
    

    


}

