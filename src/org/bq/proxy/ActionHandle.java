package org.bq.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ActionHandle implements InvocationHandler {
	private Object target;

	public ActionHandle(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("start always-------");
		Object obj = method.invoke(target, args);
		System.out.println("end always-------");
		return obj;
	}

}
