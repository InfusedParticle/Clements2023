import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//author: aidan
//correct

public class Menu {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("menu.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            sc.nextLine();
            String[] tokens = sc.nextLine().split(" ");
            int spacing = w - 2;
            int line = 0;
            String result = "-".repeat(w) + "\n";
            List<String> tokenList = new ArrayList<>(List.of(tokens));
            String nextToken = tokenList.remove(0);
            for (int j = 0; j < h - 2;){
                if (result.endsWith("\n"))
                    result += "|";
                int offset = result.endsWith("|") ? 0 : 1;
                if (spacing < nextToken.length() + offset) {
                    result += " ".repeat(spacing) + "|\n";
                    j++;
                    spacing = w - 2;
                } else {
                    if (offset > 0) {
                        result += " ";
                    }
                    result += nextToken;
                    spacing -= nextToken.length() + offset;
                    if (tokenList.size() == 0) {
                        break;
                    }
                    nextToken = tokenList.remove(0);
                }
            }
            result += " ".repeat(spacing) + "|\n";
            result += "-".repeat(w);
            System.out.println(result);
        }


    }

}
