package com.liu.sourceProject.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liu
 * @Date 2020/8/29 9:43
 */
public class Java8StreamList {
	public static void main(String[] args) {

		List<Long> list1 = new ArrayList<>();
		list1.add(1L);
		list1.add(123L);
		list1.add(234L);
		list1.add(345L);
		list1.add(123L);
		list1.add(123435L);

		List<Long> list2 = new ArrayList<>();
		list2.add(1L);
		list2.add(123L);
		list2.add(234L);
		list2.add(345L);
		list2.add(123435L);

		List<User> userList1 = new ArrayList<>();
		userList1.add(new User("liu", 11));
		userList1.add(new User("wei", 12));
		userList1.add(new User("ben", 13));
		userList1.add(new User("liuben", 14));

		List<User> userList2 = new ArrayList<>();
		userList2.add(new User("liu", 11));
		userList2.add(new User("wei", 12));
		userList2.add(new User("ben", 13));
		userList2.add(new User("liuben", 15));
		userList2.add(new User("liubenwei", 16));


		List<Long> collect = Stream.concat(list1.stream(), list2.stream())
				.distinct().collect(Collectors.toList());
		System.out.println("long :" + collect);

		List<User> userList = Stream
				.concat(userList1.stream(), userList2.stream()).distinct()
				.collect(Collectors.toList());
		System.out.println("userList:" + userList);

	}
}

class User {
	private String name;
	private Integer age;

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
