package leetcode201_250;

import java.util.List;

/**
 * Created by yesongren on 2019/12/6
 * 206. Reverse Linked List
 *
 * Iteration or Recursive
 */
public class ReverseLinkedList {

    /* Iteration sol */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy_head = null;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = dummy_head;
            dummy_head = curr;
            curr = temp;
        }
        return dummy_head;
    }

    /* recursive sol */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
