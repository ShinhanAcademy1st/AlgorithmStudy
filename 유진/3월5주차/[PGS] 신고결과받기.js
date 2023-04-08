function solution(id_list, report, k) {
  var answer = [];
  var sp_list = {}; // 정지 리스트
  var email_list = {}; // 이메일 받을 리스트
  var reports = []; // 전체 배열

  for (let id of id_list) {
    sp_list[id] = 0;
    email_list[id] = 0;
  }

  for (let rp of report) {
    reports.push(rp.split(" "));
  }

  reports = [...new Set(reports.join("|").split("|"))].map((v) => v.split(","));

  for (let i = 0; i < reports.length; i++) {
    // if (Object.keys(sp_list).includes(reports[i][1])) {
    sp_list[reports[i][1]]++; // 신고당한 횟수 저장
    // }
  }

  for (let a of Object.keys(sp_list)) {
    if (sp_list[a] >= k) {
      for (let i = 0; i < reports.length; i++) {
        if (a == reports[i][1]) {
          email_list[reports[i][0]]++;
        }
      }
    }
  }

  answer = Object.values(email_list);
  return answer;
}
