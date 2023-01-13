import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        Pair[] pairs = new Pair[size + 1];

        final int START = 1;
        final int END = pairs.length;

        for (int i = START; i < END; i++) {
            int value = Integer.parseInt(br.readLine());
            pairs[i] = new Pair(i, value);

        }
        Arrays.sort(pairs, START, END);
        // [null, study.jaeworkspace.baekjoon.w04.NO1377$Pair@735f7ae5, ... ]
        // 0번째 인덱스의 값이 null 이라 NPE 발생해서 시작 인덱스를 1로 해주어야 함

        int max = 0;
        // 정렬전 index - 정렬후 index
        for (int i = START; i < END; i++) {
            int key = pairs[i].key;

            if(max < key - i) {
                max = key - i;
            }
        }
        bw.write((max + 1) + "");
        bw.flush();

        bw.close();
        br.close();
    }

    static class Pair implements Comparable<Pair> {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair pair) { // value 기준 오름차순 정렬
            return value - pair.value;
        }
    }
}
