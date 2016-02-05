package fibonacciobserver;


import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread{
    private long tal;
    private long in;
    List<FibonacciObserver> observers = new ArrayList();
    
    public void registerFibonacciObserver(FibonacciObserver o){
      observers.add(o);
    }
    
    public FibonacciTask(long n) {
        this.in = n;
        this.tal = n;
    }
    
    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    
    @Override
    public void run() {
        //Call the Fibonacci method from here
        tal = fib(tal);
        for(FibonacciObserver observer : observers){
          observer.dataReady(in,tal);
        }
    }

    public long getTal() {
        return tal;
    }
    
    
}
