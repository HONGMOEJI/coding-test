class Solution {
    public long solution(long n) {
        long answer = 0;
    
        // 정수형으로 타입 변환
        long sqrt = (long)Math.sqrt(n);
        
        if(sqrt*sqrt==n) return (sqrt+1)*(sqrt+1);
        
        return -1;
    }
}