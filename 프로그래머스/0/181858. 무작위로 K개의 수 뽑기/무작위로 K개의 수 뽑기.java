class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        int cnt = 0;

        for (int i = 0; i < arr.length && cnt < k; i++) {
            boolean exists = false;

            for (int j = 0; j < cnt; j++) {
                if (answer[j] == arr[i]) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                answer[cnt++] = arr[i];
            }
        }

        while (cnt < k) {
            answer[cnt++] = -1;
        }

        return answer;
    }
}