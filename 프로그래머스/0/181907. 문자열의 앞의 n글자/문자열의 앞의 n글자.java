import java.util.stream.Collectors;
class Solution {
    public String solution(String my_string, int n) {
        return my_string.chars().limit(n).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
    }
}