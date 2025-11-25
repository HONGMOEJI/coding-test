class Solution {
    public int solution(String A, String B) {
        int n = A.length();

        if (A.equals(B)) return 0;

        String rotated = A;

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append(rotated.charAt((j - 1 + n) % n)); 
            }

            rotated = sb.toString();

            if (rotated.equals(B)) {
                return i;
            }
        }

        return -1;
    }
}