function solution(s) {
  var answer = "";
  let list = s.split(" ");
  let new_list = [];
  var pattern = /[a-zA-Z]/;

  for (let ss of list) {
    ss = ss.toLowerCase();
    let first = ss.substr(0, 1);
    if (pattern.test(first)) {
      ss = ss.replace(first, first.toUpperCase());
    }
    new_list.push(ss);
  }

  answer = new_list.join(" ");
  return answer;
}
