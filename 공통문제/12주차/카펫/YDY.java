package common;
//https://programmers.co.kr/learn/courses/30/lessons/42842
public class AlgorithmStudy19PG42842 {

    static class Solution {
        public static int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            int bwh = (brown / 2) + 2;
            int bh = 3; //높이는 최소 3부터 시작(yellow 를 감싸고 있는 테두리라서)
            int bw = bwh - bh;

            while (bw >= bh) {
                bh = bwh - bw;
                if ((bw - 2) * (bh - 2) == yellow) {
                    answer[0] = bw;
                    answer[1] = bh;
                    break;
                }
                bw--;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution.solution(10, 2);
    }

}
