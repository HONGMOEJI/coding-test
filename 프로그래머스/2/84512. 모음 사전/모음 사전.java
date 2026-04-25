class Solution {
    String[] vowels = {"A", "E", "I", "O", "U"};
    int count = 0;
    int answer = 0;
    String target;

    public int solution(String word) {
        target = word;
        dfs("");
        return answer;
    }

    private void dfs(String current) {
        if (current.equals(target)) {
            answer = count;
            return;
        }

        if (current.length() == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            count++;
            dfs(current + vowels[i]);

            if (answer != 0) {
                return;
            }
        }
    }
}
