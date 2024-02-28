//Walls and Gates -- Matrix Islands

import java.util.* ;
import java.io.*;
public class Solution {
    public static int[][] wallsAndGates(int[][] a, int n, int m) {
        // Write you code here
        int INF = 2147483647;
        int r = a.length;
        int c= a[0].length;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(a[i][j]==0)
                {
                    dfs(a,i,j,0);
                }
            }
        }
        return a;
    }


    public static void dfs(int[][]a,int row,int col,int count)
    {
        int n=a.length;
        int m=a[0].length;

        if(row<0||col<0||row>=n||col>=m||a[row][col]<count)
        {
            return;
        }

        a[row][col]=count;

        dfs(a,row,col-1,count+1);
        dfs(a,row,col+1,count+1);
        dfs(a,row-1,col,count+1);
        dfs(a,row+1,col,count+1);
        return;
    }
}
