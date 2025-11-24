class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int curHealth = health;
        int healDur = 0;
        int curTime = 0;

        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int attackDamage = attacks[i][1];
            
            int healTime = attackTime - curTime - 1;
            
            for(int j = 0; j < healTime; j++) {
                if(curHealth < health) {
                    curHealth += bandage[1];
                    healDur += 1;
                    
                    if(healDur == bandage[0]){
                        curHealth += bandage[2];
                        healDur = 0;
                    }
                    
                    if(curHealth > health) {
                        curHealth = health;
                    }
                }

            }
            curHealth -= attacks[i][1];
            healDur = 0;
            curTime = attackTime;

            if(curHealth <= 0) return -1;
        }
        return curHealth;
    }
}
