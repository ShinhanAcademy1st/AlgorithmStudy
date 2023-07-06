import java.util.HashMap;

class Solution {
    public String solution(int[] numbers, String hand) {
        HashMap<Character, int[]> keypad = new HashMap<>();
        keypad.put('1', new int[] {0, 0});
        keypad.put('2', new int[] {0, 1});
        keypad.put('3', new int[] {0, 2});
        keypad.put('4', new int[] {1, 0});
        keypad.put('5', new int[] {1, 1});
        keypad.put('6', new int[] {1, 2});
        keypad.put('7', new int[] {2, 0});
        keypad.put('8', new int[] {2, 1});
        keypad.put('9', new int[] {2, 2});
        keypad.put('*', new int[] {3, 0});
        keypad.put('0', new int[] {3, 1});
        keypad.put('#', new int[] {3, 2});
        
        String answer = "";
        char[] handLoc = new char[] {'*', '#'};
        
        for(int tmpKey : numbers) {
            char key = (char) (tmpKey + '0');
            switch(key) {
                case '1', '4', '7':
                    answer += "L";
                    handLoc[0] = key;
                    break;
                case '3', '6', '9':
                    answer += "R";
                    handLoc[1] = key;
                    break;
                case '2', '5', '8', '0':
                    int[] tmp = keypad.get(key);
                    int left = Math.abs(keypad.get(handLoc[0])[0] - tmp[0]) + Math.abs(keypad.get(handLoc[0])[1] - tmp[1]);
                    int right = Math.abs(keypad.get(handLoc[1])[0] - tmp[0]) + Math.abs(keypad.get(handLoc[1])[1] - tmp[1]);
                    
                    if(left < right) {
                        answer += "L";
                        handLoc[0] = key;
                    } else if(left > right) {
                        answer += "R";
                        handLoc[1] = key;
                    } else {
                        if(hand.equals("left")) {
                            answer += "L";
                            handLoc[0] = key;
                        } else {
                            answer += "R";
                            handLoc[1] = key;
                        }
                    }
                    break;
            }
        }
        
        
        return answer;
    }
}