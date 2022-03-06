//소수찾기.
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return

import java.util.HashSet;
import java.util.Iterator;

public class FindDecimals {

    HashSet<Integer> numberSet = new HashSet<>();

    //소수 체크 함수
    public boolean isPrime(int num){
        //1. 0과 1은 소수가 아니다.
        if(num == 0 || num == 1)
            return false;

        //2. 에라토스테네스의 체의 limit 숫자를 계산한다.
        //Math.sqrt는 제곱근을 구하는 함수.
        int lim = (int) Math.sqrt(num);

        //3. 에라토스테네스의 체에 따라 lim까지 배수 여부를 확인한다.
        for (int i = 2; i<=lim; i++){
            if(num % i == 0 )
                return false;
        }
        return true;
    }

    //숫자 조합 만들어서 입력하는 함수.
    public void recursive(String comb, String others){
        //1. 현재 조합을 set에 추가한다.
        if(!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));

        //2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for(int i = 0; i<others.length(); i++)
            //subSring(int beginIndex, int endIndex): beginIndex에서부터 endIndex - 1 자리까지 출력, subString(int index): index + 1의 값부터 끝까지 출력
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
    }


    //1. recursive함수에서 재귀함수를 통해 숫자들을 모두 조합해서 Set에 담는다.
    //2. Set에 담겨진 객체들을 하나씩 꺼내서 소수인지 판별한다.(에라토스테네스의 체를 사용)
    //3. 만약 소수라면 count 상승
    //4. 소수의 총 개수 리턴
    //*. 에라토스테네스의 체를 사용한 이유: 정해진 범위안에서의 소수 판별에는 에라토스테네스의 체가 가장 효율적이라서
    public int solution(String numbers){
        //1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);

        //2. 소수의 개수만 센다.
        int count = 0;
        //numberSet.iterator() : numberSet의 모든 객체를 순회한다.
        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) //숫자가 소수라면 count++
                count++;
        }

        //3. 소수의 개수를 반환한다.
        return count;
    }
}


