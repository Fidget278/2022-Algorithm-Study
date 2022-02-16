function solution(participant, completion) {
    let hash = []; //배열 변수 생성
    participant.forEach(key => {
        hash[key] = hash[key] ? hash[key] + 1 : 1; //participant 의 값을 key 변수에 넣고 배열의 키값으로 설정. hash[key] 값이 존재하면 +1, 아니면 1로 설정
        console.log("participant : "+key + " value : " + hash[key]);
    })
    completion.forEach(key => {
        hash[key] = hash[key] - 1; // completion 의 값을 key 변수에 넣고 해당 hash[key]의 값을 -1 해줘서 0으로 만듬 
        console.log("completion : "+key + " value : " + hash[key]);
    })

    for (var key in hash) {
        console.log("hash[key] : "+key  + " value : " + hash[key]);
        if (hash[key] >= 1) return key; //hash의 값들을 key에 넣고 hash[key]의 값이 1 이상이면 리턴
        
    }
}