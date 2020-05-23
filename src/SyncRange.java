public class SyncRange {
    private long start;
    private long end;
    private int increment;

    public SyncRange() {
        this(10000000);
    }

    public SyncRange(int increment) {
        start = 0;
        end = increment;
        this.increment = increment;
    }

    private synchronized void incrementRange() {
        start += increment;
        end += increment;
    }

    private synchronized Pair<Long, Long> getRange() {
        return new Pair<>(start, end);
    }

    public synchronized Pair<Long, Long> getAndIncrementRange() {
        final Pair<Long, Long> range = getRange();
        incrementRange();
        System.out.println("Range is between: " + range.first + " and " + range.second);
        return range;
    }
}