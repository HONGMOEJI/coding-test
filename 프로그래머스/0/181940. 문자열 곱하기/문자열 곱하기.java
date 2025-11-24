public class Solution {
    public String solution(String my_string, int k) {
        StringBuilder builder = new StringBuilder();
        
        for(int i=0; i<k; i++) {
            builder.append(my_string);
        }
        return builder.toString();
    }
}
