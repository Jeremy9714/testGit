package pri.test;
import java.util.*;
public class SetClassDemo {

	public static void main(String[] args) {
		collectionTest();
		System.out.println();
		mapTest();
		System.out.println();
		hybirdTest();
	}
	//创建Map集合存放键值，并使用TreeMap按key值顺序输出元素
	public static void hybirdTest() {
		Map<String, String> map = new HashMap<>();
		Emp emp1 = new Emp("351","小李");
		Emp emp2 = new Emp("512","小王");
		Emp emp3 = new Emp("853","小张");
		Emp emp4 = new Emp("125","小刘");
		Emp emp5 = new Emp("341","小赵");
		map.put(emp1.getId(), emp1.getName());
		map.put(emp2.getId(), emp2.getName());
		map.put(emp3.getId(), emp3.getName());
		map.put(emp4.getId(), emp4.getName());
		map.put(emp5.getId(), emp5.getName());
				
		TreeMap<String,String> treemap = new TreeMap<>();
		treemap.putAll(map);
		Iterator<String> it = treemap.keySet().iterator();
		
		while(it.hasNext()) {
			String id = it.next();
			String name = treemap.get(id);
			System.out.printf("id为: %s, 姓名为: %s \n",id,name);
		}
	}
	//TreeMap的应用
	public static void mapTest() {
		Map<String,String> map = new HashMap<>();
		map.put("01", "小李");
		map.put("02", "小王");
		Set<String> set = map.keySet();
		Collection<String> collection = map.values();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		it = collection.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println(map.get("01"));
		System.out.println(map.containsKey("02"));
		System.out.println(map.containsValue("小刘"));
	}
	//Collection集合和List、Set的应用
	public static void collectionTest() {
		Collection<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.remove("b");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println((String)it.next());//迭代器的next()方法返回的是对象
		}
		System.out.println(list.size());
		System.out.println();
		
		List<String> list2 = new ArrayList<String>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		int i = (int) (Math.random()*list2.size());
		System.out.println(i);
		System.out.println(list2.get(i));
		System.out.println();
		
		UpdateStu stu1 = new UpdateStu("小李",10);
		UpdateStu stu2 = new UpdateStu("小王",11);
		UpdateStu stu3 = new UpdateStu("小张",12);
		UpdateStu stu4 = new UpdateStu("小刘",13);
		TreeSet<UpdateStu> tree = new TreeSet<UpdateStu>();
		tree.add(stu1);
		tree.add(stu2);
		tree.add(stu3);
		tree.add(stu4);
		Iterator<UpdateStu> it2 = tree.iterator();
		while(it2.hasNext()) {
			UpdateStu st = (UpdateStu) it2.next();
			System.out.printf("元素ID: %d, 元素名: %s \n",st.id,st.name);
		}
		System.out.println();
		it2 = tree.headSet(stu2).iterator();
		it2 = tree.subSet(stu2,stu4).iterator();
		while(it2.hasNext()) {
			UpdateStu st = (UpdateStu) it2.next();
			System.out.printf("元素ID: %d, 元素名: %s \n",st.id,st.name);
		}
		System.out.println(tree.comparator());//若set使用的是自然顺序，则返回null
	}
}

class Emp{
	private String id;
	private String name;
	public Emp(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class UpdateStu implements Comparable<Object>{//Compareble接口中的compareTo()方法为比较器
	String name;
	int id;
	public UpdateStu(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public int compareTo(Object o) {
		UpdateStu upstu = (UpdateStu) o;
		int result = id>upstu.id?1:(id==upstu.id?0:-1);
		return result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}