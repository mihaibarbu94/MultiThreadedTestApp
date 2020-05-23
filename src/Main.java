import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter how many threads you want to use: ");

        //capture the input in an integer
        int threads = scan.nextInt();
        scan.close();

        FileWriter myWriter = new FileWriter("out/perfect_primes");
        myWriter.close();

        final long startTime = System.currentTimeMillis();

        //findCrescendoPrimeSingleThread();
        //findDescrescendoMultiThread(threads);
        findPrimeMultiThread(threads);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown Hook is running !");
            final long endTime = System.currentTimeMillis();
            System.out.println("Calculated in: " + (endTime - startTime) / 1000.0 + " seconds");
        }));
    }

    private static void findCrescendoPrimeSingleThread() {

        long i = 10;
        while (true) {
            i++;

            if (i >= 9876543210.0) {
                return;
            }

            if (!Prime.isDescrescendo(i)) {
                continue;
            } else if (!Prime.isPrime(i)) {
                continue;
            } else {
//                System.out.println("The perfect prime: " + i);
                MultiThreadPrime.fileWriter(i);
            }
        }
    }

    private static long findDescrescendoMultiThread(final int threads) {
        ExecutorService threadPool = Executors.newFixedThreadPool(threads);

        long i = 10;
        while (true) {
            threadPool.submit(new MyThread(i));
            i = i + 100000;

        }
    }

    private static void findPrimeMultiThread(final int threads) {
        new Thread(new WorkDistributor(threads)).start();
    }

}
