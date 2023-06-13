package org.lql.guide.chapter01.topic01;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2023-06-12 22:19
 * @description: 设计一个有getMin功能的栈
 */
public class MyStack1 {

    private Stack<Integer> stackData;

    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int data) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(data);
        } else if (data <= this.getMin()) {
            this.stackMin.push(data);
        }
        this.stackData.push(data);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return this.stackMin.peek();
    }
}
