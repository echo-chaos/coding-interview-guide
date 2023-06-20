package org.lql.guide.chapter01.topic09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2023-06-20 22:37
 * @description: 最大子矩阵的大小
 */
public class MaxRecSize {

    private static final Logger logger = LoggerFactory.getLogger(MaxRecSize.class);

    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = ints[j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, maxRecFromBottom(height));
        }
        return maxArea;
    }

    public static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        logger.info("矩阵map： {}", Arrays.deepToString(map));
        int i = maxRecSize(map);
        logger.info("最大子矩阵的大小: {}", i);

    }
}
