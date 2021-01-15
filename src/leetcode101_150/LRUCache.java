package leetcode101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2021/1/15
 * 146. LRU Cache
 */
class LinkNode {
    int key;
    int val;
    LinkNode front;
    LinkNode next;
    LinkNode(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

public class LRUCache {
    private int capacity;
    private Map<Integer, LinkNode> map = new HashMap<>();
    private LinkNode head = new LinkNode(0, 0);
    private LinkNode tail = new LinkNode(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.front = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            detachAndMoveNodeToTop(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) deleteLastNode();
            LinkNode tmp = head.next;
            LinkNode newNode = new LinkNode(key, value);
            head.next = newNode;
            newNode.front = head;
            newNode.next = tmp;
            tmp.front = newNode;
            map.put(key, newNode);
        } else {
            LinkNode node = map.get(key);
            node.val = value;
            detachAndMoveNodeToTop(node);
        }
    }

    private void deleteLastNode() {
        LinkNode lastNode = tail.front;
        lastNode.next.front = lastNode.front;
        lastNode.front.next = lastNode.next;
        map.remove(lastNode.key);
    }

    private void detachAndMoveNodeToTop(LinkNode node) {
        node.front.next = node.next;
        node.next.front = node.front;
        LinkNode tmp = head.next;
        node.front = head;
        head.next = node;
        node.next = tmp;
        tmp.front = node;
    }
}
