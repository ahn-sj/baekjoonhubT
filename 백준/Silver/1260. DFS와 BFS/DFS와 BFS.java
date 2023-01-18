import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int node, line, start;

    static boolean[] checked;
    static int[][] matrix;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        matrix = new int[node + 1][node + 1];
        checked = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(stt.nextToken());
            int col = Integer.parseInt(stt.nextToken());

            matrix[row][col] = matrix[col][row] = 1;
        }

        dfs(start);
        sb.append("\n");
        bfs(start);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        checked[start] = true;
        sb.append(start + " ");

        for (int i = 1; i <= node; i++) {
            if(!checked[i] && matrix[start][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Arrays.fill(checked, false);

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        checked[start] = true;

        while (hasElement(queue)) {
            Integer value = queue.poll();
            sb.append(value + " ");

            for (int i = 1; i <= node; i++) {
                if(!checked[i] && matrix[value][i] == 1) {
                    queue.offer(i);
                    checked[i] = Boolean.TRUE;
                }
            }
        }
    }

    private static boolean hasElement(Queue<Integer> queue) {
        return !queue.isEmpty();
    }
}
