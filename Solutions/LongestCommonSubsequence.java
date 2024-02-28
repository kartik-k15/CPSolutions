
public class Solution {

    public static int lcs(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<t.length();j++)
            {
                dp[i][j] = -1;
            }
        }
        return findlcs(s.length()-1,t.length()-1,s,t,dp);
        //Your code goes here
    }
    public static int findlcs(int index1, int index2, String text1, String text2, int[][]dp)
    {
        if(index1<0 || index2<0)
            return 0;

        if(dp[index1][index2]!=-1)
            return dp[index1][index2];

        if(text1.charAt(index1)==text2.charAt(index2))
        {
            dp[index1][index2] = 1 + findlcs(index1-1, index2-1, text1, text2,dp);
        }
        else
        {
            dp[index1][index2] = 0 + Math.max(findlcs(index1-1, index2, text1, text2,dp), findlcs(index1, index2-1, text1, text2,dp));
        }
        return dp[index1][index2];
    }
}