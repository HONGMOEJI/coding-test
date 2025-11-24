class Solution {
    public int solution(int n) {
        int sum = 0;
        if(isEven(n)) {
            for(int i=2; i<=n; i=i+2){
                sum += i*i;
            }
        } else {
            for(int i=1; i<=n; i=i+2){
                sum+=i;
            }
        }
        return sum;
    }
    
    private static boolean isEven(int n) {
        if(n%2 == 0) return true;
        else return false;
    }
}