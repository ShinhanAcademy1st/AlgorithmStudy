import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main{
    public static void main(String[] args) throws IOException{
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        System.out.println(solution(id_list1, report1, 2));

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        System.out.println(solution(id_list2, report2, 3));
        
    }
    
    public static int[] solution(String[] id_list, String[] report, int k) {
        //1.report배열의 값 중 중복을 없애기 위해 Hash Set을 이용한다.
        Set<String> report_set = new HashSet<>();
        for(String s:report){
            report_set.add(s);
        }
        //System.out.println("report_set" + report_set);
        
        //2.2번 신고된 user를 찾는다.
        //2-1. 신고 count를 위한 user hashmap을 만든다.
        //3-1. 알림 count를 위한 user hashmap을 만든다.
        Map<String, Integer> report_count = new LinkedHashMap<>(id_list.length);
        Map<String, Integer> mail_count = new LinkedHashMap<>(id_list.length);
        //초기값 지정
        for(String s: id_list){
            report_count.put(s,0);
            mail_count.put(s,0);
        }
       // System.out.println("report_count" + report_count);
        //2-2.report_set을 돌며 신고된 user의 count값을 더해준다.
        for(String s:report_set){
            String report_user = s.split(" ")[1];
            Integer value = report_count.get(report_user);

            report_count.put(report_user, value+1);
        }

        //System.out.println("report_count" + report_count);
        //2-3. 2번 이상 신고된 user를 저장한다.
        List<String> danger_user = new ArrayList<>();
        report_count.forEach((key, value)->{
            if(value==2){
                danger_user.add(key);
            }
        });

        //System.out.println("danger_user" + danger_user);

        //3.report_set을 다시 돌며 danger_user에 대한 알림 카운트를 한다.
        //System.out.println("mail_count" + mail_count);
        for(String s:report_set){
            String user = s.split(" ")[0];
            String user_report = s.split(" ")[1];
            int user_mail_count = mail_count.get(user);
            if(danger_user.contains(user_report)){
                mail_count.put(user, user_mail_count+1);
            }
        }

        //System.out.println("mail_count" + mail_count);

        List<Integer> values = new ArrayList<>();

        mail_count.forEach((key, value)->{
            values.add(value);
        });

        int[] answer = values.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}