class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        String temp = ""; 
        int arr[] = new int[3]; 
        int n = 0; 
        
         for(int i = 0;i<dartResult.length();i++){
             switch(dartResult.charAt(i)){
                 case '*':
                    arr[n-1]*=2;
                    if(n >1) arr[n-2]*=2;
                    break;
                 case '#':
                    arr[n-1]*=-1;
                    break;
                 case 'S':
                    arr[n] = (int)Math.pow(Integer.parseInt(temp),1);
                    n++;
                    temp ="";
                    break;
                 case 'D':
                    arr[n] = (int)Math.pow(Integer.parseInt(temp),2);
                    n++;
                    temp ="";
                    break;
                 case 'T':
                    arr[n] = (int)Math.pow(Integer.parseInt(temp),3);
                    n++;
                    temp ="";
                    break;
                 default:
                    temp+=String.valueOf(dartResult.charAt(i));
                    break;                    
            } 
        }
        
         for(int i =0;i<arr.length;i++){
            answer+=arr[i];
        }
        
        return answer;
    }
}