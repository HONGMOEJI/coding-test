import java.util.*;

class Solution {

    static boolean[][] visited; // 각 칸을 이미 방문했는지 체크하는 배열
    static int n, m; // n = 행 개수, m = 열 개수
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우로 이동할 때 x 변화량
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우로 이동할 때 y 변화량
    static int[][] distance; // 시작점 (0,0)에서 각 칸까지의 거리 저장
    static int[][] map; // 입력으로 받은 맵 저장

    public int solution(int[][] maps) {
        m = maps[0].length; // 맵의 가로 길이(열 개수)
        n = maps.length; // 맵의 세로 길이(행 개수)

        map = maps; // 전달받은 maps를 전역 변수 map에 저장

        visited = new boolean[n][m]; // 방문 여부를 저장할 2차원 배열 생성
        distance = new int[n][m]; // 거리 정보를 저장할 2차원 배열 생성

        distance[0][0] = 1; // 시작점의 거리를 1로 설정

        return bfs(0, 0);
    }

    public int bfs(int x, int y) {

        visited[x][y] = true; // 시작점을 방문 처리

        Queue<int[]> q = new ArrayDeque<>(); // BFS용 큐 생성
        q.add(new int[]{x, y}); // 시작 좌표를 큐에 넣음

        while (!q.isEmpty()) { // 큐가 빌 때까지 반복

            int[] cur = q.poll(); // 큐 맨 앞 좌표를 꺼냄
            int cx = cur[0]; // 현재 x 좌표
            int cy = cur[1]; // 현재 y 좌표

            // 조기 종료
            if (cx == n - 1 && cy == m - 1) return distance[cx][cy];
            
            for (int i = 0; i < 4; i++) { // 상하좌우 4방향 탐색

                int nx = cx + dx[i]; // 다음 x 좌표
                int ny = cy + dy[i]; // 다음 y 좌표
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) { // 맵 범위 안인지 확인

                    if (!visited[nx][ny] && map[nx][ny] == 1) { 
                        // 아직 방문 안 했고, 벽(0)이 아니라 길(1)이면 이동 가능
                        // System.out.println(nx + " " + ny);
                        visited[nx][ny] = true; // 방문 처리
                        q.add(new int[]{nx, ny}); // 다음 좌표를 큐에 넣음
                        distance[nx][ny] = distance[cx][cy] + 1;
                        // 현재 칸까지의 거리 + 1 을 다음 칸 거리로 저장
                    }
                }
            }
        }

        return -1;
    }
}
