package leetcode051_100;

import java.util.List;

/**
 * Created by yesongren on 2020/2/12
 * #092. Reverse Linked List II
 * Recursive
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReverseLinkedList2 {
    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) return reverseN(head, n);
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
