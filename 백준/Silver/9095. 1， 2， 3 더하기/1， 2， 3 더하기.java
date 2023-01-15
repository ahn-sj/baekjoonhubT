import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        int[] addWays = new int[11];
        addWays[1] = 1;
        addWays[2] = 2;
        addWays[3] = 4;

        for (int i = 4; i < addWays.length; i++) {
            addWays[i] = addWays[i - 1] + addWays[i - 2] + addWays[i - 3];
        }
        for (int i = 0; i < testCase; i++) {
            int integer = Integer.parseInt(br.readLine());
            bw.write(addWays[integer] + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}