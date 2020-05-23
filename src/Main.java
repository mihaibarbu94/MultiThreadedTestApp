import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter how many threads you want to use: ");

        //capture the input in an integer
        int threads = scan.nextInt();
        scan.close();

        FileWriter myWriter = new FileWriter("perfect_primes");
        myWriter.close();

        final long startTime = System.currentTimeMillis();

        findPrimeMultiThread(threads);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            final long endTime = System.currentTimeMillis();
            System.out.println("Calculated in: " + (endTime - startTime) / 1000.0 + " seconds");
        }));
    }

    private static void findPrimeMultiThread(final int threads) {
        new Thread(new WorkDistributor(threads)).start();
    }

}
