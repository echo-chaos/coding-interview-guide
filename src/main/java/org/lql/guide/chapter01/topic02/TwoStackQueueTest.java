package org.lql.guide.chapter01.topic02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liangqinglong
 * @date: 2023-06-13 23:19
 * @description: 由两个栈组成的队列测试
 */
public class TwoStackQueueTest {

    private static final Logger logger = LoggerFactory.getLogger(TwoStackQueueTest.class);

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        // 依次压入1、2、3、4、5
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        // 查看当前顶部数据
        int peek = queue.peek();
        logger.info("顶部数据为：{}", peek);
        // 依次弹出数据
        logger.info("弹出数据为：{}", queue.poll());
        logger.info("弹出数据为：{}", queue.poll());
        logger.info("弹出数据为：{}", queue.poll());
        logger.info("弹出数据为：{}", queue.poll());
        logger.info("弹出数据为：{}", queue.poll());
    }
}
