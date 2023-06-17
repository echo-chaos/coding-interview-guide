package org.lql.guide.chapter01.topic06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liangqinglong
 * @date: 2023-06-17 19:22
 * @description: 汉诺塔-递归
 */
public class HanoiTower01 {

    private static final Logger logger = LoggerFactory.getLogger(HanoiTower01.class);

    private static final String LEFT = "left";
    private static final String MID = "mid";
    private static final String RIGHT = "right";

    public static int hanoiTower(int num, String left, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, right);
    }

    public static int process(int num, String from, String to) {
        // 移动第n层
        if (num == 1) {
            if (from.equals(MID) || to.equals(MID)) {
                // 左->中 或 中->右 一个步骤
                logger.info("Move 1 from {} to {}", from, to);
                return 1;
            } else {
                // 左->中->右 两个步骤
                logger.info("Move 1 from {} to {}", from, MID);
                logger.info("Move 1 form {} to {}", MID, to);
                return 2;
            }
        }
        // 递归处理
        if (from.equals(MID) || to.equals(MID)) {
            // 计算另一个目的点：因为起终点有mid，所以另一个目的点：[left,right]
            String another = (from.equals(LEFT) || to.equals(LEFT)) ? RIGHT : LEFT;
            // 递归处理1~N-1层，from to another, ==> 左->中 或 右->中
            int part1 = process(num - 1, from, another);
            // 将第N层塔从 左->中 或 右->中，只有1步
            int part2 = 1;
            logger.info("Move {} form {} to {}", num, from, to);
            // 将 1~N-1层塔全部从：中->左 或 中->右
            int part3 = process(num - 1, another, to);
            return part1 + part2 + part3;
        } else {
            // 递归处理1~N-1层
            int part1 = process(num - 1, from, to);
            // 将第N层移动到中间
            int part2 = 1;
            logger.info("Move {} from {} to {}", num, from, MID);
            // 将1~N-1层移动到另一端
            int part3 = process(num - 1, to, from);
            // 将N层从中间移动到右
            int part4 = 1;
            logger.info("Move {} from {} to {}", num, MID, to);
            // 递归处理1~N-1从左移到右
            int part5 = process(num - 1, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int times = hanoiTower(n, LEFT, RIGHT);
        logger.info("{} 层汉诺塔移动次数 {}", n, times);
    }
}
