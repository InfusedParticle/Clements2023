import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

//author: victor
//correct

public class Change {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("change.dat"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int c = sc.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }
            boolean[] dp = new boolean[c+1];
            dp[0] = true;
            for (int j = 0; j < m; j++) {
                for (int i = c; i >= 0; i--) {
                    if (dp[i]) {
                        if (i + arr[j] <= c) dp[i + arr[j]] = true;
                    }
                }
            }
            if (dp[c]) System.out.println("Very good chef.");
            else System.out.println("Idiot sandwich.");
        }
    }
}
