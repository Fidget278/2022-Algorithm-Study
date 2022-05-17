package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AlgorithmStudy9 {

    class Solution1 {
        public static int solution(int[][] board, int[] moves) {
            int answer = 0;
            List<Integer> list = new ArrayList<>();

            System.out.println(Arrays.toString(moves));

            for(int i = 0; i < moves.length; i++) {
                int m = moves[i] - 1; //들어갈 열 값을 index로 설정해줘야 하므로 -1

                for(int j = 0; j < board.length; j++) {
                    int b = board[j][m];

                    if (b != 0) {
                        list.add(b);
                        board[j][m] = 0; //인형 뽑았으니까 0으로 바꿔

                        if (list.size() > 1 && list.get(list.size() - 1) == list.get(list.size() - 2)) { //바구니에 2개 이상 인형이 있고, 마지막 인형과 그 앞의 인형이 동일하면
                            list.remove(list.size()-1); //list에서 마지막 인형 빼기
                            list.remove(list.size()-1); //list에서 마지막 인형 빼기
                            answer += 2; //2개 뺐으니까 +=2
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
                        } else if(b == stack.peek()) { //넣거나 빼지 않고 b와 마지막 값 바로 비교
                            answer += 2;
                            stack.pop(); //마지막 값 빼내기
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
        //Solution2.solution(b, m);
    }
}
