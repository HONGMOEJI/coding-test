import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();

        // 원하는 상품과 그 갯수 K,V
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }

        Map<String, Integer> copy;
        boolean flag;
        int cnt=0;

        // 10개로 나눈 배열
        for(int j=0; j<=discount.length-10; j++){
            flag=true;
            copy = new HashMap<>(map);
            for(int k=j; k<j+10; k++){
                if(copy.containsKey(discount[k])){
                    copy.replace(discount[k], copy.get(discount[k])-1);
                }
            }
            for(String s: copy.keySet()){
                if(copy.get(s)>0){
                    flag=false;
                }
            }
            if(flag) cnt++;
        }
        return cnt;
    }
}