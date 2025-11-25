package ex01;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        // 1. Long으로 타겟 값 파싱 (오버플로우 방지)
        long targetValue = Long.parseLong(p);

        int pLength = p.length();
        int tLength = t.length();

        // 2. 루프 조건을 마지막 시작 인덱스(tLength - pLength)로 명확하게 설정
        for (int i = 0; i <= tLength - pLength; i++) {

            // 3. String.substring()으로 효율적인 부분 문자열 추출
            // (i부터 i + pLength 길이만큼)
            String sub = t.substring(i, i + pLength);

            // 4. 부분 문자열 값도 Long으로 파싱
            long subValue = Long.parseLong(sub);

            if (subValue <= targetValue) {
                answer++;
            }
        }
        return answer;
    }
}

public class SmallString {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution("3141592", "271");
        System.out.println(result);
    }
}
