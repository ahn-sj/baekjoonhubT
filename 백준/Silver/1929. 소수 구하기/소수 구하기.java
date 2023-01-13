import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);

        isPrime3(start, end, isPrime);
        for (int i = start; i <= end; i++) {
            if(isPrime[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }

    private static void isPrime3(int start, int end, boolean[] isPrime) {
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= end; i++) {
            if(isPrime[i]) {
                for (int j = i; i * j <= end; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }
}
