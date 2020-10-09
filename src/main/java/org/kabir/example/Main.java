package org.kabir.example;

/**
 * @author <a href="mailto:kabir.khan@jboss.com">Kabir Khan</a>
 */
public class Main {
    public static void main(String[] args) {
        PidUtil util = new PidUtil();
        long processId = util.pid();
        System.out.println("Process id is: " + processId);

        System.out.println("Waiting for shutdown....");
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
        }
        System.out.println("Done!");
    }
}
