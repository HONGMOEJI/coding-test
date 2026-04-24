import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;

        Stack<Integer> s = new Stack<>();

        for(int element: arr){
            if(s.isEmpty() || s.peek()!=element) s.push(element);
        }

        answer = new int[s.size()];
        for(int i=s.size()-1; i>=0; i--){
            answer[i] = s.pop();
        }



        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}