import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int idx;
        int cntOverH;
        int maxH = Integer.MIN_VALUE;

        for(idx=0; idx<citations.length; idx++){
            cntOverH=citations.length-idx; // 자기 자신 포함
            int h = Math.min(citations[idx], cntOverH);
            maxH = Math.max(maxH, h);
        }
        return maxH;
    }
}