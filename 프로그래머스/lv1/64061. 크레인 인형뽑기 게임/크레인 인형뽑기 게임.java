import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            int moved = moves[i] - 1;

            for (int j = 0; j < board[0].length; j++) {
                if(board[j][moved] != 0) {
                    list.add(board[j][moved]);
                    board[j][moved] = 0;
                    break;
                }
            }
        }

        int rstCnt = 0;
        int stored = -1;
        // 333이 온 경우
        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);            
            
            if(stored == tmp) {
                list.remove(i - 1);
                list.remove(i - 1);

                rstCnt = rstCnt + 2;
                stored = -1;

                i = -1;
                continue;
            }
            stored = tmp;
        }

        for (Integer integer : list) {
            System.out.print(integer + ",");

        }

        int answer = rstCnt;

        System.out.println("\nanswer = " + answer);
        return answer;
    }
}