package leetcode051_100;

/**
 * Created by yesongren on 2020/2/17
 * 82. Remove Duplicates from Sorted List II
 *
 * two pointers
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head;
        ListNode latter = dummy;
        while(pre != null && pre.next != null) {  // 注意避免产生空指针异常
            if(pre.val == pre.next.val) {
                do {
                    pre = pre.next;
                } while(pre.next != null && pre.val == pre.next.val);  // pre.next不能为空
                latter.next = pre.next;
                pre = pre.next;
            } else {
                pre = pre.next;
                latter = latter.next;
            }
        }
        return dummy.next;
    }
}
