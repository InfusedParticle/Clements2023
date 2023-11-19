import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//author: michael
//correct

public class Gift {
    public static HashMap<String,node> m;
    public static boolean go(String n) {
        if (n.equals("Ramsey")) {
            return true;
        }
        if (m.get(n).vis) {
            return false;
        }
        m.get(n).vis = true;
        boolean res = false;
        for (String nod : m.get(n).c) {
            res |= go(nod);
        }
        return res;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("gift.dat"));
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            m = new HashMap<>();
            m.put("You", new node("You"));
            for (int i = 0; i < N; i++) {
                String a = sc.next();
                String b = sc.next();
                if (!m.containsKey(a)) {
                    m.put(a, new node(a));
                }
                if (!m.containsKey(b)) {
                    m.put(b, new node(b));
                }
                m.get(a).c.add(b);
                m.get(b).c.add(a);
            }
            if (go("You")) {
                System.out.println("Happy Gifting.");
            } else {
                System.out.println("Not So Secret Santa.");
            }
        }
    }
}

class node {
    String val;
    boolean vis = false;
    ArrayList<String> c;
    public node(String s) {
        val = s;
        c = new ArrayList<>();
    }
}
