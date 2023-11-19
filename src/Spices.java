import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//author: aidan
//correct

public class Spices {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("spices.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        List<Spice> spices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            spices.add(new Spice(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]));
        }
        Collections.sort(spices);
        for (Spice s : spices)
            System.out.println(s.name);
    }

    static class Spice implements Comparable<Spice> {
        int freq;
        List<String> colors = List.of("White", "Red", "Brown", "Orange", "Blue");
        int amt;
        String name;
        int ci;

        public Spice(String n, int a, int f, String c) {
            name = n;
            amt = a;
            freq = f;
            ci = colors.indexOf(c);
            if (ci < 0) {
                ci = 100;
            }
        }


        @Override
        public int compareTo(Spice o) {
            int fr = o.freq - freq;
            if (fr != 0) {
                return fr;
            }
            int co = ci - o.ci;
            if (co != 0) {
                return co;
            }
            int am = o.amt - amt;
            if (am != 0) {
                return am;
            }
            return name.compareTo(o.name);
        }
    }

}
