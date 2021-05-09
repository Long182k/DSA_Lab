package sorting;

import java.util.Comparator;

public class ShellSort<E> implements ISort<E> {
	
	private boolean ascending = true;
	private int[] num_segment;
	
	public ShellSort(int[] num_segment, boolean asc){
		this(num_segment);
		this.ascending = asc;
	}
	
	public ShellSort(int[] num_segment){
		this.num_segment = num_segment;
	}
	
	public ShellSort() {
		this(new int[] {1, 3, 7});
	}
	
	public ShellSort(boolean asc) {
		this();
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
        for(int k=num_segment.length - 1; k > 0; k--){
            for(int segment_idx = 0; segment_idx < k; segment_idx++)
                sort_segment(array, segment_idx, k, comparator);
        }
	}
	
	private void sort_segment(E[] array, int segment_idx, int num_segment, Comparator<E> comparator){
        int current;
        int walker;
        E temp;
        current = segment_idx + num_segment;
        while(current < array.length){
            temp = array[current];
            walker = current - num_segment;
            while((walker >= 0) && !(ascending && comparator.compare(temp,  array[walker]) > 0 ||
            		!ascending && comparator.compare(temp,  array[walker]) < 0)){
            	array[walker + num_segment] = array[walker]; //shift to right
                walker -= num_segment;
            }
            array[walker + num_segment] = temp;
            current += num_segment;
        }
    }

}
