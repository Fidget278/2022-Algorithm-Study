// python으로 할 경우 : 3400ms, java로 할 경우 : 560ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] heights = new int[n];
    int answer = 0;
    st = new StringTokenizer(br.readLine(), " ");
    int start, mid, end;
    start=0; end=0;
    for(int i = 0; i < n; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
      if(heights[i] > end) {
        end = heights[i];
      }
    }
    
    while(start <= end) {
      mid = (start+end) / 2;
      long temp = 0;
      for(int i : heights) {
        temp += i >= mid ? i-mid : 0;
      }
      if (temp < m) {
        end = mid - 1;
      }
      else {
        answer = mid;
        start = mid + 1;
      }
    }
    System.out.print(answer);
  }
}
