package heapsort;

public class HeapSort 
{
	/** Helper method to print an array */
	public static <AnyType> void printArray(AnyType[] array)
	{
		System.out.print("[");

		for (int i=0 ; i<array.length ; i++)
			System.out.print(array[i]+" ");

		System.out.println("]");    
	}

	/** Transpose entries at i and j in an array */
	public static <AnyType> void swapReferences(AnyType[] array, int i, int j)
	{
		AnyType tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/** Heap sort method. Modifies array so that it is in sorted order */
	public static <AnyType extends Comparable<? super AnyType>>
	void heapSort(AnyType[] array)
	{
		// Build Heap
		for (int i=array.length/2 - 1; i>=0 ; i-- )
		{
			percDown(array, i, array.length);
		}

		//printArray(array);

		for (int i=array.length-1 ; i>0 ; i-- )
		{
			swapReferences( array, 0, i ); // deleteMax
			percDown( array, 0, i); // Maintain heap ordering property
		}

	}

	/** Percolate down method. The object to be percolated is at
	 *  array[hole], and the current heap size (number of elements in
	 *  the heap) is given. */
	public static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType[] array, int hole, int size)
	{
		int child;
		AnyType tmp = array[hole];

		for( ; hole * 2 + 1 < size; hole = child ) {
			child = hole * 2 + 1;
			if( child != size - 1 && array[child + 1].compareTo( array[ child ] ) > 0 ) 
				child++;
			if( array[ child ].compareTo( tmp ) > 0 )
				array[ hole ] = array[ child ];
			else
				break;
		}
		array[ hole ] = tmp;
	}


	/** Test driver method. */
	public static void main(String[] args)
	{
		Integer array[] = new Integer[31];

		for (int i=0 ; i<array.length ; i++)
			array[i] = (int)(100*Math.random());

		System.out.println("Before: ");
		printArray(array);

		heapSort(array);

		System.out.println("After:");
		printArray(array);
	}


}
