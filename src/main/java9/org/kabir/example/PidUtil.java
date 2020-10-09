package org.kabir.example;

import java.lang.ProcessHandle;

/**
 * @author <a href="mailto:kabir.khan@jboss.com">Kabir Khan</a>
 */
public class PidUtil {
    long pid() {
        System.out.println("=== Java 9 or later!");
        return ProcessHandle.current().pid();
    }
}
