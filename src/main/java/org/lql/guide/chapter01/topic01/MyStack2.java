package org.lql.guide.chapter01.topic01;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2023-06-12 22:28
 * @description: 设计一个具有getMin功能的栈
 */
public class MyStack2 {
    private Stack<Integer> stackData;

    private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int data) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(data);
        } else if (data < this.getMin()) {
            this.stackMin.push(data);
        } else {
            Integer peek = this.stackMin.peek();
            this.stackMin.push(peek);
        }
        this.stackData.push(data);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return this.stackMin.peek();
    }
}
