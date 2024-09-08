public class ThreadCreationFailure {

    public static void doSomething(){
        try{
            Thread.sleep(3000);
        }

         catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        var max=3000;

        for(var i=0;i<max;i++){
            new Thread(()->doSomething()).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("done with intensive task");


    }
}
