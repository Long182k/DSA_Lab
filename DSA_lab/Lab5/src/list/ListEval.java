package list;

import java.util.List;
import java.util.Random;

public class ListEval {
	
	private static Random r = new Random();
	
	public static double evaluateAccessing(List<Integer> list, int size, int n_tries) {
		list.clear();
		for(int i = 0; i < size; i++)
			list.add(r.nextInt());
		
		double time = 0;
		
		for(int i = 0; i < n_tries; i++) {
			int index = r.nextInt(size);
			long start = System.nanoTime();
			list.get(index);
			long end = System.nanoTime();
			time += (double) (end - start) / (n_tries * 1000000);
		}
		
		return time;
	}
	
	public static double evaluateAddingHead(List<Integer> list, int size, int n_tries) {	
		list.clear();
		double time = 0;
		
		for(int i = 0; i < n_tries; i++) {
			long start = System.nanoTime();
			for(int j = 0; j<size; j++)
				list.add(0, 0);
			long end = System.nanoTime();
			time += (double) (end - start) / (n_tries * 1000000);
			list.clear();
		}
		
		return time;
	}
	
	public static double evaluateAddingTail(List<Integer> list, int size, int n_tries) {	
		list.clear();
		double time = 0;
		
		for(int i = 0; i < n_tries; i++) {
			long start = System.nanoTime();
			for(int j = 0; j<size; j++)
				list.add(0);
			long end = System.nanoTime();
			time += (double) (end - start) / (n_tries * 1000000);
			list.clear();
		}
		
		return time;
	}
}
