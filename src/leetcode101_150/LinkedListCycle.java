package leetcode101_150;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by yesongren on 2019/11/27
 * #141. Linked List Cycle
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        /**
         * 快慢指针法；
         * Time: O(n), Space: O(1);
         */
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {  //用slow进行判断会runtime error, java.lang.NullPointerException
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        /**
         * 哈希表；
         * Time: O(n), Space: O(n);
         */
        Set<ListNode> set = new HashSet<>();
        for (ListNode p = head; p != null; p = p.next) {
            if (set.contains(p)) return true;
            set.add(p);
        }
        return false;
    }
}
