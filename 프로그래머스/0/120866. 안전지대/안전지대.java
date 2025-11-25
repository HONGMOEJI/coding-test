class Solution {
    public int solution(int[][] board) {
        int n = board.length;

        // 8방향 (정답 공식)
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        // 위험지역 표시
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){

                    for(int d=0; d<8; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx>=0 && ny>=0 && nx<n && ny<n && board[nx][ny] != 1){
                            board[nx][ny] = 2;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 0) answer++;
            }
        }
        return answer;
    }
}