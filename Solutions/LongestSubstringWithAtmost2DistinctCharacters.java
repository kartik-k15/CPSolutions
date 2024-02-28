import java.util.*;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // Write your code here.
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        int charCount =0;
        int st=0,e=0;
        int length=0;
        int maxlength=Integer.MIN_VALUE;

        while(e<s.length())
        {
            if(map.containsKey(s.charAt(e)))
            {
                map.put(s.charAt(e),map.get(s.charAt(e))+1);
            }
            else
            {
                if(charCount==2)
                {
                    // write code to remove characters
                    while(charCount==2)
                    {
                        int charc = map.get(s.charAt(st));
                        if(charc==1)
                        {map.remove(s.charAt(st));
                            charCount--;
                        }
                        else{
                            map.put(s.charAt(st),map.get(s.charAt(st))-1);
                        }
                        st++;
                    }
                    map.put(s.charAt(e),1);
                    charCount++;
                }
                else
                {
                    // add character to map and char count
                    map.put(s.charAt(e),1);
                    charCount++;
                }
            }
            e++;
            //System.out.println("CharCount"+charCount+" length"+(e-st));
            maxlength=Math.max(maxlength,e-st);
        }
        return maxlength;
    }
}