package solution;

import java.util.Stack;

public class _0304 {
    class MyQueue {
        private Stack<Integer>pushStack;
        private Stack<Integer>removeStack;


        /** Initialize your data structure here. */
        public MyQueue() {
            pushStack = new Stack<>();
            removeStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            //push栈中倒过来再输出
            while (!pushStack.empty()) {
                removeStack.push(pushStack.pop());
            }
            int element = removeStack.pop();
            //再倒回去
            while (!removeStack.empty()) {
                pushStack.push(removeStack.pop());
            }
            return element;
        }

        /** Get the front element. */
        public int peek() {
            while (!pushStack.isEmpty()) {
                removeStack.push(pushStack.pop());
            }
            int element = removeStack.peek();
            while (!removeStack.isEmpty()) {
                pushStack.push(removeStack.pop());
            }
            return element;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushStack.isEmpty();
        }
    }
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


}
