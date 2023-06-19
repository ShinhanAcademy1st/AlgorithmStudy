function solution(s) {
  var answer = -1;
  let list = [];

  if (s.length % 2 != 0 || s == "") {
    answer = 0;
  } else {
    for (let i of s) {
      list.push(i);
      if (list[list.length - 1] == list[list.length - 2]) {
        list.pop();
        list.pop();
      }
    }
    if (list.length == 0) {
      answer = 1;
    } else {
      answer = 0;
    }
  }
  return answer;
}
