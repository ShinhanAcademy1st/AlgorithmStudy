class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
    	int n1=0, n2=0; 

        for(String str:goal) {
        	if(n1<cards1.length && cards1[n1].equals(str))
        		n1++;
        	else if(n2<cards2.length && cards2[n2].equals(str) )
        		n2++;
        	else {
        		answer="No";
        		break;
        	}
        }
        return answer;
    }
}