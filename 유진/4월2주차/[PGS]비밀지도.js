function solution(n, arr1, arr2) {
  var answer = [];
  arr1 = arr1.map((item) => (item = item.toString(2).padStart(n, "0")));
  arr2 = arr2.map((item) => (item = item.toString(2).padStart(n, "0")));
  for (let a = 0; a < n; a++) {
    let result = "";
    for (let b = 0; b < n; b++) {
      if (arr1[a].charAt(b) == 1 || arr2[a].charAt(b) == 1) {
        result += "#";
      } else {
        result += " ";
      }
    }
    answer.push(result);
  }
  return answer;
}
