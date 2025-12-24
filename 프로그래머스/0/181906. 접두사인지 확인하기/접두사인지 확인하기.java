class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 1;

        for(int i=0; i<is_prefix.length(); i++){
            if (is_prefix.length() > my_string.length()) {
                answer = 0;
                break;
            }
            if(my_string.charAt(i) != is_prefix.charAt(i)) {
                answer = 0;
            }
        }
        return answer;
    }
}
