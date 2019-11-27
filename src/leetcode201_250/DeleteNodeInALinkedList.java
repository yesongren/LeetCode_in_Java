package leetcode201_250;

/**
 * Created by yesongren on 2019/11/27
 * #237. Delete Node in a Linked List
 */
class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {val = x;}
}

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
