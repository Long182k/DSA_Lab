package sorting;

import java.util.Comparator;

public class StraightSelectionSort<E> implements ISort<E> {
	
	private boolean ascending = true;
	
	public StraightSelectionSort() {
	}
	
	public StraightSelectionSort(boolean asc) {
		ascending = asc;
	}
	
	@Override
	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}
	
	public boolean isAscendingSorting() {
		return ascending;
	}

	@Override
	public void sort(E[] array, Comparator<E> comparator) {
        int current, smallest, walker;
        
        current = 0; 
        while(current < array.length - 1){
            smallest = current;
            walker = current + 1;
            while(walker < array.length){
                if(ascending && comparator.compare(array[smallest],  array[walker]) > 0 ||
                		!ascending && comparator.compare(array[smallest],  array[walker]) < 0){
                    smallest = walker;
                }
                walker += 1;
            }
            if(smallest != current){
                //swap:
                E temp = array[smallest];
                array[smallest] = array[current];
                array[current] = temp;
            }
            current += 1;
        }
	}

}
