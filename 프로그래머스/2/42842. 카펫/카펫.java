class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result=new int[2];
        int totalSqr = brown+yellow;
        int w;
        
        for(int h=1;h<=Math.sqrt(totalSqr);h++){
            if(totalSqr%h==0){
                w=totalSqr/h; // w>=h 만족
                if((w-2)*(h-2)==yellow){
                    result[0]=w;
                    result[1]=h;
                }
            }
        }
        return result;
    }
}