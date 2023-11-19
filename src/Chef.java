import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

//author: aidan
//correct

public class Chef {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> map = new HashMap<>();
        map.put("Asparagus", "Green");
        map.put("Broccoli", "Green");
        map.put("Potatoes", "Golden-Brown");
        map.put("Carrots", "Light-Orange");
        Scanner sc = new Scanner(new File("chef.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            List<String> bad = new ArrayList<>();
            int nm = sc.nextInt();
            sc.nextLine();
            while (nm --> 0) {
                String name = sc.next();
                String desc = sc.next();
                sc.nextLine();
                if (map.containsKey(name) && !map.get(name).equals(desc)) {
                    bad.add(name);
                }
                if (!map.containsKey(name)){
                    int num = 0;
                    try {
                        num = Integer.parseInt(desc);
                    } catch (Exception e){
                        bad.add(name);
                        break;
                    }
                    if (name.equals("Steak") && (num < 165 || num > 175)) {
                        bad.add(name);
                    } else if (name.equals("Roast-Chicken") && (num < 165 || num > 180)) {
                        bad.add(name);
                    } else if (name.equals("Pork-Chops") && (num < 150 || num > 165)) {
                        bad.add(name);
                    }



                }


            }
            if (bad.size() == 0) {
                System.out.println("Very Good Chef.");
            } else {
                System.out.println("You're Fired.");
                System.out.println(String.join(",", bad));
            }



        }


    }

}
