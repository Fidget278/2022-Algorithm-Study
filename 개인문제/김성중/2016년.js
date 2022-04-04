// https://programmers.co.kr/learn/courses/30/lessons/12901
// 프로그래머스 - 연습 - 2016년
// 작성자 : 김성중
// 시간 : O(1)

function solution(a, b) {
  let dayArr = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
  let date = new Date(`2016-${a}-${b}`);
  let day = date.getDay();
  return dayArr[day];
}
