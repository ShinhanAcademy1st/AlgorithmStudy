import java.lang.Math;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left=10;
        int right=12;
        int[][] phone = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        for(int number:numbers){
            if(number==0) number=11;
            if(number==1||number==4||number==7){
                answer+="L";
                left=number;
            }else if(number==3||number==6||number==9){
                answer+="R";
                right=number;
            }else{
                int[][] loc = new int[3][2];
                for(int i=0;i<phone.length;i++){
                    for(int j=0;j<phone[j].length;j++){
                        if(phone[i][j]==number){
                            loc[0][0]=i;
                            loc[0][1]=j;
                        }
                        if(phone[i][j]==left){
                            loc[1][0]=i;
                            loc[1][1]=j;
                        }
                        if(phone[i][j]==right){
                            loc[2][0]=i;
                            loc[2][1]=j;
                        }
                    }
                }
                String result = distance(loc,hand);
                if(result.equals("left")){
                    answer+="L";
                    left=number;
                }else{
                    answer+="R";
                    right=number;
                }
            }
        }
        return answer;
    }
    
    public String distance(int[][] loc, String hand){
        double disLeft = Math.abs((loc[0][0]-loc[1][0]))+
            Math.abs((loc[0][1]-loc[1][1]));
        double disRight = Math.abs((loc[0][0]-loc[2][0]))+
             Math.abs((loc[0][1]-loc[2][1]));
        if(disLeft < disRight){
            return "left";
        }else if(disLeft > disRight) {
            return "right";
        }else{
            if(hand.equals("left")){
                return "left";
            }else{
                return "right";
            }
        }
    }
}