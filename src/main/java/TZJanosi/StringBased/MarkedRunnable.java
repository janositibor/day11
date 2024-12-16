package TZJanosi.StringBased;

public class MarkedRunnable  implements Runnable{
    private String value;
    private CounterForParallel counter;

    private int stepNumber;

    public MarkedRunnable(int stepNumber, String value, CounterForParallel counter) {
        this.stepNumber = stepNumber;
        this.value = value;
        this.counter = counter;
    }

    private void task(){
        counter.add(value,calculationNode(1,value));
        System.out.println(value +" done.");
    }

    private Long calculationNode(int actualStep, String value) {
        if(actualStep==stepNumber){
            return (long) next(value).length;
        }
        long result=0;
        for (String child: next(value)) {
            result+=calculationNode(actualStep+1,child);
        }
        return result;
    }


    private String[] next(String value) {
        String[] result;
        int length=value.length();
        if(length>1){
            value=removeLeadingZeros(value);
        }
        length=value.length();
        if(value.equals("0")){
            result= new String[] {"1"};
            return result;
        }
        if(length%2==0){
            int halfLength=length/2;
            result=new String[]{value.substring(0,halfLength),value.substring(halfLength)};
            return result;
        }
        result= new String[]{Long.toString(Long.parseLong(value)*2024)};
        return result;
    }

    private String removeLeadingZeros(String value) {
        int startFrom = 0;
        int length = value.length();
        while (startFrom < length && value.charAt(startFrom) == '0') {
            startFrom++;
        }
        if (startFrom == 0) {
            return value;
        }
        if (startFrom == length) {
            return "0";
        } else {
            return value.substring(startFrom);
        }
    }

    @Override
    public void run() {
        task();
    }
}
