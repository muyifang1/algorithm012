package leetcode.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * @author YangQi
 */
public class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // push
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 交换queue1 和 queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // pop
    public int pop() {
        return queue1.poll();
    }

    // top
    public int top() {
        return queue1.peek();
    }

    // empty
    public boolean empty() {
        return queue1.isEmpty();
    }
}
