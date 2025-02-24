class FooBar {
    private int n;
    private boolean printed;

    public FooBar(int n) {
        this.n = n;
        printed = false;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(printed == true) {
                wait();
            }

        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            printed = true;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(printed == false) {
                wait();
            }
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            printed = false;
            notifyAll();
        }
    }
}