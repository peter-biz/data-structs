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

   public static int maxMin(int[][] grid) {
      int length = grid.length; //length of the grid
      int width = grid[0].length; //width of the grid
      Deque<int[]> floods = new ArrayDeque<>(); //queue for running BFS
      int[][] minutes = new int [length][width]; //array to store the minutes it takes to reach each point
      int[] directions = new int[] {-1,0,1,0,-1}; //directions to move in
      int time = 1; //time it takes to move to a new point
      
      for(int[] row : minutes) {
         Arrays.fill(row, Integer.MAX_VALUE); //filling the array with the max value
      }

      for(int r = 0; r < length; r++) { //finding the starting point of the robot
         for(int c = 0; c < width; c++) { //finding the starting point of the robot
            if (grid[r][c] == 1) { //if the point is a flood
               minutes[r][c] = 0;
               floods.add(new int[]{r, c});
            }
         }
      }

      while(!floods.isEmpty()) { //while the queue is not empty
         int size = floods.size(); //size of the queue
         for(int i = 0; i < size; i++) { //for the size of the queue
            int[] pos = floods.poll(); //position of the robot
            for(int j = 0; j < 4; j++) { //for the 4 directions
               int x = pos[0] + directions[j]; //x coordinate
               int y = pos[1] + directions[j + 1]; //y coordinate
               if (x >= 0 && y >= 0 && x < length && y < width && grid[x][y] == 0 && minutes[x][y] == Integer.MAX_VALUE) { //if the point is not a wall, not a flood, and not visited
                  minutes[x][y] = time; //set the minutes to the time
                  floods.add(new int[]{x, y}); //add the point to the queue
               }
            }
         }
         time++; //increment the time
      }

      floods.clear(); //clear the queue

      int result = Integer.MAX_VALUE; //result of the time it takes for the robot to reach the human
      floods.add(new int[]{0, 0}); //add the starting point of the robot to the queue
      grid[0][0] = 2; //set the starting point of the robot to a wall

      time = 1;  
      while(!floods.isEmpty() && grid[length-1][width-1] == 0) {  //while the queue is not empty and the human is not reached
         int size = floods.size(); //size of the queue
         int t = Integer.MIN_VALUE; //time it takes to reach the human

         for(int i = 0; i < size && grid[length-1][width-1] == 0; i++) {  //for the size of the queue and the human is not reached
            int[] pos = floods.poll();  //position of the robot 
            for(int k = 0; k < 4 && grid[length-1][width-1] == 0; k++) {  //for the 4 directions and the human is not reached
               int x = pos[0] + directions[k];  
               int y = pos[1] + directions[k + 1]; 

               if(x >= 0 && y >= 0 && x < length  && y < width && grid[x][y] == 0 && minutes[x][y] >= time) {  //if the point is not a wall, not a flood, and not visited and the time it takes to reach the point is greater than the time it takes to reach the human
                  if(x == length - 1 && y == width - 1) {  //if the point is the human
                     t = minutes[x][y] - time;
                     grid[x][y] = 2;
                     break; 
                  }
                  grid[x][y] = 2; //set the point to a wall
                  floods.add(new int[]{x, y});  //add the point to the queue
               
                  t = Math.max(t, minutes[x][y] - time) - 1;  //set the time to the max time it takes to reach the human

               }
               
               
            }
         }

         result = Math.min(result, t); //set the result to the min time it takes to reach the human

         time++; //increment the time
      }

      if(grid[length-1][width-1] != 2) { //if the robot cannot reach the human
         return -1;
      }

      if(minutes[length-1][width-1] == Integer.MAX_VALUE) { //if the human is always reachable
         return 1000000000;
      }

      return result == Integer.MAX_VALUE || result == Integer.MIN_VALUE ? -1 : result; //return the result

      
   }      
}

      


