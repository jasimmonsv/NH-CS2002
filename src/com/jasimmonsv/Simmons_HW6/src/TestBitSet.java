import java.util.Random;

public class TestBitSet
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BitSet bs1 = new BitSet();
		BitSet bs2 = new BitSet();

		Random r = new Random();

		for (int i = 0; i < 10; i++)
		{
			bs1.add(r.nextInt(100));
			bs2.add(r.nextInt(100));
		}

		TextIO.putln("bs1: " + bs1);
		TextIO.putln("bs2: " + bs2);
		TextIO.putln();

		TextIO.putln("bs1 intersection bs2: " + bs1.intersection(bs2));
		TextIO.putln();

		TextIO.putln("bs1-bs2: " + bs1.difference(bs2));
		TextIO.putln("bs2-bs1: " + bs2.difference(bs1));

		TextIO.putln("bs1 union bs2: " + bs1.union(bs2));

	}

}
