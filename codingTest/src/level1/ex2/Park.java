package level1.ex2;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int height = park.length, width = park[0].length(); //공원 넓이
        int x = 0, y = 0; //시작점

        for (int i = 0; i < park.length; i++) {
            if (park[i].indexOf('S') != -1) { // 시작점 찾기
                x = park[i].indexOf('S');
                y = i;
                break;
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] des = routes[i].split(" ");
            String dir = des[0];
            int move = Integer.parseInt(des[1]); // dir 방향, move 칸 수
            boolean flag = true;
            int curX = x, curY = y; //이동할 위치 변수

            if (dir.equals("E")) {
                for (int j = 1; j <= move; j++) {
                    curX++;
                    if (curX >= width) { // 범위 비교
                        flag = false;
                        break;
                    } else if (park[curY].charAt(curX) == 'X') { //장애물만나면 break
                        flag = false;
                        break;
                    }
                }
                if (flag) x = curX; // 이동했다면 x에 현위치 저장

            } else if (dir.equals("W")) {
                flag = true;
                for (int j = 1; j <= move; j++) {
                    curX--;
                    if (curX < 0) {
                        flag = false;
                        break;
                    } else if (park[curY].charAt(curX) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if (flag) x = curX;

            } else if (dir.equals("S")){
                flag = true;
                for ( int j = 1; j <= move; j++){
                    curY++;
                    if (curY >= height) {
                        flag = false;
                        break;
                    } else if (park[curY].charAt(curX) == 'X'){
                        flag = false;
                        break;
                    }
                }
                if (flag) y = curY;
            } else if (dir.equals("N")){
                flag = true;
                for ( int j = 1; j <= move; j++){
                    curY--;
                    if (curY < 0) {
                        flag = false;
                        break;
                    } else if (park[curY].charAt(curX) == 'X'){
                        flag = false;
                        break;
                    }
                }
                if (flag) y = curY;
            }
        }

        answer[0] = y;
        answer[1] = x;

        return answer;

    }
}

    public class Park {
        public static void main(String[] args) {
            String[] lane1 = {"SOO", "OOO", "OOO"};
            String[] lane2 = {"SOO", "OXX", "OOO"};
            String[] lane3 = {"OSO", "OOO", "OXO", "000"};
            String[] routes1 = {"E 2", "S 2", "W 1"};
            String[] routes2 = {"E 2", "S 2", "W 1"};

            Solution s = new Solution();
            int[] result = s.solution(lane2, routes2);

            System.out.println(result[0] + " " + result[1]);

        }
    }
