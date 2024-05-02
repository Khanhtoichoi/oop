package OOP.HW2;

import java.util.*;

public class Taboo<T> {
    private List<T> rules;
    public Set<T> noFollow(T elem){
        Set<T> st = new HashSet<>();
        T prev = null;
        for(T x : rules){
            if(prev!= null){
                if(prev == elem){
                    st.add(x);
                }
            }
            prev = x;
        }
        if(!st.isEmpty()) return st;
        else return Collections.emptySet();
    }
    public void reduce(List<T> list){
        for(int i=1; i<list.size(); i++){
            Set<T> st = noFollow(list.get(i-1));
            if(st.contains(list.get(i))) {
                list.remove(i);
                i--;
            }
        }
    }

}
