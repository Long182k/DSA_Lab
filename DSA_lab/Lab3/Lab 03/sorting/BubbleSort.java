package sorting;

import java.util.Comparator;

public class BubbleSort<E> implements ISort<E> {
	
	private boolean ascending = true;
	
	public BubbleSort() {
	}
	
	public BubbleSort(boolean asc) {
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
        int current, walker;
        boolean flag;
        
        current = 0; 
        flag = false;
        while((current < array.length-1) && (flag == false)){
            walker = array.length - 1; //start from the last and backward
            flag = true; //for testing if the input already in ascending order
            while(walker > current){
                if(!(ascending && comparator.compare(array[walker],  array[walker-1]) > 0 ||
                		!ascending && comparator.compare(array[walker],  array[walker-1]) < 0)){
                    flag = false;
                    //swap:
                    E temp = array[walker];
                    array[walker] = array[walker-1];
                    array[walker-1] = temp;
                }
                walker -= 1;
            }
            current += 1;
        }
	}
	
}
