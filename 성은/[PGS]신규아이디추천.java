class Solution {
    public String solution(String new_id) {
        //1
        String answer = new_id.toLowerCase();
        //2
        answer=answer.replaceAll("[^a-z_0-9\\.\\-]","");
        //3
        while(answer.indexOf("..")>=0){
             answer=answer.replace("..",".");
        }
        //4
        if(Character.toString(answer.charAt(0)).equals(".")){
            answer=answer.replaceFirst(".","");
        }
        if(answer.length()!=0 && Character.toString(answer.charAt(answer.length()-1)).equals(".")){
            answer=answer.substring(0,answer.length()-1);
        }
        //5
        if(answer.length()==0){
            answer="a";
        }
        //6
        if(answer.length()>=16){
            answer=answer.substring(0,15);
            if(Character.toString(answer.charAt(answer.length()-1)).equals(".")){
                answer=answer.substring(0,14);
            }
        }
        //7
        if(answer.length()<=2){
            while(answer.length()<3){
                answer+=Character.toString(answer.charAt(answer.length()-1));
            }
        }
        
        return answer;
    }
}