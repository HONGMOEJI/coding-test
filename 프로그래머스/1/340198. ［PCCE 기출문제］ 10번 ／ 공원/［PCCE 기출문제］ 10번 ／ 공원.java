import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = findMaximumEmptySpace(mats, park);
        return answer;
    }

    private static int findMaximumEmptySpace(int[] mats, String[][] park) {
        // mats 내림차순 정렬 (큰 매트부터 확인)
        Integer[] matsDesc = Arrays.stream(mats)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
        
        int rows = park.length;
        int cols = park[0].length;
        
        // 큰 매트부터 확인
        for (int size : matsDesc) {
            // 모든 가능한 시작 위치 확인
            for (int i = 0; i <= rows - size; i++) {
                for (int j = 0; j <= cols - size; j++) {
                    if (isEmpty(park, i, j, size)) {
                        return size; // 놓을 수 있는 가장 큰 매트 크기 반환
                    }
                }
            }
        }
        
        return -1; // 놓을 수 있는 매트가 없음
    }

    private static boolean isEmpty(String[][] park, int start_row, int start_col, int size) {
        for (int i = start_row; i < start_row + size; i++) {
            for (int j = start_col; j < start_col + size; j++) {
                if (!park[i][j].equals("-1")) { // "-1"이 아니면 차있음
                    return false;
                }
            }
        }
        return true;
    }
}