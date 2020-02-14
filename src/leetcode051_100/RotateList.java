package leetcode051_100;

/**
 * Created by yesongren on 2020/2/14
 * 61. Rotate List
 * <p>
 * Cycle List
 * Time: O(N), Space: O(1)
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 1;   // the length of the list
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len;
        if (k == 0) return head;
        int distanceToNewhead = len - k;
        tail.next = head;   // cycle list
        ListNode newTail = tail;
        while (distanceToNewhead-- > 0) {
            newTail = newTail.next;
        }
        ListNode newhead = null;
        newhead = newTail.next;
        newTail.next = null;
        return newhead;
    }
}
