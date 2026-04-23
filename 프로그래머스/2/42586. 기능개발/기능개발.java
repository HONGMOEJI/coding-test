import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remainDay = new int[progresses.length];
        int remainPercent = 0;
        
        for(int i=0; i<progresses.length; i++){
            remainPercent = 100 - progresses[i];
            remainDay[i] = remainPercent/speeds[i] + (remainPercent%speeds[i]>0?1:0);
        }
        
        List<Integer> list = new ArrayList<>();
        int deployCnt = 1;
        int day = remainDay[0];
        
        for(int j=1; j<remainDay.length; j++){
            if(day >= remainDay[j]) deployCnt++;
            else{
                list.add(deployCnt);
                deployCnt=1;
                day = remainDay[j];
            }
        }
        list.add(deployCnt);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}