package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlgorithmStudy9 {

    class Solution1 {
        public static int solution(int[][] board, int[] moves) {
            int answer = 0;
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < moves.length; i++) {
                int m = moves[i] - 1;
                for(int j = 0; j < board.length; j++) {
                    int b = board[j][m];
                    if (b != 0) {
                        list.add(b);
                        board[j][m] = 0;
                        if (list.size() > 1 && list.get(list.size() - 1) == list.get(list.size() - 2)) {
                            list.remove(list.size()-1);
                            list.remove(list.size()-1);
                            answer += 2;
                        }
                        break;
                    }
                }
            }

            return answer;
        }
    }

    class Solution2 {
        public static int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < moves.length; i++) {
                int m = moves[i] - 1;

                for(int j = 0; j < board.length; j++) {
                    int b = board[j][m];
                    if (b != 0) {
                        board[j][m] = 0;

                        if(stack.isEmpty() || b != stack.peek()) {
                            stack.push(b);
                            break;
                        } else if(b == stack.peek()) {
                            answer += 2;
                            stack.pop();
                            break;
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] b = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] m = {1,5,3,5,1,2,1,4};
        Solution1.solution(b, m);
        Solution2.solution(b, m);
    }
}
