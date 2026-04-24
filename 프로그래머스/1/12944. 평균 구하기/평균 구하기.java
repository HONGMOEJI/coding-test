import java.util.Arrays;

public class Solution {
    public double solution(int[] arr) {
        return ((double)Arrays.stream(arr).sum() / arr.length);
    }
}
