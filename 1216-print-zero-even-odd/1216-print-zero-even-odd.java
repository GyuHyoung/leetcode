class ZeroEvenOdd {
    private int n;
    private Semaphore evenSmph;
    private Semaphore oddSmph;
    private Semaphore zeroSmph;
    private int cnt;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        cnt = 0;
        evenSmph = new Semaphore(0);
        oddSmph = new Semaphore(0);
        zeroSmph = new Semaphore(1);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSmph.acquire();
            printNumber.accept(0);
            if(i % 2 == 0) {
                evenSmph.release();
            } else {
                oddSmph.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            evenSmph.acquire();
            printNumber.accept(i);
            zeroSmph.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i+=2) {
            oddSmph.acquire();
            printNumber.accept(i);
            zeroSmph.release();
        }

    }
}