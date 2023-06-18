package org.lql.guide.chapter01.topic07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * @author: liangqinglong
 * @date: 2023-06-18 01:49
 * @description: 生成窗口最大值数组
 */
public class MaxWindowArray {

    private static final Logger logger = LoggerFactory.getLogger(MaxWindowArray.class);

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // 双端队列始终维持一个前大后小的结构，随着窗口右移，队列前面的元素会失效
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        int[] maxWindow = getMaxWindow(arr, w);
        logger.info("原数组：{}", arr);
        logger.info("滑动窗口大小：{}", w);
        logger.info("滑动窗口数组：{}", maxWindow);
    }
}
