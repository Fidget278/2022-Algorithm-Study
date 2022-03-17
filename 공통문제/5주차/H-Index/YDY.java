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


    public static void main(String[] args) {
//        int[] citations = {3, 0, 6, 1, 5}; //-> 3
//        int[] citations = {12, 11, 10, 9, 8, 1}; //-> 5
//        int[] citations = {6, 6, 6, 6, 6, 1}; //-> 5
//        int[] citations = {4, 4, 4}; //-> 3
//        int[] citations = {0, 0, 0, 0, 0}; //-> 0

        int[] citations = {1, 4}; //-> 1
//        int[] citations = {0, 1, 2}; //-> 1
//        int[] citations = {2, 2, 2, 2, 2}; //=> 2
//        int[] citations = {0, 1, 1}; // => 1
        solution(citations);

    }
}
