package org.lql.guide.chapter01.topic03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2023-06-14 23:16
 * @description: 使用递归函数和栈操作逆序一个栈
 */
public class ReverseOrderStack {

    private static final Logger logger = LoggerFactory.getLogger(ReverseOrderStack.class);

    /**
     * 移除并返回当前栈底元素
     *
     * @param stack
     * @return:
     * @author: liangqinglong
     * @date: 2023-06-14 23:23
     **/
    public int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        logger.info("逆序获取的数据：{}", i);
        reverse(stack);
        stack.push(i);
    }
}
