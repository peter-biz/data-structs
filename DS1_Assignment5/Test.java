import java.util.*;

public class Test {
    public static void main(String args[]) {
        /*
         * Test cases
         */   //solving for the amount of time the robot can stay at the intial point before having to move due to flooding/wall
        int[][] test1 = {{0,2,0,0,0,0,0}, {0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,2,2,2,0,2}, {0,0,0,0,0,0,0}}; //output = 3
        int[][] test2 = {{0,0,0,0},{0,1,2,0},{0,2,0,0}}; //output = -1
        int[][] test3 = {{0,0,0}, {2,2,0}, {1,2,0}}; //output = 1000000000
  
        System.out.println("Test 1: " + maximumMinutes(test1));
        System.out.println("Test 2: " + maximumMinutes(test2));
        System.out.println("Test 3: " + maximumMinutes(test3));
  
    } 

  
 
    public static int maximumMinutes(int[][] g) {
      int m = g.length;
      int n = g[0].length;
      
      int[][] times = new int[m][n];
      for(int[] row : times) {
          Arrays.fill(row, Integer.MAX_VALUE);
      }
      
      int[] dir = new int[]{-1, 0, 1, 0, -1};
      
    // Queue for running BFS
      Deque<int[]> floods = new ArrayDeque<>();
    
      for(int row = 0; row < m; row++) {
          for(int col = 0; col < n; col++) {
              if (g[row][col] == 1) {
                  times[row][col] = 0;
                  floods.offer(new int[]{row, col});
              }
          }
      }
      
      int time = 1;
      while(!floods.isEmpty()) {
          int size = floods.size();
          
          for(int i = 0; i < size; i++) {
              int[] pos = floods.poll();
              
              for(int j = 0; j < 4; j++) {
                  int x = pos[0] + dir[j];
                  int y = pos[1] + dir[j + 1];
                  
                  if (x >= 0 && y >= 0 && x < m && y < n && g[x][y] == 0 && times[x][y] == Integer.MAX_VALUE) {
                      times[x][y] = time;
                      floods.offer(new int[]{x, y});
                  }
              }
          }
          
          time++;
      }
      
      floods.clear();
      
      int ans = Integer.MAX_VALUE;
      floods.offer(new int[]{0, 0});
      g[0][0] = 2;

      time = 1;
      while(!floods.isEmpty() && g[m - 1][n - 1] == 0) {
          int size = floods.size();
          
          int t = Integer.MIN_VALUE;
          
          for(int i = 0; i < size && g[m - 1][n - 1] == 0; i++) {
              int[] pos = floods.poll();
          
              for(int j = 0; j < 4 && g[m - 1][n - 1] == 0; j++) {
                  
                  int x = pos[0] + dir[j];
                  int y = pos[1] + dir[j + 1];

                  if (x >= 0 && y >= 0 && x < m && y < n && g[x][y] == 0 && times[x][y] >= time) {
                      if (x == m - 1 && y == n - 1) {
                          t = times[x][y] - time;
                          g[x][y] = 2;
                          break;
                      }

                      g[x][y] = 2;
                      floods.offer(new int[]{x, y});
                      
                // if times[x][y] == Integer.MAX_VALUE, flood will never reach this cell and it will contribute maximum wait time
                      t = Math.max(t, times[x][y] == Integer.MAX_VALUE ? 1000000000 : times[x][y] - time - 1);
                  }
              }
          }
          
          ans = Math.min(ans, t);
          
          time++;
      }
      
    // You can never reach the safe house
      if (g[m - 1][n - 1] != 2) {
          return -1;
      }
      
    // you can reach the safe house but flood can not
      if (times[m - 1][n - 1] == Integer.MAX_VALUE) {
          return 1000000000;
      }
      
      return ans == Integer.MAX_VALUE || ans == Integer.MIN_VALUE ? -1 : ans;
  }


    }
