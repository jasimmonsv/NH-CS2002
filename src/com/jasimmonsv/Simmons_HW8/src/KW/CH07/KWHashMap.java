package KW.CH07;

/**
 * An interface for HashMap
 * @author Koffman and Wolfgang
 */
public interface KWHashMap<K, V> {

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    int size();

    boolean isEmpty();
}
