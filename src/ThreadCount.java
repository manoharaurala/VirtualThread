public class ThreadCount {
    public static void main(String[] args) {
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        long totalMemory=Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();

        // Assume each thread requires 1MB of memory (this is just an example value)
        long memoryPerThread = 1 * 1024 * 1024; // 1MB in bytes

        // Calculate maximum number of threads based on memory constraints
        long maxThreadsBasedOnMemory = freeMemory / memoryPerThread;

        // Final thread count should be the minimum of cores or memory-based calculation
        int optimalThreadCount = (int) Math.min(numberOfCores, maxThreadsBasedOnMemory);


        System.out.println("numberOfCores: "+numberOfCores);
        System.out.println("totalMemory: "+totalMemory);
        System.out.println("Optimal Thread Count: " + optimalThreadCount);

        //No of thraed allowed to create allowed create
        /*
        No of thread=No of core/1-blocking factor
        0<=blocking factor<1


         */

        //Thread is native thread created at os level

        //Virtual Thraed mointed on carrier thraed
    }
}
