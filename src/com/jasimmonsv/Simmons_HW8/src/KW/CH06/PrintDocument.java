package KW.CH06;

/** A class for a print document.
 *  @author Koffman and Wolfgang
 */
public class PrintDocument implements Comparable<PrintDocument> {

    public int getSize() {
        return 0;
    }

    public int getTimeStamp() {
        return 0;
    }

    @Override
    public int compareTo(PrintDocument other) {
        return -1;
    }
}
