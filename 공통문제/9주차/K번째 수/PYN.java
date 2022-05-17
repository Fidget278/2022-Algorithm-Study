import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        int N;
        int K;
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int arr[] = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        System.out.println(arr[K-1]);
    }
}