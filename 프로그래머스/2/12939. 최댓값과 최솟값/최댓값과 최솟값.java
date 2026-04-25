class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i;
        
        for(String num: nums){
            i=Integer.parseInt(num);
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        String answer = min + " " + max;
        return answer;
    }
}