package sorting;

import java.util.Comparator;

public class StraightInsertionSort<E> implements ISort<E>{
	
	private boolean ascending = true;
	
	public StraightInsertionSort() {
	}
	
	public StraightInsertionSort(boolean asc) {
		ascending = asc;
	}
	
	@Override
	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}
	
	public boolean isAscendingSorting() {
		return ascending;
	}
	
	/* Method: sort (straight insertion sort)
	 * Objective: sorting an array of generic type E with a comparator using straight insertion
	 * 
	 * --1) Space Complexity: O(1)
	 * 	Since the array belongs to the outside, not the method
	 *  If we count the array in space complexity, then it will be O(n)
	 * 
	 * --2) Computational Complexity: O(n^2)
	 *  We have 2 nested while loops:
	 *  When current = 1, the inner loop runs at most 1 times
	 *  			   2                              2
	 *  		       N                              N times
	 *  In total: N(N + 1) / 2 -> O(n^2)
	 */

	@Override
	public void sort(E[] array, Comparator<E> comparator) {
		int current, walker;
		E temp;
		current = 1;
		while(current < array.length) {
			temp = array[current];
			walker = current - 1;
			while((walker >= 0) && !(ascending && comparator.compare(temp,  array[walker]) > 0 ||
            		!ascending && comparator.compare(temp,  array[walker]) < 0)) {
				array[walker + 1] = array[walker];
				walker -= 1;
			}
			array[walker + 1] = temp;
			current += 1;
		}
	} 

}
