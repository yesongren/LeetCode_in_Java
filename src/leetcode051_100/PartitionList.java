package leetcode051_100;

/**
 * Created by yesongren on 2021/1/3
 * 086. Partition List
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode smaller = new ListNode(0), greater = new ListNode(0);
        ListNode ps = smaller, pg = greater, p = head;
        while(p != null) {
            if (p.val < x) {
                ps.next = p;
                ps = ps.next;
            } else {
                pg.next = p;
                pg = pg.next;
            }
            p = p.next;
        }
        ps.next = greater.next;
        pg.next = null;
        return smaller.next;
    }
}
