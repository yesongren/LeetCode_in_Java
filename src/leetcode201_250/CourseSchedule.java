package leetcode201_250;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yesongren on 2020/8/4
 * 207. Course Schedule
 */
public class CourseSchedule {
    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited,
                             boolean[] checked, int v) {
        if (visited[v]) return true;
        visited[v] = true;
        for (int i : graph.get(v))
            if (!checked[i] && hasCycle(graph, visited, checked, i))
                return true;
        checked[v] = true;
        visited[v] = false;
        return false;
    }

    public boolean canFinish(int n, int[][] pairs) {
        if (n <= 1 || pairs == null || pairs.length == 0) return true;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            graph.add(new LinkedList<>());

        for (int[] pair : pairs)
            graph.get(pair[1]).add(pair[0]);

        boolean[] checked = new boolean[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i)
            if (!checked[i] && hasCycle(graph, visited, checked, i))
                return false;
        return true;
    }
}
