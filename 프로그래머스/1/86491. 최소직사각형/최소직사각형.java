class Solution {
    public int solution(int[][] sizes) {
        int wMax=0;
        int hMax=0;
        for(int[] wh: sizes){
            // 가로를 긴 변으로 세로를 짧은 변으로
            if(wh[0]<wh[1]){
                int temp = wh[0];
                wh[0] = wh[1];
                wh[1] = temp;
            }
            wMax = Math.max(wMax, wh[1]);
            hMax = Math.max(hMax, wh[0]);
        }
        return wMax*hMax;
    }
}