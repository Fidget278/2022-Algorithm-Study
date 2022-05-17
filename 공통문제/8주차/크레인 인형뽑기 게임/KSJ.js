// https://programmers.co.kr/learn/courses/30/lessons/64061
// 프로그래머스 - 2019 카카오 개발자 겨울 인턴십 - 크레인 인형뽑기 게임
// 작성자 : 김성중

function solution(board, moves) {
  //인형을 담을 바구니
  let bascket = [];
  let answer = 0;
  for (let i = 0; i < moves.length; i++) {
    //moves에 담긴 값은 1부터 시작이고 index는 0부터 시작하므로 -1을 해줌
    const move = moves[i] - 1;
    for (let j = 0; j < board.length; j++) {
      //열(move)값은 고정이므로 행(j)값을 반복으로 돌면서 인형이 있으면 관련 코드 실행
      const doll = board[j][move];
      if (doll) {
        //인형이 있는 자리에 0을 대입하여 인형을 꺼내준다.
        board[j][move] = 0;
        //만약 basket이 비어있지 않고 &&
        //바스켓에 마지막으로 담긴 인형과 현재 꺼낸 인형이 일치할 경우
        if (bascket.length !== 0 && bascket[bascket.length - 1] === doll) {
          //바스켓에서 마지막 인형을 꺼내주고
          bascket.pop();
          //answer값은 2를 올려준다.
          answer += 2;
        } else {
          //그렇지 않은 경우에는 꺼낸 인형을 bascket에 넣어줌
          bascket.push(doll);
        }
        break;
      }
    }
  }
  return answer;
}

console.log(
  solution(
    [
      [0, 0, 0, 0, 0],
      [0, 0, 1, 0, 3],
      [0, 2, 5, 0, 1],
      [4, 2, 4, 4, 2],
      [3, 5, 1, 3, 1],
    ],
    [1, 5, 3, 5, 1, 2, 1, 4]
  )
);
