class Solution {
    public boolean solution(int x) {
        // 자릿수의 합 구하기
        int sum=0;
        int i=x;
        while(i>0){
            sum+=i%10;
            i/=10;
        }
        
        return (x%sum==0)?true:false;
    }
}