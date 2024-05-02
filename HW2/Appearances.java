package OOP.HW2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Appearances {
    public static <T> int sameCount(Collection<T> a, Collection<T> b){
        Map<T,Integer> mp1 = new HashMap<>();
        Map<T,Integer> mp2 = new HashMap<>();
        for(T item : a){
            mp1.put(item, mp1.getOrDefault(item,0)+1);
        }
        for (T item : b){
            mp2.put(item,mp2.getOrDefault(item,0)+1);
        }
        int cnt = 0;
        for(Map.Entry<T,Integer> entry : mp1.entrySet()){
            T x = entry.getKey();
            int keyA = entry.getValue();
            int keyB = mp2.getOrDefault(keyA,0);
            if(keyA == keyB) cnt++;
        }
        return cnt;
    }
}
