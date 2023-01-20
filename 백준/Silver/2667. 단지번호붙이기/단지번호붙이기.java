import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    static int map[][];
    static boolean[][] checked;

    static int mapSize;
    static int counter;

    static List<Integer> apartment = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        mapSize = Integer.parseInt(br.readLine());

        map = new int[mapSize][mapSize];
        checked = new boolean[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            String[] households = br.readLine().split("");

            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Integer.parseInt(households[j]);
            }
        }

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if(isChecked(i, j)) {
                    counter = 1;
                    bfs(i, j);
                    apartment.add(counter);
                }
            }
        }
        Collections.sort(apartment);

        sb.append(apartment.size());
        for (Integer integer : apartment) {
            sb.append("\n" + integer);
        }
        System.out.println(sb.toString());
    }

    private static boolean isChecked(int i, int j) {
        return !checked[i][j] && map[i][j] == 1;
    }

    private static void bfs(int x, int y) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{x, y});

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        checked[x][y] = true;
        
        while (hasElement(queue)) {
            Point point = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int curX = dx[i] + point.x;
                int curY = dy[i] + point.y;

                if(isValidRange(curX, curY) && isChecked(curX, curY)) {
                    queue.offer(new Point(curX, curY));
                    checked[curX][curY] = true;
                    counter++;
                }
            }
        }
    }

    private static boolean isValidRange(int curX, int curY) {
        return curX >= 0 && curY >= 0 && curX < mapSize && curY < mapSize;
    }

    private static boolean hasElement(Queue<Point> queue) {
        return !queue.isEmpty();
    }
}