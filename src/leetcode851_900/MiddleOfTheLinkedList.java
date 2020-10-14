package leetcode851_900;

import util.ListNode;

/**
 * Created by yesongren on 2020/10/14
 * 876. Middle of the Linked List
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int steps = len / 2;
        cur = head;
        while (steps-- > 0) {
            cur = cur.next;
        }
        return cur;
    }
}
