package personal;
//https://www.acmicpc.net/problem/10872
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BaekJoon3 {
    public static int pac(int n) {

        if(n == 0) {
            return 1;
        } else {
            return n * pac(n-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(pac(n));
    }
}
