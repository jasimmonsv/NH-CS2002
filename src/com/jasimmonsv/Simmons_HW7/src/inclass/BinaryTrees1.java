package inclass;

public class BinaryTrees1
{

	public static void main(String[] args)
	{

	}

}

class BTree<T>
{
	TNode<T> root;
	
	public BTree ()
	{
		
	}
	
}

class TNode<T>
{
	T data;
	
	TNode<T> left;
	TNode<T> right;
	
	public TNode (T data)
	{
		this.data = data;
	}
}
