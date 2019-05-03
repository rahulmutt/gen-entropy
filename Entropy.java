import static java.lang.management.ManagementFactory.*;

import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.MemoryMXBean;

public class Entropy {
    public static String get() {
        StringBuffer sb = new StringBuffer();

        sb.append(System.nanoTime());

        sb.append(getOperatingSystemMXBean().getSystemLoadAverage());

        CompilationMXBean cb = getCompilationMXBean();
        if (cb != null) sb.append(cb.getTotalCompilationTime());

        for (GarbageCollectorMXBean gb : getGarbageCollectorMXBeans()) {
            sb.append(gb.getCollectionCount());
            sb.append(gb.getCollectionTime());
        }

        MemoryMXBean mb = getMemoryMXBean();
        sb.append(mb.getHeapMemoryUsage());
        sb.append(mb.getNonHeapMemoryUsage());

        return sb.toString();
    }
}