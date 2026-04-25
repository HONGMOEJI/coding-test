import java.util.*;
class Solution {
    int cnt=0;
    
    private void dfs(int flag, int cur, int[] numbers, int target){
        if (flag == numbers.length) {
            if (cur == target) cnt++;
            return;
        }
        dfs(flag+1,cur+numbers[flag],numbers,target);
        dfs(flag+1,cur-numbers[flag],numbers,target);
    }

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return cnt;
    }
}