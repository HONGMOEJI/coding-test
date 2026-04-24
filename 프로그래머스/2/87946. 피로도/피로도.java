class Solution {
    int answer = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return answer;
    }

    private void dfs(int fatigue, int count, int[][] dungeons) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0];
            int use = dungeons[i][1];

            if (!visited[i] && fatigue >= need) {
                visited[i] = true;
                dfs(fatigue - use, count + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}
