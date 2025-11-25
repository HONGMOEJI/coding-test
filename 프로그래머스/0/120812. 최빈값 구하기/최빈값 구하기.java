import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: array){
            map.put(num,  map.getOrDefault(num, 0) + 1);
        }

        // return Mode value, if there are multiple modes, return -1
        int maxCount = 0;
        int mode = -1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                mode = entry.getKey();
            }else if(entry.getValue() == maxCount){
                mode = -1; // multiple modes
            }
        }  
        return mode;
    }
}
