// Add Two Numbers As List
/** You are given two linked lists, A and B, representing two non-negative numbers.
 *The digits are stored in reverse order, and each of their nodes contains a single digit.
 *Add the two numbers and return it as a linked list.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode AnsStart = new ListNode(0);
        ListNode Ans=AnsStart;

        int sum;
        int carry=0;
        while(true)
        {
            if(A==null && B==null)
            {
                if(carry!=0)
                {
                    Ans.next = new ListNode(carry);
                    Ans = Ans.next;
                }
                break;
            }
            else if(A==null)
            {
                sum = B.val +carry;
                B= B.next;
            }
            else if(B==null)
            {
                sum = A.val +carry;
                A= A.next;
            }
            else
            {
                sum = A.val + B.val +carry;
                A= A.next;
                B= B.next;
            }
            carry = sum/10;
            sum = sum%10;
            Ans.next = new ListNode(sum);
            Ans = Ans.next;
        }
        return AnsStart.next;
    }
}
