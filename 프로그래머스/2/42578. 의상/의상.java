import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for(String[] cloth: clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1],0)+1);
        }

        // 각 종류별로 1가지씩만, + 조합
        for(int count: map.values()){
            answer *= (count+1); // 아예 안입는 경우 포함
        }
        return answer-1; // 모든 종류의 의류를 안 입는 경우 제외
    }
}