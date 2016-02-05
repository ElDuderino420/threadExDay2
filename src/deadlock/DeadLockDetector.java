package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author Lars Mortensen
 */
class DeadLockDetector extends Thread {

    ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();

    @Override
    public void run() {
        while (true) {
            long[] threadIds = tmxb.findDeadlockedThreads();
            if (threadIds != null) {
                ThreadInfo[] infos = tmxb.getThreadInfo(threadIds, true, true);
                System.out.println("The following threads are deadlocked:");
                for (ThreadInfo ti : infos) {
                    System.out.println(ti);
                }
            }
        }
    }
}
