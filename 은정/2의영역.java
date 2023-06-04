import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int start = -1;
        int end = -1;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 2){
                if(start == -1)
                    start = i;
                end = i;
            }
        }
        
        return start!=-1 ? Arrays.copyOfRange(arr,start, end+1) : new int[]{-1};

    }
}