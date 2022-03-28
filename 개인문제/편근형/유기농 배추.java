// 링크 : https://www.acmicpc.net/problem/1012
// 시간 :184ms
// 코드 길이 : 1959B
// 메모리 : 15784KB

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int t = Integer.parseInt(st.nextToken());

    for (int a = 0; a < t; a++) {
      st = new StringTokenizer(br.readLine(), " ");
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
      Stack<int[]> stack = new Stack<>();
      int[][] field = new int[n][m]; // 선언과 배열을 0으로 초기화 동시에 진행
      int cnt = 0;
  
      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        field[y][x] = 1;
      }
  
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if(field[i][j] == 1) {
            cnt += 1;
            field[i][j] = 0;
            int[] point = {i,j};
            stack.add(point);
          }
          while (stack.empty() == false) {
            int[] temp = stack.pop();
            int x = temp[1]; int y = temp[0];
  
            for(int[] dir : direction) {
              int dx = dir[1]; int dy = dir[0];
              int nx = dx + x;
              int ny = dy + y;
              if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (field[ny][nx] == 1) {
                  field[ny][nx] = 0;
                  int[] newPoint = {ny, nx};
                  stack.push(newPoint);
                }
              }
            }
          }
        }
      }
      System.out.println(cnt);
    }   
  }
}
