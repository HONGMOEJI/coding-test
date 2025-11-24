import java.util.Arrays;

public class Solution {
    public int[] solution(int[] num_list) {
        int last = num_list[num_list.length - 1] > num_list[num_list.length - 2] ? num_list[num_list.length - 1] - num_list[num_list.length - 2] : num_list[num_list.length - 1] * 2;

        int[] answer = Arrays.copyOf(num_list, num_list.length + 1);

        answer[num_list.length] = last;
        
        return answer;
    }
}