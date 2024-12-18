package TZJanosi.LongBased;

public class MarkedRunnable implements Runnable{
    private long value;
    private CounterForParallel counter;

    private int stepNumber;

    public MarkedRunnable(int stepNumber, long value, CounterForParallel counter) {
        this.stepNumber = stepNumber;
        this.value = value;
        this.counter = counter;
    }

    private void task(){
        counter.add(value, calculationNode(1,value));
        System.out.println("long, "+value +" done.");
    }


    private long calculationNode(int actualStep, long value) {
        if(actualStep==stepNumber){
            return next(value).length;
        }
        long result=0;
        for (Long child: next(value)) {
            result+= calculationNode(actualStep+1,child);
        }
        return result;
    }

    private long[] next(long value) {
        if(value==0){
            return new long[] {1L};
        }
        String stringValue=String.valueOf(value);
        if(stringValue.length()%2==0){
            int halfLength=stringValue.length()/2;
            return new long[] {Long.parseLong(stringValue.substring(0,halfLength)),Long.parseLong(stringValue.substring(halfLength))};
        }
        return new long[] {value*2024};
    }

    @Override
    public void run() {
        task();
    }
}
