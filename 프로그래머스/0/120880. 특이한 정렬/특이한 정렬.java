class Solution {
    public int[] solution(int[] numlist, int n) {

        int[] clone = numlist.clone();

        // 1) n 빼기
        for(int i=0; i<clone.length; i++){
            clone[i] -= n;
        }

        // 2) 절댓값 기준 정렬 (직접 구현)
        for(int i=0; i<clone.length; i++){
            for(int j=i+1; j<clone.length; j++){
                int a = clone[i];
                int b = clone[j];

                int absA = Math.abs(a);
                int absB = Math.abs(b);

                // 먼저 절댓값 비교
                if(absA > absB){

                    int temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;

                    // 절댓값 같으면? 양수 먼저 (즉 b > a 이면 바꿔야 함)
                } else if(absA == absB && a < b){

                    int temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;

                }
            }
        }

        // 3) 다시 n 더하기
        for(int i=0; i<clone.length; i++){
            clone[i] += n;
        }

        return clone;
    }
}