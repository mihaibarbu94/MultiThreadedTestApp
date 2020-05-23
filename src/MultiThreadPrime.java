import java.io.FileWriter;
import java.io.IOException;

public class MultiThreadPrime implements Runnable {
    private final SyncRange syncRange;

    public MultiThreadPrime(SyncRange syncRange){
        this.syncRange = syncRange;
    }

    @Override
    public void run() {
        Pair<Long,Long> range = syncRange.getAndIncrementRange();
        long startRange       = range.first;
        long endRange         = range.second;

//        if (endRange >= 9876543210.0) {
        if (endRange >= 9876543210.0) {
            return;
        }

        for (long i = startRange;  i < endRange; ++i) {
            if (!Prime.isDescrescendo(i)) {
                continue;
            } else if (!Prime.isPrime(i)){
                continue;
            } else {
                fileWriter(i);
            }
        }

        Thread object = new Thread(new MultiThreadPrime(syncRange));
        object.start();
    }

    public static void fileWriter(long primeToWrite) {
        try {
            FileWriter myWriter = new FileWriter("out/perfect_primes", true);
            myWriter.write("The perfect prime: " + primeToWrite + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}