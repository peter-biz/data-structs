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
      int[][] test1 = {{0,2,0,0,0,0,0}, {0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,2,2,2,0,2}, {0,0,0,0,0,0,0}}; //output = 3
      int[][] test2 = {{0,0,0,0},{0,1,2,0},{0,2,0,0}}; //output = -1
      int[][] test3 = {{0,0,0}, {2,2,0}, {1,2,0}}; //output = 1000000000

      System.out.println("Test 1: " + maxMin(test1));
      System.out.println("Test 2: " + maxMin(test2));
      System.out.println("Test 3: " + maxMin(test3));
   } 

   public static class Graph {
      private int numVertices;
      private LinkedList<Integer> adjLists[];

      //Constuctor
      Graph(int v) {
         numVertices = v;
         adjLists = new LinkedList[v];
         for (int i = 0; i < v; i++) {
            adjLists[i] = new LinkedList<Integer>();
         }
      }

      void addEdge(int src, int dest) {
         adjLists[src].add(dest);
      }

      void BFS(int s) {  
         boolean visited[] = new boolean[numVertices]; //boolean array to keep track of visited vertices
         LinkedList<Integer> queue = new LinkedList<Integer>(); //queue to keep track of vertices to be visited
         visited[s] = true;  //mark the current node as visited and enqueue it
         queue.add(s);  //add the current node to the queue

         while(queue.size() != 0) {
            s = queue.poll();  //dequeue a vertex from queue and print it
            System.out.print(s + " ");  

            Iterator<Integer> i = adjLists[s].listIterator();  //get all adjacent vertices of the dequeued vertex s
            int next = i.next();  //if a adjacent has not been visited, then mark it visited and enqueue it
            if(!visited[next]) {  //if the adjacent has not been visited, then mark it visited and enqueue it
               visited[next] = true;  //mark the adjacent as visited
               queue.add(next); //add the adjacent to the queue
            }
         }
      }
      
   }


   //converts the given 2d array into a graph
   public static Graph arrayToGraph(int[][] a) {
      int rows = a.length;
      int cols = a[0].length;
      int numVertices = rows * cols;
      Graph g = new Graph(numVertices);
      for(int i = 0; i < rows; i++) {
         for(int j = 0; j < cols; j++) {
            if(a[i][j] == 0) {
               if(i > 0 && a[i-1][j] == 0) {
                  g.addEdge(i*cols + j, (i-1)*cols + j);
               }
               if(i < rows - 1 && a[i+1][j] == 0) {
                  g.addEdge(i*cols + j, (i+1)*cols + j);
               }
               if(j > 0 && a[i][j-1] == 0) {
                  g.addEdge(i*cols + j, i*cols + j-1);
               }
               if(j < cols - 1 && a[i][j+1] == 0) {
                  g.addEdge(i*cols + j, i*cols + j+1);
               }
            }
         }
      }
      return g;
   }

   public static int maxMin(int[][] a) {
      Graph g = arrayToGraph(a);
      g.BFS(0);
      return 0;


      
      
      
   }
      

}

