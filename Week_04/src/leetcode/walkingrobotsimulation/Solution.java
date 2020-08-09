package leetcode.walkingrobotsimulation;

import java.util.HashSet;

/**
 * leetcode #874
 * <p>
 * https://leetcode-cn.com/problems/walking-robot-simulation/
 * <p>
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 *
 * @author YangQi
 */
public class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {

        // 初始化坐标以及参数
        int res = 0;
        int x = 0;
        int y = 0;
        // 方向 0 北,1 东,2 南,3 西
        int direction = 0;
        // 数组对应方向坐标变化，北，东，南，西
        int[][] Direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // 构建HashSet存储障碍物
        HashSet<String> set = new HashSet<>();
        for (int[] arr : obstacles) {
            set.add(arr[0] + "," + arr[1]);
        }

        // 判定commands,并且计算下一个坐标
        for (int com : commands) {
            // 预判下一个位置
            int next_x = 0;
            int next_y = 0;
            // 当前指令为前进
            if (com >= 0) {
                for (int i = 0; i < com; i++) {
                    // 判定是否遇到障碍物，并且计算结果
                    next_x = x + Direct[direction][0];
                    next_y = y + Direct[direction][1];
                    if (set.contains(next_x + "," + next_y)) {
                        break;
                    } else {
                        x = next_x;
                        y = next_y;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            } else {
                // 当前指令为转方向, -1 向右，-2 向左
                direction = com == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] commands = {4, -1, 3};
        int[][] obstacles = {};

        System.out.println("result = " + solution.robotSim(commands, obstacles));
    }
}
