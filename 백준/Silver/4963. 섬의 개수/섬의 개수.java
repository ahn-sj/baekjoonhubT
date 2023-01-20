import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {0, -1, 0, 1, 1, 1, -1, -1};
    static int dy[] = {1, 0, -1, 0, 1, -1, -1, 1};

    static int[][] map;
    static boolean[][] checked;

    static int width;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = "";

        while(!(str = br.readLine()).equals("0 0")) { // 0 0 이 아닌 경우 반복
            st = new StringTokenizer(str);

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            checked = new boolean[height][width];
            map = new int[height][width];

            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(isChecked(i, j)) {
                        bfs(i, j);
                        island++;
                    }
                }
            }
            sb.append(island).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        checked[x][y] = true;
        queue.offer(new Point(x, y));

        while (hasElement(queue)) {
            Point point = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int curX = dx[i] + point.x;
                int curY = dy[i] + point.y;

                if(isValidRange(curX, curY) && isChecked(curX, curY)) {
                    queue.add(new Point(curX, curY));
                    checked[curX][curY] = true;
                }
            }
        }
    }

    private static boolean isChecked(int x, int y) {
        return !checked[x][y] && map[x][y] == 1;
    }

    private static boolean isValidRange(int curX, int curY) {
        return curX >= 0 && curY >= 0 && curX < height && curY < width;
    }

    private static boolean hasElement(Queue<Point> queue) {
        return !queue.isEmpty();
    }
}
