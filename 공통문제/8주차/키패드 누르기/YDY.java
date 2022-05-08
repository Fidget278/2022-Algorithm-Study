package common;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmStudy10 {

    class Solution {
        public static String solution(int[] numbers, String hand) {
            String answer = "";
            StringBuffer sb = new StringBuffer();
            int[] left = {0, 3}; //왼손 첫 번째 위치 지정
            int[] right = {2, 3}; //오른손 첫 번째 위치 지정
            List<List<Integer>> keypad = new ArrayList<>(); // keypad 생성
            for(int i = 0; i < 3; i ++ ){
                List<Integer> list = new ArrayList<>();
                list.add(i + 1);
                list.add(i + 4);
                list.add(i + 7);
                if(i + 7 == 8) {
                    list.add(0);
                }
                keypad.add(list);
            }

            for(int i = 0; i < numbers.length; i++) {
                int n = numbers[i];

                if( keypad.get(0).contains(n) ){
                    sb.append("L");
                    left[0] = 0;
                    left[1] = keypad.get(0).indexOf(n);
                } else if( keypad.get(2).contains(n) ) {
                    sb.append("R");
                    right[0] = 2;
                    right[1] = keypad.get(2).indexOf(n);
                } else if ( keypad.get(1).contains(n) ){
                    int keyIndex = keypad.get(1).indexOf(n);
                    //맨하튼 거리 공식 이용
                    int leftDistance = Math.abs(1 - left[0]) + Math.abs(keyIndex - left[1]);
                    int rightDistance = Math.abs(1 - right[0]) + Math.abs(keyIndex - right[1]);

                    if(leftDistance == rightDistance) {
                        if(hand.equals("left")) {
                            sb.append("L");
                            left[0] = 1;
                            left[1] = keyIndex;
                        } else if(hand.equals("right")) {
                            sb.append("R");
                            right[0] = 1;
                            right[1] = keyIndex;
                        }
                    } else if(leftDistance < rightDistance) {
                        sb.append("L");
                        left[0] = 1;
                        left[1] = keyIndex;
                    } else if(leftDistance > rightDistance) {
                        sb.append("R");
                        right[0] = 1;
                        right[1] = keyIndex;
                    }
                }
            }

            answer = sb.toString();
            return answer;
        }
    }

}
