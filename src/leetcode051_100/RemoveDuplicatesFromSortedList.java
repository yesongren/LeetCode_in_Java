package leetcode051_100;

/**
 * Created by yesongren on 2020/2/21
 * 83. Remove Duplicates from Sorted List
 *
 * Time: O(n), Space: O(1)
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while(cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while(fast != null && fast.next != null) {
            if(fast.val == fast.next.val) {
                do {fast = fast.next;}
                while(fast.next != null && fast.val == fast.next.val);
                slow.next = fast;
                slow = fast;
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return dummy.next;
    }
}
