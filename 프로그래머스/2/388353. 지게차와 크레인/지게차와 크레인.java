import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        char[][] board = new char[n + 2][m + 2];

        // 바깥을 빈 공간으로 패딩
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(board[i], '.');
        }

        // 실제 창고 복사
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                board[r + 1][c + 1] = storage[r].charAt(c);
            }
        }

        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 2) {
                removeAll(board, target);
            } else {
                removeAccessible(board, target);
            }
        }

        return countRemain(board);
    }

    private void removeAll(char[][] board, char target) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == target) {
                    board[r][c] = '.';
                }
            }
        }
    }

    private void removeAccessible(char[][] board, char target) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> removeList = new ArrayList<>();

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;

                if (board[nr][nc] == '.') {
                    q.add(new int[]{nr, nc});
                } else if (board[nr][nc] == target) {
                    removeList.add(new int[]{nr, nc});
                }
            }
        }

        // BFS가 끝난 뒤에 한 번에 제거해야 함
        for (int[] pos : removeList) {
            board[pos[0]][pos[1]] = '.';
        }
    }

    private int countRemain(char[][] board) {
        int count = 0;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != '.') {
                    count++;
                }
            }
        }

        return count;
    }
}
