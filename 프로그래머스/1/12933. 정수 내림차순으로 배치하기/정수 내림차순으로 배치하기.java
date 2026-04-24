import java.util.Arrays;

public class Solution {
    public long solution(long n) {
        String s = Long.toString(n);

        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(arr);
        sb.reverse();
        
        return Long.parseLong(sb.toString());
    }
}
