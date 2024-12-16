package TZJanosi.StringBased;

import java.util.HashMap;
import java.util.Map;

public class CounterForParallel {
    private Map<String,Long> result=new HashMap<>();

    public void add(String key,Long value){
        result.put(key,value);
    }

    public long getTotal(){
        return result.values().stream().mapToLong(x-> x.longValue()).sum();
    }
}
