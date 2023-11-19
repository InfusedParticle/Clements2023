import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//author: michael
//correct

public class Triple {
    public static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("triple.dat"));
        int T = sc.nextInt();
        while (T-- > 0) {
            long l = sc.nextLong();
            long t = 0;
            long p = 0;
            for (long i = 3; i <= l/3; i++) {
                for (long j = 1; j <= i; j++) {
                    if ((i*i)%j == 0) {
                        if ((j + (i*i)/j)%2==0) {
                            long b = (j+i*i/j)/2;
                            long c = b-j;
                            if (c>i && b>i && (i+b+c) <= l) {
                                if (gcd(i, gcd(b, c)) == 1) {
                                    p++;
                                    t++;
                                } else {
                                    t++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(t + " triple(s), " + p + " primitive(s)");
        }
    }
}
