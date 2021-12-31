package solution;

import java.util.*;

public class _20 {
	public boolean isValid(String s) {
		if (s.length() % 2 != 0)
			return false;
		Deque stack = new LinkedList();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(cur);
				continue;
			}
			if ((cur == ')' && stack.peek().equals('(')) ||(cur == '}' && stack.peek().equals('{')) ||(cur == ']' && stack.peek().equals('[')) )
				stack.pop();
			else
				stack.push(cur);
		}
		return stack.isEmpty();
    }

    public static void main(String[] args) {
		String s = "((])";
		boolean res = new _20().isValid(s);
		System.out.println(res);
	}
}
