import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//author: aidan
//correct

public class DryRun {

    public static void main(String[] args) throws FileNotFoundException {
        Stream.of(new Scanner(new File("dryrun.in"))).forEach(q -> System.out.println(IntStream.range(0, q.nextInt()).map(i -> q.nextInt()).sum()));
    }

}