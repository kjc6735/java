/**
 * 
 * 
 * 올바른 형식의 계좌번호 문자열 또는 그렇지 않은 문자열로 이루어진 배열 accounts가 매개변수로 주어집니다. accounts 내의 문자열들 중 다음 두 조건을 모두 만족하는 올바른 계좌번호의 개수를 return 하도록 solution 함수를 완성해주세요.

문자열 내의 모든 글자는 숫자입니다.
12~14자리의 문자열이거나, "010"으로 시작하는 11자리 문자열입니다.
제한사항
1 ≤ accounts의 길이 ≤ 100
1 ≤ accounts의 모든 문자열의 길이 ≤ 20
accounts의 모든 문자열은 숫자와 영어 대소문자로 이루어져 있습니다.
입출력 예
accounts	result
["01012345678","Th1s1sAccountNumber","9876543210123","2208875699"]	2
["InvalidAccountNumber"]
 * 
 */

// let accounts = ["01012345678", "Th1s1sAccountNumber", "9876543210123", "2208875699"];
let accounts = ["InvalidAccountNumber"];
let answer = accounts.filter((a) => {
    if (Number(a) == 'NaN') return false; 
    if (a[0] == '0' && a[1] == '1' && a[2] == '0') {
        return a.length == 11
    }
    return a.length >= 12  && a.length <= 14
})

console.log( answer.length == 0 ? 0 : accounts.length - answer.length)
