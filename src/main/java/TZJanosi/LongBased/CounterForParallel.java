package TZJanosi.LongBased;

import java.util.HashMap;
import java.util.Map;

public class CounterForParallel {
    private Map<Long,Long> result=new HashMap<>();

    public void add(long key,long value){
        result.put(key,value);
    }

    public long getTotal(){
        return result.values().stream().mapToLong(x->x.longValue()).sum();
    }

}
