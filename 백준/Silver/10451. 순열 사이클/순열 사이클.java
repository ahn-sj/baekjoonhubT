import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] permutations;
    static boolean[] checked;

    static int permutationSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            permutationSize = Integer.parseInt(br.readLine());

            permutations = new boolean[permutationSize + 1][permutationSize + 1];
            checked = new boolean[permutationSize + 1];

            st = new StringTokenizer(br.readLine());

            setConnectionPermutation(st, permutationSize);

            int permutationCircleCounter = 0;

            for (int j = 1; j <= permutationSize; j++) {
                if(!checked[j]) {
                    bfs(j);
                    permutationCircleCounter++;
                }
            }
            sb.append(permutationCircleCounter + "\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        checked[start] = true;
        queue.offer(start);

        while (hasElement(queue)) {
            Integer value = queue.poll();

            for (int i = 1; i <= permutationSize; i++) {
                if(!checked[i] && permutations[value][i]) { // 아직 탐색하지 않은 + 이어지는 경우
                    checked[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    private static boolean hasElement(Queue<Integer> queue) {
        return !queue.isEmpty();
    }

    private static void setConnectionPermutation(StringTokenizer st, int permutationSize) {
        for (int j = 1; j <= permutationSize; j++) {
            int line = Integer.parseInt(st.nextToken());
            permutations[j][line] = true;
        }
    }
}
