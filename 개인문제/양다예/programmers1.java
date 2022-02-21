//https://programmers.co.kr/learn/courses/30/lessons/42578
package personal;

import java.util.*;

public class programmers1 {
    public int solution(String[][] clothes) {

        //경우의 수 공식 : (A + 1) * (B + 1) - 1 (-1 : 아무것도 안 입는 경우는 없으므로)
        //K : 옷 종류, V : 옷 종류별 옷의 개수

        int answer = 0;

        //이중배열 -> map에 담기
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            //옷 종류를 key로하고, getOrDefault사용하여 해당 종류가 없으면 기본값으로 0 + 1을하여 value가 1이 되도록 하고, 있으면 value를 1씩 추가
            map.put(clothes[i][1], (map.getOrDefault((clothes[i][1]), 0) + 1));
        }

//        //List 사용
        //map에 담긴 value를 list에 담기
        List<Integer> list = new ArrayList<>();
        for(String temp : map.keySet()) {
            list.add(map.get(temp));
        }

        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            count = count * (list.get(i) + 1);
        }
        answer = count - 1;
        return answer;

//        //Iterator 사용
//        Iterator<Integer> iterator = map.values().iterator();
//        int count = 1;
//        while (iterator.hasNext()) {
//            count = count * (iterator.next() + 1);
//        }
//
//        answer = count - 1;
//        return answer;

    }

    public static void main(String[] args) {
        String[][] clothes ={{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        //{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        programmers1 pg = new programmers1();
        pg.solution(clothes);
    }
}
