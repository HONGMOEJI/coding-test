class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int totDenom = denom1 * denom2;
        int totNumer = numer1*denom2 + numer2*denom1;
        
        int gcd = getGcd(totDenom, totNumer);
        totDenom /= gcd;
        totNumer /= gcd;
        answer[0] = totNumer;
        answer[1] = totDenom;
        return answer;
    }
    
    private static int getGcd(int a, int b) {
        if (b == 0) return a;
        else return getGcd(b, a%b);
    }
}
