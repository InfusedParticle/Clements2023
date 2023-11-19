import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//author: aayush
//correct

public class Route {

    static class Point {
        int r, c, s;
        public Point(int a, int b, int c) {
            r = a; this.c= b; s= c;
        }
    }

    public static int bfs(int[][] kitchen, Point start) {
        Queue<Point> q = new LinkedList<>();
        int[][] steps = new int[kitchen.length][kitchen[0].length];
        q.add(start);
        while (!q.isEmpty()) {
            Point p = q.poll();
            steps[p.r][p.c] = p.s;
            Point p1 = new Point(p.r + 1, p.c, p.s + 1);
            Point p2 = new Point(p.r - 1, p.c, p.s + 1);
            Point p3 = new Point(p.r, p.c + 1, p.s + 1);
            Point p4 = new Point(p.r, p.c - 1, p.s + 1);
            if (isValid(kitchen, p1) && kitchen[p.r + 1][p.c] > kitchen[p.r][p.c]) {
                q.add(p1);
            }
            if (isValid(kitchen, p2) && kitchen[p.r - 1][p.c] > kitchen[p.r][p.c]) {
                q.add(p2);
            }
            if (isValid(kitchen, p3) && kitchen[p.r][p.c + 1] > kitchen[p.r][p.c]) {
                q.add(p3);
            }if (isValid(kitchen, p4) && kitchen[p.r][p.c - 1] > kitchen[p.r][p.c]) {
                q.add(p4);
            }
        }
        int highest = 1;
        for (int i = 0; i < steps.length; i++) {
            for (int j = 0; j < steps[0].length; j++) {
                highest = Math.max(steps[i][j], highest);
            }
        }
        return highest;

    }

    private static boolean isValid(int[][] kitchen, Point p) {
        return p.r >= 0 && p.r < kitchen.length && p.c >= 0 && p.c < kitchen[0].length;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("route.dat"));
        int tc = sc.nextInt();
        sc.nextLine();
        while (tc-->0) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int [][] kitchen = new int[r][c];
            int lowest = Integer.MAX_VALUE;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j <c; j++) {
                    kitchen[i][j] = sc.nextInt();
                    lowest = (kitchen[i][j] < lowest) ? kitchen[i][j] : lowest;
                }
            }
            List<Point> starts = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (kitchen[i][j] == lowest) {
                        starts.add(new Point(i, j, 1));
                    }
                }
            }
            int ans = 1;
            for (Point p : starts) {
                int bfs = bfs(kitchen, p);
                ans = (bfs > ans) ? bfs : ans;
            }
            System.out.println(ans);
        }
    }

}
