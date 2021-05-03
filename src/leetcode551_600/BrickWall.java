package leetcode551_600;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yesongren on 2021/5/3
 *
 * 554. Brick Wall
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnter = new HashMap<>();
        for (List<Integer> bricks : wall) {
            int num = bricks.size();
            int sum = 0;
            for (int i = 0; i < num - 1; i++) {
                sum += bricks.get(i);
                cnter.put(sum, cnter.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnter.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }
}
