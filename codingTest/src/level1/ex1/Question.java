package level1.ex1;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()){
            int cnt = 0;

            while (cnt < index){
                if(ch == 'z'){
                    ch = 'a'; // z 넘으면 다시 a로
                } else {
                    ch++;
                }
                if(!skip.contains(String.valueOf(ch))){
                    cnt++;
                }
            }
            sb.append(ch);
        }
        answer = sb.toString();
        return answer;
    }
}


public class Question {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution("aukks","wbqd",5));

    }
}
