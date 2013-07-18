/*<listing chapter="6" number="8">*/
package KW.CH06;

import java.util.Comparator;

/**
 * Class to compare PrintDocuments based on both
 * their size and time stamp.
 * @author Koffman and Wolfgang
 */
public class ComparePrintDocuments
        implements Comparator<PrintDocument> {

    /** Weight factor for size. */
    private static final double P1 = 0.8;
    /** Weight factor for time. */
    private static final double P2 = 0.2;

    /**
     * Compare two PrintDocuments.
     * @param left The left-hand side of the comparison
     * @param right The right-hand side of the comparison
     * @return -1 if left &lt; right; 0 if left == right;
     *         and +1 if left &gt; right
     */
    @Override
    public int compare(PrintDocument left, PrintDocument right) {
        return Double.compare(orderValue(left), orderValue(right));
    }

    /**
     * Compute the order value for a print document.
     * @param pd The PrintDocument
     * @return The order value based on the size and time stamp
     */
    private double orderValue(PrintDocument pd) {
        return P1 * pd.getSize() + P2 * pd.getTimeStamp();
    }
}
/*</listing>*/
