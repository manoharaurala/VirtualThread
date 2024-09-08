public class VirtualThreadCreation {
    public static void doSomething(){
        try{
            Thread.sleep(3000);
        }

        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        var max=1000000;

        for(var i=0;i<max;i++){
             Thread.startVirtualThread(()->doSomething());
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("done with intensive task");
    }
}
