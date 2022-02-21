import java.util.ArrayList;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = {};
        ArrayList<ArrayList<Integer>> answerlist = new ArrayList<ArrayList<Integer>>();
        hanoi_Programmers(answerlist, n, 1, 2, 3);
        
        answer = new int[answerlist.size()][];
        for(int i = 0; i < answerlist.size(); ++i){
            answer[i] = new int[answerlist.get(i).size()];

            for(int j = 0; j < answerlist.get(i).size(); ++j)
                answer[i][j] = answerlist.get(i).get(j);
        }
        
        return answer;
    }
    
    public static void hanoi_Programmers(ArrayList<ArrayList<Integer>> answer, int n, int from, int by, int to) {

        if( n == 0)
            return;

        hanoi_Programmers(answer,n-1, from, to, by);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(from);
        list.add(to);
        answer.add(list);

        hanoi_Programmers(answer,n-1, by, from, to);

    }
}