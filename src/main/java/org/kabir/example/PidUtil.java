package org.kabir.example;

import java.lang.management.ManagementFactory;

/**
 * @author <a href="mailto:kabir.khan@jboss.com">Kabir Khan</a>
 */
public class PidUtil {
    long pid() {
        System.out.println("=== Java 8 or below");
        String vmName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("VM name: " + vmName);
        return Long.parseLong(vmName.split("@")[0]);
    }
}
