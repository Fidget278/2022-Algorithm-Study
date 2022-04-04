package personal;
//https://programmers.co.kr/learn/courses/30/lessons/42888
import java.util.*;

public class Programmers4 {
    public static String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        //record 띄어쓰기로 상태, 아이디, 닉네임 구분
        for(int i = 0; i < record.length; i++) {
            String str = record[i];
            String[] recordStr = str.split(" ");

            //Leave인 경우에는 닉네임이 없으므로
            if(!recordStr[0].equals("Leave")) {
                map.put(recordStr[1], recordStr[2]);
            }

            //Change인 경우에는 메시지에 기록을 남기지 않아도 되므로
            if(!recordStr[0].equals("Change")) {
                list.add(record[i]);
            }
        }

        answer = new String[list.size()];

        for(int i = 0; i< list.size(); i++) {
            String str = list.get(i);
            String[] recordStr = str.split(" ");
            String nickname = map.get(recordStr[1]);

            if(str.contains("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";
            } else if(str.contains("Leave")) {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        //들어온 기록이 없는 사람이 나가는 경우도 고려해야 테스트케이스 통과할 수 있음
        String[] recode = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan", "Leave uid7890", "Enter uid7890 Jelly"};
        solution(recode);
    }

}
