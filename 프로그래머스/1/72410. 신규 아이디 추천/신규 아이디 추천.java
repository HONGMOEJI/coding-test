class Solution {
    public String solution(String new_id) {
        // 1단계: 대문자를 소문자로
        new_id = new_id.toLowerCase();

        // 2단계: 허용된 문자만 남기기
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);

            if (isAllowed(ch)) {
                sb.append(ch);
            }
        }

        // 3단계: 마침표가 2번 이상 연속되면 하나만 남기기
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (ch == '.' && sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
                continue;
            }

            sb2.append(ch);
        }

        // 4단계: 처음이나 끝의 마침표 제거
        while (sb2.length() > 0 && sb2.charAt(0) == '.') {
            sb2.deleteCharAt(0);
        }

        while (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
            sb2.deleteCharAt(sb2.length() - 1);
        }

        // 5단계: 빈 문자열이면 a
        if (sb2.length() == 0) {
            sb2.append('a');
        }

        // 6단계: 길이가 16 이상이면 15개만 남기기
        if (sb2.length() >= 16) {
            sb2.delete(15, sb2.length());
        }

        // 6단계 후 끝 마침표 제거
        while (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
            sb2.deleteCharAt(sb2.length() - 1);
        }

        // 7단계: 길이가 2 이하이면 마지막 문자 반복
        while (sb2.length() < 3) {
            sb2.append(sb2.charAt(sb2.length() - 1));
        }

        return sb2.toString();
    }

    private boolean isAllowed(char ch) {
        boolean isLower = ch >= 'a' && ch <= 'z';
        boolean isDigit = ch >= '0' && ch <= '9';
        boolean isSpecial = ch == '-' || ch == '_' || ch == '.';

        return isLower || isDigit || isSpecial;
    }
}
