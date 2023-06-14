package org.lql.guide.chapter01.topic03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2023-06-14 23:24
 * @description:
 */
public class ReverseOrderStackTest {

    private static final Logger logger = LoggerFactory.getLogger(ReverseOrderStackTest.class);

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            stack.push(i);
        }
        logger.info("入栈数据：{}", arr);
        ReverseOrderStack reverseOrderStack = new ReverseOrderStack();
        reverseOrderStack.reverse(stack);
        logger.info("出栈数据：");
        stack.stream().forEach(System.out::println);
    }
}
