// 링크 : https://www.acmicpc.net/problem/4949
// 시간 : 516ms
// 코드 길이 : 1309B
// 메모리 : 43880KB

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {   
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String s;
    Stack<String> stack = new Stack<>();
    while (true) {
      String answer = "yes";
      s = br.readLine();
      if (s.equals(".")) {
        break;
      }
      s.strip();
      String[] st = s.split("");
      stack.clear();
      int length = s.length();
      
      for(int i = 0; i < length ; i++) {
        String c = st[i];
        if(c.equals("[") || c.equals("(")) {
          stack.push(c);
        }
        else if (c.equals("]")) {
          if(stack.size() != 0 && stack.peek().equals("[")) {
            stack.pop();
          }
          else {
            stack.push(c);
            break;
          }
        }
        else if (c.equals(")")) {
          if(stack.size() != 0 && stack.peek().equals("(")) {
            stack.pop();
          }
          else {
            stack.push(c);
            break;
          }
        }
      }
      if(stack.size() != 0) {
        answer = "no";
      }
      System.out.println(answer);
    }
  }
}
