/*<exercise>*/
/**
 * Implementation of the HashSetOpen class using an array for storage
 * instead of a HashMap object.
 */
package KW.CH07;
import java.util.AbstractSet;
import java.util.Iterator;


/** Hash table implementation using open addressing.
 *  @author Koffman and Wolfgang
 */
public class HashSetOpen2<K> extends AbstractSet<K> {
    // Data Fields

    private Object[] table;
    private static final int START_CAPACITY = 101;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private static final Object DELETED = new Object();

    // Constructor
    public HashSetOpen2() {
        table = new Object[START_CAPACITY];
    }

    /** Returns the number of entries in the map */
    @Override
    public int size() {
        return numKeys;
    }

    /** Returns true if empty */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /*<exercise chapter="7" section="5" type="programming" number="3">*/
    /** 
     * Finds either the target key or the first empty slot in the
     * search chain using linear probing.
     * @pre: The table is not full.
     * @param key The key of the target object
     * @return The position of the target or the first empty slot if
     *         the target is not in the table.
     */
    private int find(Object key) {
        // Calculate the starting index.
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length; // Make it positive.
        }
        // Increment index until an empty slot is reached
        // or the key is found.
        while ((table[index] != null)
                && (!key.equals(table[index]))) {
            index++;
            // Check for wraparound.
            if (index >= table.length) {
                index = 0; // Wrap around.
            }
        }
        return index;
    }

   /** 
     * Method contains for class HashSetOpen2.
     * @param key The key being sought
     * @return the value associated with this key if found;
     *         otherwise, null
     */
    @Override
    public boolean contains(Object key) {
        // Find the first table element that is empty
        // or the table element that contains the key.
        int index = find(key);

        // If the search is successful, return the value.
	return table[index] != null;
    }
    /*</exercise>*/
    
    /** 
     * Method add for class HashSetOpen2.
     * @post the key is in the set
     * @param key the value to insert into the set
     * @return true if the contents of the set is modified
    */
    @Override
    public boolean add(K key) {
        // Find the first table element that is empty
        // or the table element that contains the key.
        int index = find(key);

        // If an empty element was found, insert new entry.
        if (table[index] == null) {
            table[index] = key;
            numKeys++;
            // Check whether rehash is needed.
            double loadFactor =
                    (double) (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD) {
                rehash();
            }
            return true;
        } else {
	    return false;
	}
    }

    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * @post The size of table is doubled and is an odd integer.
     *       Each nondeleted entry from the original table is
     *       reinserted into the expanded table.
     *       The value of numKeys is reset to the number of items
     *       actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        // Save a reference to oldTable.
        Object[] oldTable = table;
        // Double capacity of this table.
        table = new Object[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
                // Insert entry in expanded table
		add((K)oldTable[i]);
            }
        }
    }

    /**
     * Remove the item with a given key value
     * @param key The key to be removed
     * @return true if the contents of the set are changed
     */
    @Override
    public boolean remove(Object key) {
        int index = find(key);
        if (table[index] == null) {
            return false;
        }
        table[index] = DELETED;
        numKeys--;
	return true;
    }

    /** Return an iterator over the set. */
    @Override
        public Iterator<K> iterator() {
	return new SetIterator();
    }

    private class SetIterator implements Iterator<K> {

        //Data Field
        /** Index into array containing the hash table */
        int index = -1;
        int indexOfLastReturned = -1;

        //Methods
        public SetIterator() {
            advanceIndex();
        }

        @Override
        public boolean hasNext() {
            return index < table.length;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            K returnValue = (K) table[index];
            indexOfLastReturned = index;
            advanceIndex();
            return returnValue;
        }

        @Override
        public void remove() {
            if (indexOfLastReturned == -1) {
                throw new IllegalStateException();
            }
            table[indexOfLastReturned] = DELETED;
            numDeletes++;
            indexOfLastReturned = -1;
        }

        private void advanceIndex() {
            do {
                index++;
            } while (index < table.length
                    && table[index] != null
                    && table[index] != DELETED);
        }
    }
}
/*</exercise>*/