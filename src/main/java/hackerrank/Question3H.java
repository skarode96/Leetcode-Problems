package hackerrank;

import java.util.List;
import java.util.Stack;

public class Question3H {
    public static int transmissionLength(List<List<Character>> planetsMap) {

        char[][] matrix = new char[planetsMap.size()][planetsMap.get(0).size()];
        for (int i = 0; i < planetsMap.size(); i++) {
            for (int j = 0; j < planetsMap.get(0).size(); j++) {
                matrix[i][j] = planetsMap.get(i).get(j);
            }
        }
        int dX = 0;
        int dY = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 'D') {
                    dX = i;
                    dY = j;
                }
            }
        }

        int h = matrix.length;
        if (h == 0)
            return -1;
        int l = matrix[0].length;

        boolean[][] visited = new boolean[h][l];

        Stack<String> stack = new Stack<>();


        dfs(matrix, stack, visited,  dX,  dY);

        System.out.println("Size =>"  + stack.size());
        System.out.println(dX + " " + dY);

        return stack.size() == 1 ? -1 : stack.size();
    }

    private static void dfs(char[][] matrix, Stack<String> stack, boolean[][] visited, int x, int y) {
        int h = matrix.length;
        int l = matrix[0].length;
        visited[x][y] = true;
        stack.push(x + "," + y);
        if( (x<0 || y<0 || x>=h || y>=l) && 'A' != matrix[x][y]) {
            return;
        }

        if(x-1 >= 0 && visited[x-1][y] == false && matrix[x-1][y] == 'A')
        {
            dfs(matrix, stack, visited, x-1, y);
        }

        if(x+1 < h  && visited[x+1][y] == false && matrix[x+1][y] == 'A')
        {
            dfs(matrix, stack, visited, x+1, y);
        }

        if(y-1 >= 0  && visited[x][y-1] == false && matrix[x][y-1] == 'A')
        {

            dfs(matrix, stack, visited, x, y-1);
        }

        if(y+1 < l && visited[x][y+1] == false && matrix[x][y+1] == 'A')
        {
            dfs(matrix, stack, visited, x, y+1);
        }

    }
}
