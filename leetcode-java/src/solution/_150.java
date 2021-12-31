package solution;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */
public class _150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int v1, v2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v1 + v2);
                    break;
                case "-":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 - v1);
                    break;
                case "*":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v1 * v2);
                    break;
                case "/":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 / v1);
                    break;
                default:
                    stack.push(Integer.valueOf(s));

            }

        }

        return stack.peek();
    }

    public static void main(String[] args) {

        String [] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        int res = new _150().evalRPN(tokens);
        System.out.println(res);

    }
}
