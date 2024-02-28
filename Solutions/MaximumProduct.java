import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static int maximumProduct(ArrayList<Integer> arr, int n) {
        int prod=1;
        for(int i=0;i<n;i++)
        {
            int num = arr.get(i);
            prod = prod*num;
        }
        if(prod>0)
            return prod;

        int start =0;
        int end = n-1;
        while(start<end)
        {
            if(arr.get(start)<0)
                neg1 = start;
            else
                start++;

            if(arr.get(end)<0)
                neg2 = end;
            else
                end--;
        }
        if(arr.get(neg1)>arr.get(neg2))
        {
            start++;
        }
        else{
            end--;
        }
        prod = 1;
        for(int i=start;i<=end;i++)
        {
            prod = prod*arr.get(i);
        }
        return prod;
        // Write your code here.
    }
}