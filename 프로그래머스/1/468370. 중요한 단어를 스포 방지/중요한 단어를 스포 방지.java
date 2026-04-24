import java.util.*;

class Solution {
    static class Word {
        String text;
        int start;
        int end;

        Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }

    static class Range {
        int start;
        int end;
        int originalIndex;
        int order;

        Range(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
        }
    }

    public int solution(String message, int[][] spoiler_ranges) {
        List<Word> words = parseWords(message);

        Range[] ranges = new Range[spoiler_ranges.length];
        for (int i = 0; i < spoiler_ranges.length; i++) {
            int l = spoiler_ranges[i][0];
            int r = spoiler_ranges[i][1];

            if (l > r) {
                int tmp = l;
                l = r;
                r = tmp;
            }

            ranges[i] = new Range(l, r, i);
        }

        // 왼쪽 -> 오른쪽 클릭 순서
        Arrays.sort(ranges, (a, b) -> {
            if (a.start != b.start) return Integer.compare(a.start, b.start);
            return Integer.compare(a.originalIndex, b.originalIndex);
        });

        for (int i = 0; i < ranges.length; i++) {
            ranges[i].order = i;
        }

        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            buckets.add(new ArrayList<>());
        }

        Set<String> plainWords = new HashSet<>();

        // 현재 단어와 겹칠 수 있는 spoiler range 중
        // 가장 늦게 클릭되는 range를 빠르게 찾기 위한 max-heap
        PriorityQueue<Range> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.order, a.order));

        int rangeIdx = 0;

        for (Word word : words) {
            // word.end보다 시작점이 왼쪽에 있는 range는 후보로 추가
            while (rangeIdx < ranges.length && ranges[rangeIdx].start <= word.end) {
                pq.offer(ranges[rangeIdx]);
                rangeIdx++;
            }

            // 현재 단어 시작점보다 끝점이 왼쪽인 range는 제거
            while (!pq.isEmpty() && pq.peek().end < word.start) {
                pq.poll();
            }

            // 겹치는 spoiler range가 없으면 일반 단어
            if (pq.isEmpty()) {
                plainWords.add(word.text);
            } else {
                // 가장 늦게 클릭되는 range에서 이 단어가 완전히 공개됨
                buckets.get(pq.peek().order).add(word.text);
            }
        }

        int answer = 0;
        Set<String> seenSpoilerWords = new HashSet<>();

        // 클릭 순서대로, 같은 클릭 안에서는 왼쪽 -> 오른쪽 순서로 판정
        for (List<String> bucket : buckets) {
            for (String word : bucket) {
                if (!plainWords.contains(word) && seenSpoilerWords.add(word)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private List<Word> parseWords(String message) {
        List<Word> words = new ArrayList<>();
        int n = message.length();
        int i = 0;

        while (i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }

            int start = i;
            while (i < n && message.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1;

            words.add(new Word(message.substring(start, i), start, end));
        }

        return words;
    }
}
