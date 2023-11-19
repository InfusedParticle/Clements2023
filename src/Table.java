import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//author: aayush
//correct

public class Table {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("table.dat"));
        int n = sc.nextInt();
        while (n-- >0) {
            long salad = sc.nextLong();
            long soup = sc.nextLong();
            long steak = sc.nextLong();
            long pots = (int) Math.ceil(soup/15.0);
            long crackers = (int) Math.ceil(soup/3.0);
            long bowls = salad + soup;
            long steaks = (int) Math.ceil(steak / 3.0);
            long plates = steak;
            long parmesan = (int) Math.ceil(bowls / 15.0);
            long lettuce = (int) Math.ceil(salad / 2.0);
            long croutons = (int) Math.ceil(salad / 3.0);
            long dressing = (int) Math.ceil(salad/10.0);
            String[] itemOrder = "head(s) of lettuce, bag(s) of croutons, bottle(s) of dressings, pot(s) of soup, bag(s) of crackers, steak(s), plate(s), bowl(s), block(s) of parmesan".split(", ");
            long[] order = {lettuce, croutons, dressing, pots, crackers, steaks, plates, bowls, parmesan};
            ArrayList<String> output = new ArrayList<>();
            for(int i = 0; i < 9; i++) {
                if(order[i] == 0) {
                    continue;
                }
                output.add(order[i] + " " + itemOrder[i]);
            }
            String x = output.toString();
            System.out.println(x.substring(1, x.length() - 1));
        }

    }

}
