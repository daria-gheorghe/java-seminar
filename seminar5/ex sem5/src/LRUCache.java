import java.util.LinkedHashMap;
import java.util.Map;
public class LRUCache<K,V> extends LinkedHashMap<K,V>
{
    int capacity;
    public LRUCache(int capacity)
    {
        super(capacity,0.75f, true);    //true=ordonare dupa acces
        //capacity=dimensiune initiala
        //daca accessOrder=false, ordonare dupa inserare
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>capacity;
    }
}
