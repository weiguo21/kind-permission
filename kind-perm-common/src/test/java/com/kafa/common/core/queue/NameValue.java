/**
 * Project Name:kafa-common-base
 * File Name:NameValue.java
 * Package Name:com.kafa.test.queue
 * Date:2016年7月25日下午6:19:34
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kafa.common.core.queue;

import java.io.Serializable;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Function:测试优先队列. <br/>
 * Date: 2016年7月25日 下午6:19:34 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class NameValue implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int value;

	public NameValue(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "NameValue [name=" + name + ", value=" + value + "]";
	}

	public static void main(String[] args) {
		Comparator<NameValue> orderNameValue = new Comparator<NameValue>() {

			@Override
			public int compare(NameValue o1, NameValue o2) {
				int numbera = o1.getValue();
				int numberb = o2.getValue();
				if (numberb > numbera) {
					return 1;
				} else if (numberb < numbera) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		Queue<NameValue> priorityQueue = new PriorityQueue<NameValue>(11, orderNameValue);

		NameValue t1 = new NameValue("t1", 1);
		NameValue t3 = new NameValue("t3", 3);
		NameValue t2 = new NameValue("t2", 2);
		NameValue t4 = new NameValue("t4", 0);
		priorityQueue.add(t1);
		priorityQueue.add(t3);
		priorityQueue.add(t2);
		priorityQueue.add(t4);
		System.out.println(priorityQueue.poll().toString());
	}

}
