import java.io.CharConversionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//author: aidan
//correct

public class Lamb {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("lamb.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = "";
            String line = sc.nextLine().toLowerCase();
            for (char c : line.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    s += c;
                }
            }
            if (s.contains("lamb")) {
                System.out.println("Lamb location confirmed.");
            } else {
                System.out.println("Where's the lamb sauce?!?");
            }
        }
    }
}
