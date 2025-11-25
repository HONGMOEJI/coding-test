class Solution {
    public int solution(int[] common) {
        int answer = 0;
        if(common[2]-common[1] == common[1]-common[0]) {
            // 등차수열
            int diff = common[1]-common[0];
            answer = common[common.length-1] + diff;
        } else {
            // 등비수열
            int ratio = common[1]/common[0];
            answer = common[common.length-1] * ratio;
        }
        return answer;
    }

    
}
