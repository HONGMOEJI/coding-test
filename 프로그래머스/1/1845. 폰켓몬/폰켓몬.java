import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 선택할 폰켓몬 수
        int availablePonketmon = nums.length / 2;
        
        // 중복 제거를 위한 HashSet
        Set<Integer> ponketmonSpecies = new HashSet<>();
        
        for(int num: nums){
            ponketmonSpecies.add(num);
        }
        
        if(ponketmonSpecies.size() <= availablePonketmon) return ponketmonSpecies.size();
        else return availablePonketmon;
    }
}