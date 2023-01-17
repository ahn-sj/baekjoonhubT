import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack();

        String[] ironSticks = br.readLine().split("");

        int rst = 0;

        for (int i = 0; i < ironSticks.length; i++) {
            char ironStick = ironSticks[i].charAt(0);

            if('(' == ironStick) {
                stack.add('(');
            } else if(')' == ironStick) {
                stack.pop();

                if(ironSticks[i - 1].charAt(0) == '(') {
                    rst += stack.size();
                } else {
                    rst++;
                }
            }
        }
        bw.write(rst + "");
        bw.flush();

        bw.close();
        br.close();
    }
}
