package solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _1620 {
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> list = new ArrayList();
        for (String s : words)
            list.add(s);

        for (int i = 0; i < num.length(); i++) {
            char cur_num = num.charAt(i);
            //判断是否匹配
            //把 a b c 是否包含
            //循环判断每组

            for (int j = 0; j < list.size(); j++) {
                if (num.length() != list.get(j).length()) {
                    list.remove(j);
                    continue;
                }
                //判断每组的那个都等于
                char compare_num = numAndLetter(list.get(j).charAt(i));
                if (compare_num != cur_num) {
                    list.remove(j);
                    continue;
                }
            }
        }

        return list;
    }

    public char numAndLetter(char num) {
        if (num == 'a' || num == 'b' || num == 'c') {
            return '2';
        } else if (num == 'd' || num == 'e' || num == 'f') {
            return '3';
        } else if (num == 'g' || num == 'h' || num == 'i') {
            return '4';
        } else if (num == 'j' || num == 'k' || num == 'l') {
            return '5';
        } else if (num == 'm' || num == 'n' || num == 'o') {
            return '6';
        } else if (num == 'p' || num == 'q' || num == 'r' || num == 's') {
            return '7';
        } else if (num == 't' || num == 'u' || num == 'v') {
            return '8';
        } else {
            return '9';
        }
    }
    public static void main(String[] args) {
        String num = "8733";
        String[] words = {"tree","usedy"};
        List<String> result_words = new _1620().getValidT9Words(num, words);
        Iterator iterator = result_words.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
