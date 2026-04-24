import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // targetValue를 담을 ArrayList
        List<Integer> targetVal = new ArrayList<>();

        for(int[] command : commands) {
            // 시작, 끝 인덱스와 타깃 인덱스
            int start = command[0]-1;
            int end = command[1]-1;
            int targetIdx = command[2]-1;

            // 값들을 담을 배열
            int[] arr = new int[end-start+1];

            for(int i = start; i<=end; i++){
                arr[i-start] = array[i];
            }
            Arrays.sort(arr);
            targetVal.add(arr[targetIdx]);
        }
        
        return targetVal.stream().mapToInt(i->i).toArray();
    }
}