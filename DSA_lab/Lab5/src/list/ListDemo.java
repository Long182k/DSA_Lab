package list;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
	public static void demo(List<String> list){
		for(int idx=0; idx < 10; idx++){
			list.add("" + idx);
		}
		
		//(1)Print elements - Use Index, travel forward
		System.out.printf("%-32s", "Go forward, use index:");
		for(int idx=0; idx < list.size(); idx++){
			System.out.printf("%s ", list.get(idx));
		}
		System.out.println();
		
		//(2)Print elements - Use Index, travel backward
		System.out.printf("%-32s", "Go backward, use index:");
		for(int idx=list.size()-1; idx >= 0; idx--){
			System.out.printf("%s ", list.get(idx));
		}
		System.out.println();
		
		//(3)Print elements - Use Iterator, travel forward
		System.out.printf("%-32s", "Go forward, use Iterator:");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String item = it.next();
			System.out.printf("%s ", item);
		}
		System.out.println();
		
		//(4)Print elements - Use ListIterator, travel forward
		System.out.printf("%-32s", "Go forward, use ListIterator:");
		ListIterator<String> fwd = list.listIterator();
		while(fwd.hasNext()){
			String item = fwd.next();
			System.out.printf("%s ", item);
		}
		System.out.println();
		
		//(5)Print elements - Use ListIterator, travel backward
		System.out.printf("%-32s", "Go backward, use ListIterator:");
		try {
			ListIterator<String> bwd = list.listIterator(list.size());
			while(bwd.hasPrevious()){
				String item = bwd.previous();
				System.out.printf("%s ", item);
			}
		} catch (UnsupportedOperationException e) {
			System.out.print("ListIterator does not support");
		}
		System.out.println();
	}
	
	public static void demoModification1(List<Integer> list) {
		list.clear();
		
		//Add elements
		for(int idx=0; idx < 10; idx++){
			list.add(idx);
		}
		
		//(1)Print elements - Use Index, travel forward
		System.out.printf("%-25s", "Before modification:");
		for(int idx=0; idx < list.size(); idx++){
			System.out.printf("%s ", list.get(idx));
		}
		System.out.println();
		
		//(2)Remove odd numbers
		ListIterator<Integer> it = list.listIterator();
		while(it.hasNext()){
			int item = it.next();
			if(item % 2 != 0 ) it.remove();
			else it.set(item*10);
		}
		
		//(3) Print after changing
		System.out.printf("%-25s", "After modification:");
		it = list.listIterator();
		while(it.hasNext()){
			System.out.printf("%s ", it.next());
		}
		System.out.println();
	}
	
	public static void demoModification2(List<Integer> list) {
		list.clear();
		
		// Add elements
		for(int idx=0; idx < 10; idx++){
			list.add(idx);
		}
		
		// 1. Print elements - Use Index, travel forward
		System.out.printf("%-25s", "Before modification:");
		for(int idx=0; idx < list.size(); idx++){
			System.out.printf("%s ", list.get(idx));
		}
		System.out.println();
		
		
		// 2. Remove odd numbers using for-loop
		for(int i = list.size() - 1; i >= 0; i--) {
			if(list.get(i) % 2 == 0)
				list.set(i, list.get(i) * 10);
			else
				list.remove(i);
		}
		
		// 3. Print after changing
		System.out.printf("%-25s", "After modification:");
		for(int i : list) {
			System.out.printf("%s ", i);
		}
		System.out.println();
	}
}
