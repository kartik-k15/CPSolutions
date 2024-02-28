import java.util.* ;
import java.io.*;
public class Solution {
    public static int minSumPath(int[][] grid) {
        // Write your code here.
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row+1][col+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);

        for(int i=0;i<=row;i++)
        {
            dp[i][0] = Integer.MAX_VALUE;
        }

        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=col;j++)
            {
                if(i==1 && j==1)
                {
                    dp[i][j] = grid[i-1][j-1];
                }
                else
                {
                    dp[i][j] = grid[i-1][j-1] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[row][col];
    }
}