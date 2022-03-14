package personal;
//https://www.acmicpc.net/problem/10870

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon4 {

    public static int fibonacci(int n) {

        if(n == 0) {
            return 0;
        }else if(n == 1){
            return 1;
        } else {
            return fibonacci(n-2) + fibonacci(n-1);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }
}
