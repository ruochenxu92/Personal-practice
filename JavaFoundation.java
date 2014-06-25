package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class JavaFoundation {

	
	public static void main(String[] args) {
		Integer i = 1;//Object variable
		int j = i;   //primitive variable
		
		List list = new ArrayList();
		list.add(1);
		int k = (Integer)list.get(0);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()){
			int m = (Integer) it.next();
		}
	}
	
	
	@Test
	public void test1(){
		List list = new ArrayList();
		list.add("123");
		list.add("456");
		list.add("789");
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	
	
	@Test
	public void test2(){
		Map<String, String> map = new LinkedHashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		
		for(Map.Entry<String, String> me : map.entrySet()){
			System.out.println(me.getKey() +"="+ me.getValue());
		}
		
		for(String me : map.keySet()){
			System.out.println(me + "=" + map.get(me));
		}
		
		for(Object obj : map.entrySet()){
			Map.Entry entry3 = (Entry) obj;
			System.out.println(entry3.getKey() + "=" + entry3.getValue());
		}
	}
	
	
	@Test
	public void test3(){
		int arr[] = { 1, 2, 3 };
		for (int i : arr) {
			i = 10;
		}
		System.out.println(arr[0]); // 1

		List li = new ArrayList();
		li.add("1");
		for (Object obj : li) {
			obj = "888";//not for write
		}
		System.out.println(li.get(0));// 1

	}
	
	@Test
	public void test4(){
		sum(1, 2, 3, 4);
		int arr[] = { 5, 6, 7 };
		sum(arr);
		
		
		
		System.out.println(sum(1,2,3,4,5));
		
	}
	
	public int sum(int ...nums){
		int sum = 0;
		for(int i : nums){
			sum+=i;
		}
		return sum;
	}
	//system will automatically create an array to sum(1,2,3,4,5)
	@Test
	public void bb(){
	
		List list = Arrays.asList("1","2","3");
		System.out.println(list);
		
		
		String[] arr = {"1", "2","3", "1","2","3"};
		list = Arrays.asList(arr);//convert array to list
		System.out.println(list);
		
		Integer[] nums = {1,2,3,4,5};
		list = Arrays.asList(nums);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		//public void aaa(int ... nums, int s) // NO
		//public void bbb(int s, int ...nums) //Yes

	}
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
//	enum Grade{
//		A("100-90"),
//		B("89-80"),
//		C("79-70"),
//		D("69-60"),
//		E("59-0");//object
//		private String value;
//		private Grade(String value){
//			this.value = value;
//		}
//		public String getValue(){
//			return this.value;
//		}	
//		public abstract String localeValue(); 
//	 
//	}
//	
	@Test
	public void demo2(){
		System.out.println((Grade.B));
	
	}
	
	@Test
	public void print(Grade g){
		
	}
}





class Grade {
	private Grade() {
	}

	public static final Grade A = new Grade();
	public static final Grade B = new Grade();
	public static final Grade C = new Grade();
	public static final Grade D = new Grade();
	public static final Grade E = new Grade();
}
