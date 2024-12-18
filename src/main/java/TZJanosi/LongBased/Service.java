package TZJanosi.LongBased;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private long[] numbers;
    private int stepNumber;
    public Service(int stepNumber, String input) {
        this.stepNumber=stepNumber;
        List<Long> list=new ArrayList<>();
        Scanner scanner=new Scanner(input);
        while(scanner.hasNextLong()){
            long value= scanner.nextLong();
            list.add(value);
        }
        numbers = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            numbers[i]= list.get(i);
        }
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
