package common;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmStudy10 {

    class Solution {
        public static String solution(int[] numbers, String hand) {
            String answer = "";
            //StringBuffer sb = new StringBuffer();
            StringBuilder sb2 = new StringBuilder();
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

                if( keypad.get(0).contains(n) ){ //n이 1 4 7에 있으면
                    sb2.append("L");
                    //sb.append("L");
                    left[0] = 0; //좌우 (키패드 1열인지 2열인지)
                    left[1] = keypad.get(0).indexOf(n); //키패드 높이
                } else if( keypad.get(2).contains(n) ) { //n이 3, 6, 9에 있으면
                    //sb.append("R");
                    sb2.append("R");
                    right[0] = 2; //좌우 (키패트 3열인지 2열인지)
                    right[1] = keypad.get(2).indexOf(n); //키패드 높이
                } else if ( keypad.get(1).contains(n) ){ //n이 2, 5, 8, 0에 있으면

                    int keyIndex = keypad.get(1).indexOf(n); //n의 높이

                    //맨하튼 거리 공식 이용 (1 -> 키패드 2열(index)) (left[0] -> 왼손 좌우 위치)
                    int leftDistance = Math.abs(1 - left[0]) + Math.abs(keyIndex - left[1]); //왼손과 n의 거리 구하기 (x1 - x2) + (y1 - y2)
                    int rightDistance = Math.abs(1 - right[0]) + Math.abs(keyIndex - right[1]); //오른손과 n의 거리 구하기 (x1 - x2) + (y1 - y2)

                    if(leftDistance == rightDistance) {
                        if(hand.equals("left")) {
                            sb2.append("L");
                            //sb.append("L");
                            left[0] = 1;
                            left[1] = keyIndex;
                        } else if(hand.equals("right")) {
                            sb2.append("R");
                            //sb.append("R");
                            right[0] = 1;
                            right[1] = keyIndex;
                        }
                    } else if(leftDistance < rightDistance) {
                        sb2.append("L");
                        //sb.append("L");
                        left[0] = 1;
                        left[1] = keyIndex;
                    } else if(leftDistance > rightDistance) {
                        sb2.append("R");
                        //sb.append("R");
                        right[0] = 1;
                        right[1] = keyIndex;
                    }
                }
            }

            //answer = sb.toString();
            answer = sb2.toString();
            return answer;
        }
    }

}
