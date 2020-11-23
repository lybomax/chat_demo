package com.bigshen.chatDemoService.concurrent.Interruput;

public class InterruputThread {

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread() {
      @Override
      public void run() {
        while (true) {
          if (Thread.currentThread().isInterrupted()) {
            System.out.println("Interruted!");
            break;
          }
          Thread.yield();
        }
      }
    };
    t1.start();
    Thread.sleep(10000);
    t1.interrupt();
  }

}
