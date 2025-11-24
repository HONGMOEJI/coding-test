class Solution {
    private boolean isFit(int[] wallet, int[] bill) {
        if(wallet[0] >= bill[0] && wallet[1] >= bill[1] || wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
            return false;
        } else return true;
    }
    public int solution(int[] wallet, int[] bill) {
        boolean flag = true;

        int answer = 0;

        while(isFit(wallet, bill)) {
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
                answer += 1;
            } else {
                bill[1] /= 2;
                answer += 1;
            }
        }

        return answer;
    }
}
