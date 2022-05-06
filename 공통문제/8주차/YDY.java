package common;

public class AlgorithmStudy8 {

    class Solution {
        public static int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            int a = 0;

            for(int i = 0; i < absolutes.length; i++) {
                if(signs[i]) {
                    a = absolutes[i] * 1;
                } else {
                    a = absolutes[i] * -1;
                }
                answer += a;
            }

            return answer;
        }
    }
}
