function solution(arr) {
  var answer = [];
  let value = 10;

  for (let a of arr) {
    if (value != a) {
      value = a;
      answer.push(a);
    }
  }

  return answer;
}
