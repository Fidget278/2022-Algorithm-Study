package common;
//https://programmers.co.kr/learn/courses/30/lessons/42747
import java.util.Arrays;

public class AlgorithmStudy5 {
    public static int solution(int[] citations) {
        int answer = 0;
        int h = citations.length;

        Arrays.sort(citations);

        while (true) {
            int count = 0;
            for (int i = 0; i < citations.length; i++) {
                if (h <= citations[i]) {
                    count++;
                }
            }

            if (count >= h) {
                answer = h;
                break;
            }

            h--;
        }

        return answer;
    }
}
