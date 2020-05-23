public class MyThread extends Thread {

    final long numberToCompute;
    final long range = 100000;

    public MyThread(long numberToCompute) {
        this.numberToCompute = numberToCompute;

    }

    @Override
    public void run() {
        for (long i = numberToCompute; i < numberToCompute + range; ++i) {
            if (!Prime.isPrime(i)) {
                continue;
            } else if (!Prime.isDescrescendo(i)) {
                continue;
            } else {
                System.out.println("The perfect prime: " + i);
                return;
            }
        }

    }
}
