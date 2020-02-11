package leetcode001_050;

import java.util.List;

/**
 * Created by yesongren on 2019/11/27
 * #021. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return dummyHead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        /**
         * 先建立dummy head（root）和 cur，令 cur 指向 root
         * 当两个指针不同时位空的时候，进入循环：
         * 比较 val1 和 val2，如果：val1 < val2:
         *                                     cur.next = l1;
         *                                     l1 = l1.next;
         *                                     cur = cur.next;
         *                                反之：
         *                                     cur.next = l2;
         *                                     l2 = l2.next;
         *                                     cur = cur.next;
         */
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while(l1 != null || l2 != null) {
            int val1 = (l1 == null) ? Integer.MAX_VALUE : l1.val;  // 注意处理空指针问题
            int val2 = (l2 == null) ? Integer.MAX_VALUE : l2.val;
            if (val1 < val2) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        return root.next;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        /**
         * recursive
         */
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }
}
