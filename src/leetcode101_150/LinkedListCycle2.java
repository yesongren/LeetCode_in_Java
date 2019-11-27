package leetcode101_150;

/**
 * Created by yesongren on 2019/11/27
 * #142. Linked List Cycle II
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        //判断是否存在环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast != slow) return null;  // 不存在环

        fast = head;
        while (fast != slow) {  // 相遇即为入口
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
