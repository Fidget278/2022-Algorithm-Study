package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlgorithmStudy11_1 {

    //list에 저장할 타입 생성
    public static class Number{
        int num;
        int index;

        public Number(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public static void bubbleSort(int[] arr, int n) {
        List<Number> list = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            list.add(new Number(arr[i], i));
        }

        //객체를 비교할 수 있도록 Comparator 인터페이스 사용 -> 매개변수 o1 과 매개변수 o2를 비교
        Comparator<Number> comparator1 = new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o1.num - o2.num;
            }
        };

        Collections.sort(list, comparator1);

        int max = 0;
        for(int i = 0; i < n ; i ++) {
            max = Math.max(max, list.get(i).index - i);
        }

        System.out.println(max+1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort(arr, n);
    }
}
