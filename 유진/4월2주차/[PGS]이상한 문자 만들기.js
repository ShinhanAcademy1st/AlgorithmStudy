function solution(s) {
  var answer = "";
  let string = s.split(" ");

  string.forEach((item, index) => {
    let list = [];
    let n_list = item.split("");
    n_list.forEach((item, index) => {
      if (index % 2 === 0) {
        // 자리가 짝수인 경우
        list.push(item.toUpperCase());
      } else {
        // 자리가 홀수인 경우
        list.push(item.toLowerCase());
      }
    });
    string[index] = list.join("");
  });
  answer = string.join(" ");

  return answer;
}
