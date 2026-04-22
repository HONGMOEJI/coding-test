class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        int currentAvailableServer=0;
        int[] expireServers = new int[players.length + k + 1];

        for(int i=0; i<players.length; i++){
            currentAvailableServer-=expireServers[i];

            int neededServer = players[i] / m;

            if(currentAvailableServer<neededServer){
                int addedServer = neededServer - currentAvailableServer;
                answer += addedServer;
                currentAvailableServer += addedServer;
                expireServers[i+k] += addedServer;
            }
        }
        return answer;
    }
}