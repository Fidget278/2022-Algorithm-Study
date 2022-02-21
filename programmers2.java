//https://programmers.co.kr/learn/courses/30/lessons/42579
package personal;

import java.util.*;

public class programmers2 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();

        //장르별 재생 수의 총 합 구하기
        for(int i = 0; i < genres.length; i++) {
            if(map.containsKey(genres[i])) {
                map.put(genres[i], (plays[i] + map.get(genres[i])));
            } else {
                map.put(genres[i], plays[i]);
            }
        }

        //장르별 재생수의 총 합 내림차순 정렬
        List<Map.Entry<String, Integer>> genresSort = new ArrayList<>(map.entrySet());
        genresSort.sort(new Comparator<Map.Entry<String, Integer>> () {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println("entryList : " + genresSort);


        //plays -> Map으로 변환 (노래 고유번호와 재생 수를 함께 관리하기 위함)
        Map<Integer, Integer> playsMap = new HashMap<>();
        for(int i = 0; i < plays.length; i++) {
            playsMap.put(i, plays[i]);
        }

        //playsMap을 value로 내림차순 정렬 한 후에 ArrayList에 값 넣기
        List<Map.Entry<Integer, Integer>> playsSortEntryList = new ArrayList<>(playsMap.entrySet());
        playsSortEntryList.sort(new Comparator<Map.Entry<Integer, Integer>> () {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println("playsSortEntryList : " + playsSortEntryList);


        //genres -> Map으로 변환 (노래 고유번호와 장르를 함께 관리하기 위함)
        Map<Integer, String> genresMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            genresMap.put(i, genres[i]);
        }

        //genres를 palysMap에 key값에 맞춰 재정렬
        //genresMap의 key값과 playsSortEntryList.get(i).getKey()값이 같으면 geresSortEntryList.add()
        List<Map.Entry<Integer, String>> genresEntryList = new LinkedList<>(genresMap.entrySet());
        List<Map.Entry<Integer, String>> genresSortEntryList = new LinkedList<>();

        for(int i = 0; i < playsSortEntryList.size(); i++) {
            for(int j = 0; j < genresEntryList.size(); j ++) {
                if(playsSortEntryList.get(i).getKey() == genresEntryList.get(j).getKey()) {
                    genresSortEntryList.add(genresEntryList.get(j));
                }
            }
        }
        System.out.println("genresSortEntryList : " + genresSortEntryList);


        //genresSortMap에서 entryList의 순서에 따라 2개씩 List에 넣기
        List<Integer> list = new ArrayList<>();
        int count = 2;
        for(int i = 0; i < genresSort.size(); i++) {
            for(int j = 0; j < genresSortEntryList.size(); j++) {
                if (list.size() == count) {
                    break;
                } else if(genresSort.get(i).getKey().equals(genresSortEntryList.get(j).getValue())) {
                    list.add(genresSortEntryList.get(j).getKey());
                }
            }

            //해당 장르에 음악이 한 개만 있는 경우
            if (Collections.frequency(List.of(genres), genresSort.get(i).getKey()) == 1) {
                count += 1;
            } else {
                count += 2;
            }
        }
        answer = list.stream().mapToInt(i->i).toArray();
        System.out.println("answer : " + Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop", "test", "test", "house"};
//        int[] plays = {500, 600, 150, 800, 2500, 300, 300, 8000};
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        programmers2 pg = new programmers2();
        pg.solution(genres, plays);
    }
}
