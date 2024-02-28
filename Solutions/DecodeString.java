//Decode String
//https://leetcode.com/problems/decode-string/description/
class Solution {
    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<StringBuilder> strStack = new Stack<StringBuilder>();
        int num=0;
        for(char c:s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                num = num*10 + c-'0';
            }
            else if(c=='[')
            {
                intStack.push(num);
                num=0;
                strStack.push(str);
                str= new StringBuilder();
            }
            else if(c==']')
            {
                StringBuilder temp = str;
                int count = intStack.pop();
                str = strStack.pop();
                while(count>0)
                {
                    str.append(temp);
                    count--;
                }
            }
            else
            {
                str.append(c);
            }
        }
        return str.toString();
    }
}