class Foo {
    int count;
    public Foo() {
        count = 0;
        
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count+=1;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(count < 1) {
            wait();
        }
        printSecond.run();
        count+=1;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(count < 2) {
            wait();
        }
        printThird.run();
        notifyAll();
        
    }
}