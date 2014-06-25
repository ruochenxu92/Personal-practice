package generic;

import java.lang.reflect.Field;

import org.junit.Test;

//反射类的字段 
public class reflect {
	// public String name="aaaa";
	@Test
	public void test1() throws Exception {
		Class clazz = Class.forName("generic.Person");
		Field f = clazz.getField("name");
		Person p = new Person();
		Object value = f.get(p);// 获取字段值
		Class type = f.getType();// 字段类型
		System.out.println(type);// class java.lang.String
		if (type.equals(String.class)) {
			String S_value = (String) value;
			System.out.println(S_value);// aaaa
		}

		// 设置值
		f.set(p, "ppppp");
		System.out.println(f.get(p));// ppppp
		System.out.println(String.class);// class java.lang.String
	}

	// private int password;
	@Test
	public void test2() throws Exception {
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Field f = clazz.getDeclaredField("password");
		f.setAccessible(true);
		Person p = new Person();
		f.set(p, 123);
		System.out.println(f.get(p));// 123
	}

	// private static int age=23;
	@Test
	public void test3() throws Exception {
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(null));// 23
	}
}