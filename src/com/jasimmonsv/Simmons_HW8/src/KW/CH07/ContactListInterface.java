package KW.CH07;

import java.util.List;

/** The interface for the telephone directory.
 *  @author Koffman & Wolfgang
 */
public interface ContactListInterface {

    /**
     * Add an entry or change an existing entry.
     * @param name The name of the person being added or changed
     * @param numbers The new number to be assigned
     * @return The old list of numbers or null if this is a new entry
     */
    List<String> addOrChangeEntry(String name, List<String> newNumbers);

    /**
     * Look up an entry.
     * @param name The name of the person to look up
     * @return The number or null if name is not in the directory
     */
    List<String> lookupEntry(String name);

    /**
     * Remove an entry from the directory.
     * @param name The name of the person to be removed
     * @return The current number. If not in directory, null is
     *         returned
     */
    List<String> removeEntry(String name);

    /** Dislays the contact list in order by name. */
    void display();
}
