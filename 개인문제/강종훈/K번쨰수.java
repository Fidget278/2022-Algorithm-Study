import java.util.Arrays;

class Solution {
        public int[] solution(int[] array, int[][] commands){
        //결과는 commands의 length만큼 생성되기 때문
        int[] answer = new int[commands.length];

        for (int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            // 삽입정렬
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }
}