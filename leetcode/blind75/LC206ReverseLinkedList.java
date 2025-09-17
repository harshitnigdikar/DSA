package dsa.leetcode.blind75;

public class LC206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;

        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
}
