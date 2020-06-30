package amazon.rottenoranges;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int solve(int[][] grid) {
      /*
        value 0 is empty cell
        value 1 is fresh orange
        value 2 is a rotten orange

         find total rotten oranges
             create a queue and add rotten oranges index
             find total healthy oranges

        minutes = 0
        while q is not empty :
         size = q.size

          for i in range size:
                infect possible neighbors
                add newly rotten to queue
                fresh orange--
        minutes++;


        if fresh oranges > 0
            return -1

        // if no rotten oranges then return 0 otherwise minutes - 1

        return minutes == 0 ? 0 : minutes - 1;

*/
        int freshOranges = 0;

        Queue<int[]> rottenOrangesQueue = new LinkedList<>();

//        find total fresh oranges
//        create a queue of rotten oranges

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    freshOranges++;
                if(grid[i][j] == 2) {
                    rottenOrangesQueue.add(new int[]{i, j});
                }
            }
        }

//        initialize minutes
        int minutes = 0;

//        while queue is empty keep on infecting oranges

        while (!rottenOrangesQueue.isEmpty()) {
            int size = rottenOrangesQueue.size();

            for (int i = size; i > 0 ; i--) {
                int[] poll = rottenOrangesQueue.poll();

                int x = poll[0];
                int y = poll[1];
                if( isPossible(grid, x - 1 , y) ) {
                    rottenOrangesQueue.add(new int[]{x - 1, y});
                    grid[x-1][ y] = 2;
                    freshOranges--;
                }

                if( isPossible(grid, x + 1, y)) {
                    rottenOrangesQueue.add(new int[]{x + 1, y});
                    grid[x + 1][ y] = 2;
                    freshOranges--;
                }

                if( isPossible(grid, x , y - 1)) {
                    rottenOrangesQueue.add(new int[]{x, y - 1});
                    grid[x][ y - 1] = 2;
                    freshOranges--;
                }

                if( isPossible(grid, x, y + 1)) {
                    rottenOrangesQueue.add(new int[]{x, y + 1});
                    grid[x][y + 1] = 2;
                    freshOranges--;
                }

            }
            minutes++;
        }

//         if still fresh oranges exist return -1
        if (freshOranges > 0)
            return -1;
//         if no rotten oranges return 0 otherwise minutes - 1
        return minutes == 0 ? 0 : minutes - 1;
    }

    private static boolean isPossible(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1;
    }
}
