import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//author: michael
//correct

public class Kitchen {
    public static boolean good(int r, int c, int i, int j) {
        return 0 <= i && i < r && 0 <= j && j < c;
    }
    public static boolean[][] vis;
    public static int endr, endc;
    public static int r, c;
    public static char[][] a;
    public static int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    public static boolean dfs (int j, int k) {
        if (a[j][k] == '#') {
            return false;
        }
        if (j == endr && k == endc) {
            return true;
        }
        if (vis[j][k]) {
            return false;
        }
        vis[j][k] = true;
        boolean res = false;
        for (int i = 0; i < 4; i++) {
            if (good(r, c, j+ dirs[i][0], k+ dirs[i][1])) {
                res |= dfs(j + dirs[i][0], k + dirs[i][1]);
            }
        }
        return res;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("kitchen.dat"));
        int T = sc.nextInt();
        while (T-- > 0) {
            r = sc.nextInt();
            c = sc.nextInt();
            int startr = 0, startc = 0;
            vis = new boolean[r][c];
            a = new char[r][c];
            for (int i = 0 ; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    a[i][j] = '-';
                }
            }
            for (int i = 0; i < r; i++) {
                String l = sc.next();
                char[] arr = l.trim().toCharArray();
                for (int j = 0; j < c; j++) {
                    if (a[i][j] == '-') {
                        a[i][j] = arr[j];
                        if (arr[j] == 'C' || arr[j] == 'G' || arr[j] == 'S') {
                            a[i][j] = '.';
                        }
                    }
                }
                if (l.contains("O")) {
                    endr = i;
                    endc = l.indexOf("O");
                }
                if (l.contains("S")) {
                    startr = i;
                    startc = l.indexOf("S");
                }
                if (l.contains("G")) {
                    int gr = i;
                    int gc = l.indexOf("G");
//                    System.out.println("gr = " + gr);
//                    System.out.println("gc = " + gc);
                    for (int j = -2; j <= 2; j++) {
                        for (int k = -2; k <= 2; k++) {
                            if (good(r, c, gr + j, gc + k)) {
                                a[gr + j][gc + k] = '#';
                            }
                        }
                    }
                }
            }
//            for (int j = 0; j < r; j++) {
//                for (int k = 0 ;k < c; k++) {
//                    System.out.print(a[j][k]);
//                }
//                System.out.println();
//            }
//            System.out.println("startr = " + startr);
//            System.out.println("startc = " + startc);
            if (dfs(startr, startc)) {
                System.out.println("Very good chef.");
            } else {
                System.out.println("Don't bother showing up.");
            }
        }
    }
}
