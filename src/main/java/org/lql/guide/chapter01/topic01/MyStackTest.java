package org.lql.guide.chapter01.topic01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liangqinglong
 * @date: 2023-06-13 23:26
 * @description:
 */
public class MyStackTest {

    private static final Logger logger = LoggerFactory.getLogger(MyStackTest.class);

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 6, 3, 9, -11, 99};
        logger.info("入栈数据为：{}", arr);

        MyStack1 myStack1 = new MyStack1();
        for (int i : arr) {
            myStack1.push(i);
        }
        logger.info("MyStack1 获取最小值为：{}", myStack1.getMin());

        MyStack2 myStack2 = new MyStack2();
        for (int i : arr) {
            myStack2.push(i);
        }
        logger.info("MyStack2 获取最小值为：{}", myStack2.getMin());
    }
}
