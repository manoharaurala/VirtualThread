import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadExecutor {

    public static void doSomething(int index){
        try{
            System.out.println(index + " entering "+ Thread.currentThread());
            var result= Files.lines(Path.of("/Users/manohraurala/TextFiles/Ruby.txt")).count();
            System.out.println(index + " exiting "+ Thread.currentThread()+" "+result);
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        var max=10;
        //var exceutors=Executors.newFixedThreadPool(100);
        var exceutors= Executors.newVirtualThreadPerTaskExecutor();
        for(var i=0;i<max;i++){
            var index=i;
            exceutors.submit(()->doSomething(index));

        }

        exceutors.shutdown();
        try {
            exceutors.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
