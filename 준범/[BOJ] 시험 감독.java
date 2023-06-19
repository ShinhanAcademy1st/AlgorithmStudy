/**
 * N개의 시험장에 필요한 최소 감독의 수
 * *****입력*****
 * 시험장의 수 N
 * N개의 시험장에서 응시하는 각각의 응시자 수
 * 총감독, 부감독 각각 감독할 수 있는 최대 응시자 수
 * 
 * *****출력*****
 * N개의 시험장에 필요한 최소 감독의 수
 * 
 * 1. 각 시험장에는 총감독이 한명씩 필요하다. 각 1명씩 더해주고, 응시자에서 총감독이 감독할 수 있는 응시자 수 삭제
 * 2. 나머지의 인원은 부감독이 나눠서 감독한다. 나머지 인원 / 부감독이 감독할 수 있는 응시자 수의 몫만큼 부감독이 필요하다.
 * 3. 나머지 인원 % 부감독이 감독할 수 있는 응시자 수가 1명 이상이라면, 부감독이 한명 더 필요하다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] examinees = br.readLine().split(" ");
        String [] supervisors = br.readLine().split(" ");
        int general = Integer.parseInt(supervisors[0]);
        int sub = Integer.parseInt(supervisors[1]);
        Long answer = 0L;
        for (String examinee : examinees) {
            int num = Integer.parseInt(examinee);
            ++answer;
            num -= general;
            answer += num / sub;
            if (num % sub > 0) {
                ++answer;
            }
        }
        System.out.println(answer);
        br.close();
    }
}