package solution;

import netscape.security.UserTarget;

import java.util.Arrays;

/**
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class _557 {
	public String reverseWords(String s) {
		//在不是用 split 的前提下进行操作
		int begin = 0, end = 0;
		char [] sentence = s.toCharArray();

		while (end < sentence.length) {
			while (end < sentence.length && sentence[end] != ' ') {
				end++;
			}
			//end 抵达单词尾部空格
			int j = end;
			//开始转动
			end--;
			while (begin < end) {
				char temp = sentence[begin];
				sentence[begin] = sentence[end];
				sentence[end] = temp;
				begin++;
				end--;
			}
			end = begin = j + 1;
		}
		return String.valueOf(sentence);
    }
    public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		String res = new _557().reverseWords(s);
		System.out.println(res);
	}
}
