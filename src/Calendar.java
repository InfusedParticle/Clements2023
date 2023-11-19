import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

//author: aidan
//correct

public class Calendar {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("calendar.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            int shift = Integer.parseInt(tokens[1]);
            String[] tokens2 = tokens[0].split("/");
            int month = Integer.parseInt(tokens2[0]) - 1;
            int day = Integer.parseInt(tokens2[1]);
            int year = Integer.parseInt(tokens2[2]);
            GregorianCalendar gc = new GregorianCalendar(year, month, day);
            gc.add(GregorianCalendar.DAY_OF_MONTH, shift);
            SimpleDateFormat sdf = new SimpleDateFormat("MMMMM d, yyyy");
            System.out.println(sdf.format(gc.getTime()));
        }
    }

}
