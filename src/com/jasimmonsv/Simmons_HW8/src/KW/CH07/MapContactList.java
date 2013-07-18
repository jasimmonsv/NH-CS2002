/*<listing chapter="7" section="6">*/
package KW.CH07;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The interface for the telephone directory.
 * @author Koffman & Wolfgang
 */
public class MapContactList implements ContactListInterface {

    /** The contact list */
    private Map<String, List<String>> contacts =
            new TreeMap<String, List<String>>();

    /**
     * Add an entry or change an existing entry.
     * @param name The name of the person being added or changed
     * @param numbers The new number to be assigned
     * @return The old list of numbers or null if this is a new entry
     */
    @Override
    public List<String> addOrChangeEntry(String name, List<String> newNumbers) {
        List<String> oldNumbers = contacts.put(name, newNumbers);
        return oldNumbers;
    }

    /**
     * Look up an entry.
     * @param name The name of the person to look up
     * @return The number or null if name is not in the directory
     */
    @Override
    public List<String> lookupEntry(String name) {
        return contacts.get(name);
    }

    /**
     * Remove an entry from the directory.
     * @param name The name of the person to be removed
     * @return The current list of numbers. If not in directory, null is
     *         returned
     */
    @Override
    public List<String> removeEntry(String name) {
        return contacts.remove(name);
    }

    /** Dislays the contact list in order by name. */
    public void display() {
        for (Map.Entry<String, List<String>> current :
                contacts.entrySet()) {
            // Display the name
            System.out.println(current.getKey());
            // Display the list of numbers
            System.out.println(current.getValue());
        }
    }

    /** Demonstration of Contact List */
    public static void main(String[] args) {
        MapContactList contactList = new MapContactList();
        List<String> nums = new ArrayList<String>();
        nums.add("123");
        nums.add("345");
        contactList.addOrChangeEntry("Jones", nums);
        nums = new ArrayList<String>();
        nums.add("135");
        nums.add("357");
        contactList.addOrChangeEntry("King", nums);
        /*<exercise chapter="7" section="6" type="programming" number="1">*/
        //Display should be
        //Jones
        //[123, 345]
        //King
        //[135, 357]
        contactList.display();
        // Jones should be in the list
        System.out.println("Numbers for Jones "
                + contactList.lookupEntry("Jones"));
        // Smith should not
        System.out.println("Numbers for Smith "
                + contactList.lookupEntry("Smith"));
        contactList.removeEntry("Jones");
        // Jones should no longer be in the list
        System.out.println("Numbers for Jones "
                + contactList.lookupEntry("Jones"));
        /*</exercise>*/
    }
}
/*</listing>*/
