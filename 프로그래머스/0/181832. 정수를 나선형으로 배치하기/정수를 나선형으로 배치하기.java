public class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int num = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {

            // 오른쪽
            for (int y = left; y <= right; y++)
                answer[top][y] = num++;
            top++;

            // 아래
            for (int x = top; x <= bottom; x++)
                answer[x][right] = num++;
            right--;

            // 왼쪽

            for (int y = right; y >= left; y--)
                answer[bottom][y] = num++;
            bottom--;


            // 위

            for (int x = bottom; x >= top; x--)
                answer[x][left] = num++;
            left++;

        }

        return answer;
    }
}