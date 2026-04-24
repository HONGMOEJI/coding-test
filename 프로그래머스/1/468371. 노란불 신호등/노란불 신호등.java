class Solution {
    public int solution(int[][] signals) {
        long totalCycle = 1;

        // 전체 신호 조합은 주기의 최소공배수 시점마다 같아짐
        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            totalCycle = lcm(totalCycle, cycle);
        }

        for (int t = 1; t <= totalCycle; t++) {
            int yellowCount = 0;

            for (int[] signal : signals) {
                if (isYellow(signal, t)) {
                    yellowCount++;
                }
            }

            if (yellowCount == signals.length) {
                return t;
            }
        }

        return -1;
    }

    public boolean isYellow(int[] signal, int t) {
        int green = signal[0];
        int yellow = signal[1];
        int red = signal[2];

        int cycle = green + yellow + red;
        int pos = (t - 1) % cycle;

        return green <= pos && pos < green + yellow;
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}