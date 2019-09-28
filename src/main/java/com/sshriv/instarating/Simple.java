package com.sshriv.instarating;

import java.util.HashMap;
import java.util.Set;

public class Simple {

	public static void main(String[] args) {
		HashMap<Employee,String> map=new HashMap<Employee,String>();
		Employee obj1=new Employee(1,"Rahul");
		map.put(obj1,"23");
		Set<Employee> res=map.keySet();
		for(Employee e:res){
			System.out.println(e.id);
			System.out.println(e.name);
			System.out.println(map.get(e));
			System.out.println("Employee hascode"+e.hashCode());
		}
	//	obj1.setId(2);
		obj1.setName("Jai");
		map.put(obj1, "25");
		System.out.println("Afters Sette:");
		System.out.println("Size :"+map.size());
		Set<Employee> res1=map.keySet();
		for(Employee e:res1){
			System.out.println(e.id);
			System.out.println(e.name);
			System.out.println(map.get(e));
			System.out.println("Employee hascode"+e.hashCode());
		}
	}

}
