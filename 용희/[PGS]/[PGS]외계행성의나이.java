package level0;

public class 외계행성의나이 {
	
	public static void main(String[] args) {
		// 참조 블로그 : https://blog.naver.com/PostView.nhn?blogId=jysaa5&logNo=221831226674
		// (1) 문자 => 숫자
		char ch1 = 'a';
		int num1 = (int)ch1;
		System.out.println(num1);
		
		// (2) 숫자 => 문자
		int num2 = 64;
		char ch2 = (char)num2;
		System.out.println(ch2);
	}
	
	class Solution {
	    public String solution(int age) {
	        String answer = "";
	        int num = 0;
	        char ch;
	        
	        // 소문자 a가 아스키코드로 97이니까, 코드넘버에서 97을 +-을 리턴하도록??
	        
	        // 1. age가 들어오면 먼저 String으로 바꾼 다음, 하나씩 쪼개 (숫자로는 뭐 하기 힘드니까)
	        String str = Integer.toString(age);
	        char[] charArr = str.toCharArray(); // ex) 23살이면 => [2, 3]
	        
	        // 2. 0 => a, 1 => b 가 되도록 처리
	        for(int i=0; i<charArr.length; i++) {
	        	// [정정] 아래처럼 그냥 형변환을 하면 0~9까지의 ASCII 코드 넘버에 해당하는 48~57이 돼버린다.
	        	// num = (int)charArr[i];
	        	
	        	// 따라서 숫자(char) => 숫자(int) 는 다른 방식 적용 
	        	// 2~3번 중 3번 적용 (출처 : https://dlee0129.tistory.com/230)
	        	num = Character.getNumericValue(charArr[i]);
	        	
	        	ch = (char)(num + 97);
	        	answer += ch;
	        }
	        
	        return answer;
	    }
	}

}
