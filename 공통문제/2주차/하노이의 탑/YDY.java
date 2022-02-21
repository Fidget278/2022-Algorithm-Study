//https://programmers.co.kr/learn/courses/30/lessons/12946

package common;

import java.util.ArrayList;

public class AlgorithmStudy2 {

    ArrayList<Integer> list = new ArrayList<>();

    public void hanoi(int n, int start, int mid, int end) {


        if (n == 1) {
            list.add(start);
            list.add(end);
        } else {
            hanoi(n-1, start, end, mid); //start -> mid
            list.add(start);
            list.add(end);
            hanoi(n-1, mid, start, end); //mid -> end
        }
    }

    public int[][] solution(int n) {
        int[][] answer = {};

        answer = new int[((int) Math.pow(2, n)) - 1][2];
        hanoi(n, 1, 2, 3);
        int index = 0;
        for (int i = 0; i < list.size(); i+=2) {
            answer[index][0] = list.get(i);
            answer[index][1] = list.get(i+1);
            //System.out.println("[" + answer[index][0] + "," + answer[index][1] + "] ");
            ++index;
        }
        return answer;
    }

    public static void main(String[] args) {
        AlgorithmStudy2 al2 = new AlgorithmStudy2();
        al2.solution(3);
    }
}
