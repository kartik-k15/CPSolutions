/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode StartNode = new ListNode(0);
        ListNode Start = StartNode;
        while(true)
        {
            if(A==null)
            {
                Start.next = B;
                break;
            }
            else if(B==null)
            {
                Start.next=A;
                break;
            }
            else if(A.val>B.val)
            {
                Start.next=B;
                B=B.next;
                Start = Start.next;
            }
            else
            {
                Start.next = A;
                A = A.next;
                Start = Start.next;
            }
        }
        return StartNode.next;
    }
}
