import java.util.*;
   //each movement is a minute, trying to find the smallest amount of time for robot to reach the human
   //robot always starts top left, human always starts bottom right
   /*
      0 represents plain land
      1 represents flood
      2 represents wall that the robots cannot go through and a flood 
   */ 


public class BFS {
   public static void main(String args[]) {
      /*
       * Test cases
       */   //solving for the amount of time the robot can stay at the intial point before having to move due to flooding/wall
      
   } 

   public class Graph {
      private int numVertices;
      private LinkedList<Integer> adjLists[];

      //Constuctor
      Graph(int v) {
         numVertices = v;
         adjLists = new LinkedList[v];
         for (int i = 0; i < v; i++) {
            adjLists[i] = new LinkedList<Integer>();
         }
         //https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/


      }
   }
}

