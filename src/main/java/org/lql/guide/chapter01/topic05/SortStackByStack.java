package org.lql.guide.chapter01.topic05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2023-06-16 00:33
 * @description: 用一个栈实现另一个栈的排序
 */
public class SortStackByStack {

    private static final Logger logger = LoggerFactory.getLogger(SortStackByStack.class);

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            // 如果cur <= help栈顶元素，将cur直接压入help
            // 如果cur >  help栈顶元素，将help的元素逐一弹出，逐一压入stack，直到cur <= help栈顶元素，再将cur压入help
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 11, 0, 22, 9, 87, 122, 911};
        Stack<Integer> stack = new Stack<>();
        logger.info("入栈的数据：{}", arr);
        for (int i : arr) {
            stack.push(i);
        }
        sortStackByStack(stack);
        logger.info("出栈数据：");
        stack.forEach(System.out::println);
    }
}
