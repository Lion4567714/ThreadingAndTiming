import java.util.ArrayList;

/**
 * <b>Timer Class</b>
 *
 * Used for get, storing, and returning the time it takes for a program to run. Can also be used
 * to find the average time an iteration takes to run.
 *
 * @author Anders Gilliland
 * @version 24-10-2021
 *
 */
public class Timer {

    private long startTime;
    private long endTime;
    private ArrayList<Long> times;

    public Timer() {
        startTime = 0;
        endTime = 0;
        times = new ArrayList<Long>();
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void lap() {
        if (times.isEmpty()) {
            times.add(System.nanoTime() - startTime);
        } else {
            times.add(System.nanoTime() - times.get(times.size() - 1));
        }
    }

    public void end() {
        endTime = System.nanoTime();
    }

    public void clear() {
        startTime = 0;
        endTime = 0;
        times = new ArrayList<Long>();
    }

    @Override
    public String toString() {
        if (startTime == 0 || endTime == 0) {
            return "Timer not started/ended properly.";
        } else {
            String str = String.format("Total Run Time: %.6fs",
                    (endTime - startTime) / 1000000000f);

            if (!times.isEmpty()) {
                str += "\nIterations: " + times.size();
                str += String.format("\nAverage Iteration Time: %.6fs",
                        ((endTime - startTime) / times.size()) / 1000000000f);
            }

            return str;
        }
    }
}
