import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        boolean[] v = new boolean[words.length];
        q.add(begin);

        int cnt = 0;

        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                String cur = q.poll();

                if (cur.equals(target)) return cnt;

                for (int i = 0; i < words.length; i++) {
                    if (!v[i] && diff(cur, words[i]) == 1) {
                        v[i] = true;
                        q.add(words[i]);
                    }
                }
            }
            cnt++;
        }

        return 0;
    }

    int diff(String a, String b) {
        int d = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i)) d++;
        return d;
    }
}