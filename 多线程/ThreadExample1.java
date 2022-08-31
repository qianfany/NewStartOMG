public class ThreadExample1 {

    public static class MyRunnable implements Runnable {

        public void run() {
            System.out.println("cool");
        }
    }

    public static void main (String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.setName("zhushi");
        System.out.println(Thread.currentThread().getName());
        thread.start();
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
    }




}
