import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // id_list 순, 유저가 받은 메일의 수
        int[] answer = {};
        
        // 신고당한 유저와 그 유저를 신고한 사람의 수
        Map<String, Set<String>> reportedMap = new HashMap<>();
        Map<String, Integer> mailMap = new HashMap<>();
        
        for(String id: id_list){
            reportedMap.put(id, new HashSet<>());
            mailMap.put(id, 0);
        }
        
        // 신고당한 유저의 이름과 그를 신고한 유저의 이름
        for(String reported: report) {
            String[] split = reported.split(" ");
            String reporter = split[0];
            String reportedUser = split[1];
            
            reportedMap.get(reportedUser).add(reporter);
        }
        
        // 유저별로 메일을 받을 수를 결정
        for(String reported: reportedMap.keySet()) {
            Set<String> reporters = reportedMap.get(reported);
            
            if(reporters.size() >= k){
                for(String reporter: reporters){
                    mailMap.put(reporter, mailMap.get(reporter)+1);
                }
            }
        }
        
        answer = new int[id_list.length];
        
        for(int i=0; i<id_list.length; i++){
            answer[i] = mailMap.get(id_list[i]);
        }
        return answer;
    }
}