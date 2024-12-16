package TZJanosi.StringBased;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private String[] numbers;
    private int stepNumber;
    public Service(int stepNumber, String input) {
        this.stepNumber=stepNumber;
        numbers = input.split(" ");
    }
    public long parallelCalculation(){
        List<Thread> threads = new ArrayList<>();
        CounterForParallel counter=new CounterForParallel();
        for (int i = 0; i < numbers.length; i++) {
            Thread th = new Thread(new MarkedRunnable(stepNumber, numbers[i], counter));
            th.start();
            threads.add(th);
        }
        try {
            for (Thread th : threads) {
                th.join();
            }
        }
        catch (InterruptedException ie){
            throw new IllegalStateException("Threads join failed.");
        }
        return counter.getTotal();
    }
}
