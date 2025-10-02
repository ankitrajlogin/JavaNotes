



import java.util.*;

class Solution{
     int m, n, totalEmpty;
    int startX, startY, endX, endY;
    List<List<int[]>> allPaths = new ArrayList<>();
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        totalEmpty = 1; // include starting square
        startX = startY = endX = endY = -1;

        // find start, end, and total empty cells
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) totalEmpty++;
                else if(grid[i][j] == 1){
                    startX = i; startY = j;
                } else if(grid[i][j] == 2){
                    endX = i; endY = j;
                }
            }
        }

        boolean[][] visited = new boolean[m][n];
        List<int[]> currentPath = new ArrayList<>();
        dfs(grid, startX, startY, visited, currentPath, 0);

        // print all paths
        System.out.println("Total paths found: " + allPaths.size());
        int count = 1;
        for(List<int[]> path : allPaths){
            System.out.print("Path " + count++ + ": ");
            for(int[] cell : path){
                System.out.print("(" + cell[0] + "," + cell[1] + ") ");
            }
            System.out.println();
        }

        return allPaths.size();
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> path, int count){
        // if invalid or visited or obstacle
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == -1 || visited[x][y]) return;

        // mark visited
        visited[x][y] = true;
        path.add(new int[]{x, y});

        if(x == endX && y == endY){
            if(count == totalEmpty){ // covered all empty + start
                allPaths.add(new ArrayList<>(path));
            }
        } else {
            dfs(grid, x+1, y, visited, path, count+1);
            dfs(grid, x-1, y, visited, path, count+1);
            dfs(grid, x, y+1, visited, path, count+1);
            dfs(grid, x, y-1, visited, path, count+1);
        }

        // backtrack
        path.remove(path.size()-1);
        visited[x][y] = false;
    }
}




public class L02_Unique_Path_Print {
   
    // MAIN for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
            {1,0,0,0},
            {0,0,0,0},
            {0,0,2,-1}
        };

        int[][] grid2 = {
            {1,0,0,0},
            {0,0,0,0},
            {0,0,0,2}
        };

        System.out.println("Grid 1:");
        int result1 = sol.uniquePathsIII(grid1);
        System.out.println("Unique paths count = " + result1);
        System.out.println();

        System.out.println("Grid 2:");
        int result2 = sol.uniquePathsIII(grid2);
        System.out.println("Unique paths count = " + result2);
    }
}

