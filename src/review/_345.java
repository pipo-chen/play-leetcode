package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _345 {
    public String reverseVowels(String s) {
        //忽略大小写
        char [] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!vowel(arr[i]) && i < j)
                i++;
            while (!vowel(arr[j]) && i < j)
                j--;
            if (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
                i++;
            }

        }
        return String.valueOf(arr);
    }

    public boolean vowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'I' || c == 'i' || c == 'o' || c =='O' || c =='u' || c == 'U')
            return true;
        return false;
    }
    public static void main(String []args) {
        String s = "leetcode";
        String res = new _345().reverseVowels(s);
        System.out.println(res);
    }
}
