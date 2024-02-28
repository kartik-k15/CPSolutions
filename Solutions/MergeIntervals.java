import java.util.*;


public class Solution {

    public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        List<Integer> curlist = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            if(curlist.size()==0)
            {
                curlist.add(arr[i][0]);
                curlist.add(arr[i][1]);
            }
            else
            {
                if(curlist.get(1)>=arr[i][0])
                {
                    curlist.set(1, Math.max(arr[i][1], curlist.get(1)));
                }
                else
                {
                    ans.add(curlist);
                    curlist = new ArrayList<>();
                    curlist.add(arr[i][0]);
                    curlist.add(arr[i][1]);
                }
            }
        }
        ans.add(curlist);
        return ans;

        // Write your code here.
    }
}