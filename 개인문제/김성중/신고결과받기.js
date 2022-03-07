// https://programmers.co.kr/learn/courses/30/lessons/92334
// 프로그래머스 - 연습 - 2022카카오블라인드 - 신고결과받기
// 작성자 : 김성중
// 시간 : O(n)


function solution(id_list, report, k)
{
    // 신고 당한 횟수 및 신고한 ID 목록 세팅
    const userInfo = id_list.reduce((result, current) => {
        result[current] = [0, []];
        return result;
    }, {});
    
    // Set으로 중복값 삭제 후 배열값들 " "기준으로 구분해서 user, target에 넣기
    // 신고한 사람의 target 부분에 신고당한 사람을 push하고
    // 신고당한 사람은 카운트를 올려준다.
    for (const value of new Set(report)) {
        const [user, target] = value.split(' ');

        userInfo[user][1].push(target);
        userInfo[target][0]++;
    }

    // k값 기준으로 >= 이면 stops에 저장
    const stops = id_list.filter((id) => userInfo[id][0] >= k);

    // userInfo에 저장된값을 stops에 저장한 값이 포함되어있는지 체크하고 길이를 맵으로 만들어 리턴
    return id_list.map((id) => userInfo[id][1].filter((id) => stops.includes(id)).length);
}

