/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode merge(ListNode left, ListNode right)
    {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(left!=null && right!=null)
        {
            if(left.val<right.val)
            {
                temp.next = left;
                temp = left;
                left = left.next;
            }
            else
            {
                temp.next = right;
                temp=right;
                right = right.next;
            }
        }

        if(left!=null)
        {
            temp.next = left;
        }
        if(right!=null)
        {
            temp.next = right;
        }
        return dummy.next;
    }

    public ListNode mergeSort(ListNode[] lists, int start, int end)
    {
        if(start==end)
        {
            return lists[start];
        }
        int mid = (start+end)/2;
        ListNode left = mergeSort(lists,start,mid);
        ListNode right = mergeSort(lists, mid+1,end);
        return merge(left,right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
        {
            return null;
        }
        return mergeSort(lists,0,lists.length-1);
    }
}