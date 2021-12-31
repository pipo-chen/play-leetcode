package review;

public class _3_3_3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = -1, len = 0;
        int []freq = new int[128];
        char []arr = s.toCharArray();
        while (left < arr.length) {
            if (right < arr.length-1 && freq[arr[right+1]] == 0) {
                freq[arr[++right]]++;
            } else {
                freq[arr[left++]]--;
            }
            len = Math.max(len, right - left + 1) ;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = " ";
        int res = new _3_3_3().lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
