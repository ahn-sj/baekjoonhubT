import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[] ints = new int[size + 1];

        for (int i = 2; i < ints.length; i++) {
            ints[i] = ints[i - 1] + 1;

            if(i % 2 == 0) {
                ints[i] = Math.min(ints[i], ints[i / 2] + 1);
            }
            if(i % 3 == 0) {
                ints[i] = Math.min(ints[i], ints[i / 3] + 1);
            }
        }
        bw.write(ints[size] + "");
        bw.flush();

        bw.close();
        br.close();

    }
}
