//https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471
import java.util.Arrays;
public class Solution {

    public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here
        long[][] dp = new long[denominations.length][value+1];
        for(long[]d:dp)
            Arrays.fill(d,-1);
        return coinchange(denominations, denominations.length-1, value,dp);
    }


    public static long coinchange(int[] denominations, int index ,int value,long[][]dp)
    {
        if(value<0 || index<0)
        {
            return 0;
        }
        if(value==0)
        {
            return 1;
        }
        if(dp[index][value]!=-1)
            return dp[index][value];
        long take =0;
        if(value>=denominations[index])
            take = coinchange(denominations, index ,value-denominations[index],dp);
        long nottake = coinchange(denominations, index-1, value,dp);

        dp[index][value] = take+nottake;
        return dp[index][value];
    }

}