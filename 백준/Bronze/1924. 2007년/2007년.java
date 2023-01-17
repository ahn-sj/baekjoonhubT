import java.util.Scanner;

/**
 * 2007년
 */
public class Main {
    public static void main(String[] args) {
        //                 0     1     2     3      4     5     6
        String yoils[] = {"MON","TUE","WED","THU", "FRI","SAT","SUN"};

        //                   1   2   3   4   5   6   7   8   9   10  11  12
        int lastDays[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner scan = new Scanner(System.in);

        int month = scan.nextInt();
        int day = scan.nextInt() - 1;

        for (int i = 0; i < month; i++) {
            day += lastDays[i];
        }
        System.out.println(yoils[day % 7]);
    }
}
