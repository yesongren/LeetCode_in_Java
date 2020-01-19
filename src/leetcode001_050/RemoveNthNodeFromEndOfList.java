package leetcode001_050;

/**
 * Created by yesongren on 2020/1/19
 * 019. Remove Nth Node From End of List
 * two pointers
 * 1、新建一个新链表res，并让res的next指针指向head。并新建fast和slow，他们均指向res。
 * 2、将fast往后移n个距离。
 * 3、同时移动fast和slow，直到fast.next == null为止。
 * 4、此时slow为倒数第n个节点的前一个节点。slow.next = slow.next.next就可以将倒数第n个节点移除。
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
