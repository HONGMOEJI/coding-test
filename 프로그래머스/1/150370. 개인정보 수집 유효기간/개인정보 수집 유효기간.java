import java.lang.Integer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();

        String[] ymd = today.split("\\.");
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);

        Map<String, Integer> map = new HashMap<>();

        for(String term : terms) {
            String[] keyValue = term.split(" ");
            map.put(keyValue[0], Integer.parseInt(keyValue[1]));
        }

        int index = 1;
        for(String privacy : privacies) {
            String type = privacy.split(" ")[1];
            String aymd = privacy.split(" ")[0];

            int expiredMonth = map.get(type);

            int[] expiredYMD = new int[3];
            expiredYMD = getExpiredYMD(aymd, expiredMonth);

            if(expiredYMD[0] < year) {
                answerList.add(index);
            } else if (expiredYMD[0] == year) {
                if(expiredYMD[1] < month) {
                    answerList.add(index);
                } else if (expiredYMD[1] == month) {
                    if(expiredYMD[2] < day) {
                        answerList.add(index);
                    }
                }
            }
            index++;
        }

        answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public int[] getExpiredYMD(String aymd, int month) {
        String[] ymd = aymd.split("\\.");
        int ayear = Integer.parseInt(ymd[0]);
        int amonth = Integer.parseInt(ymd[1]);
        int aday = Integer.parseInt(ymd[2]);

        int totalMonth = ayear * 12 + (amonth - 1) + month;

        int eyear = totalMonth / 12;
        int emonth = totalMonth % 12 + 1;
        int eday = aday - 1;

        if (eday == 0) {
            eday = 28;
            emonth--;

            if (emonth == 0) {
                emonth = 12;
                eyear--;
            }
        }

        return new int[]{eyear, emonth, eday};
    }

}