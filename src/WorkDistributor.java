public class WorkDistributor implements Runnable {
    private final long START = 2;
    private SyncRange syncRange;
    private int threads;

    public WorkDistributor() {
        this(4);
    }

    public WorkDistributor(int threads) {
        this.threads = threads;
        this.syncRange = new SyncRange();
    }


    @Override
    public void run() {
        for (int i = 0; i < threads; i++) {
            Thread object = new Thread(new MultiThreadPrime(syncRange));
            object.start();
        }
    }
}
