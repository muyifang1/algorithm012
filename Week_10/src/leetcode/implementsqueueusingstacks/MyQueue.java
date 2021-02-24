package leetcode.implementsqueueusingstacks;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author YangQi
 */
public class MyQueue {
    // 思路，使用两个 Stack 一个入，一个出
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        // 重点：当outStack为空时 执行transfer
        if (outStack.isEmpty()) {
            transfer();
        }
        return outStack.pop();
    }

    public int peek() {
        // 重点：当outStack为空时 执行transfer
        if (outStack.isEmpty()) {
            transfer();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    // 将inStack 转移到 outStack
    private void transfer() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue demo = new MyQueue();
        demo.push(1);
        demo.push(2);
        demo.push(3);
        System.out.println("demo.empty() = " + demo.empty());
        System.out.println("demo.peek() = " + demo.peek());
        System.out.println("demo.pop() = " + demo.pop());
        System.out.println("demo.pop() = " + demo.pop());
        System.out.println("demo.pop() = " + demo.pop());
        System.out.println("demo.empty() = " + demo.empty());
    }
}
