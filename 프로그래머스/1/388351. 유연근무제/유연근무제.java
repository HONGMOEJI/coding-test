class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday){
        int answer = 0;

        // schedules[] -> 각 인원의 출근 스케쥴
        // timelogs[][] -> 각 인원의 일주일 출근 시간 기록
        // startday -> 시작일의 요일 1:월 ~ 7: 일 토 - 일은 무시

        for (int i=0; i<schedules.length; i++) {
            int scheduleHour = schedules[i]/100;
            int scheduleMin = schedules[i]%100;
            int[] timelog = timelogs[i];
            boolean isPerfect = true;
            for (int j=0; j<7; j++){
                int logHour = timelog[j]/100;
                int logMin = timelog[j]%100;
                int timeDiff = logHour*60 + logMin - (scheduleHour*60 + scheduleMin);
                if((startday+j)%7==6 || (startday+j)%7==0){
                    continue; // 토, 일은 무시
                } else {
                    if(timeDiff>10)
                        isPerfect = false; // 지각이 한번이라도 있으면 대상 x
                }
            }
            if(isPerfect) answer++;
        }
        return answer;
    }
}
