package leetcode_1000plus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yesongren on 2020/7/8
 * 1306. Jump Game III
 */
public class LC1306_JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        // bfs用的Queue
        Queue<Integer> q = new LinkedList<>();
        // 将起点加入Queue
        q.offer(start);
        // 访问数组。记录访问过的节点。避免重复访问
        boolean[] visited = new boolean[arr.length];
        // 设置起点已被访问过
        visited[start] = true;
        // 开始bfs
        while (q.size() > 0) {
            // 取出一个index
            int index = q.poll();
            // 当前下标的值为0，返回true
            if (arr[index] == 0) return true;
            // 当前点能连接到的其他节点
            int next1 = index - arr[index];
            // 如果该节点不越界，并且没被访问过
            if (next1 >= 0 && !visited[next1]) {
                // 设置该节点已被访问
                visited[next1] = true;
                // 将该节点存入Queue
                q.offer(next1);
            }
            // 同理
            int next2 = index + arr[index];
            if (next2 < arr.length && !visited[next2]) {
                visited[next2] = true;
                q.offer(next2);
            }
        }
        return false;
    }
}
