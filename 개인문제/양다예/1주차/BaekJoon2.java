https://www.acmicpc.net/problem/2577

package personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BaekJoon2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String x = String.valueOf(a * b * c);
        String[] str = x.split("");

        ArrayList<Integer> list = new ArrayList<>();

        for (String test : str) {
            list.add(Integer.valueOf(test));
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(Collections.frequency(list, i));
            //Collections.frequency( , ) : Collection 안에 객체가 몇 번 중복되는지 리턴
        }

//        ArrayList<Integer> list = new ArrayList<>();
//        int x = a * b * c;
//        while(x > 0) {
//            list.add(x % 10);
//            x /= 10; //x 를 10으로 나누고 다시 x에 대입
//        }
//
//        for(int i = 0; i < 10; i++) {
//            System.out.println(Collections.frequency(list, i));
//        }
    }
}
