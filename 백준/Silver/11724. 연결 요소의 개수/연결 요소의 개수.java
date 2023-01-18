import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static boolean[] checked;
    static int node;
    static int line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        matrix = new int[node + 1][node + 1];
        checked = new boolean[node + 1];

        setConnectMatrix(br, line, matrix);

        int cc = 0;
        for (int i = 1; i <= node; i++) {
            if(!checked[i]) {
                bfs(i);
                cc++;
            }
        }
        System.out.println(cc);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        checked[start] = true;

        while (hasElement(queue)) {
            Integer value = queue.poll();

            for (int i = 1; i <= node; i++) {
                if(!checked[i] && matrix[value][i] == 1) {
                    queue.offer(i);
                    checked[i] = Boolean.TRUE;
                }
            }
        }
    }

    private static void setConnectMatrix(BufferedReader br, int line, int[][] matrix) throws IOException {
        for (int i = 0; i < line; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(stt.nextToken());
            int col = Integer.parseInt(stt.nextToken());

            matrix[row][col] = matrix[col][row] = 1;
        }
    }

    private static boolean hasElement(Queue<Integer> queue) {
        return !queue.isEmpty();
    }
}
