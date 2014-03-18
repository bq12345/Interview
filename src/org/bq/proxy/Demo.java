package org.bq.proxy;

import java.lang.reflect.Proxy;

public class Demo {
	public static void main(String[] args) {
		ActionDo ad = new ActionDo();
		ActionHandle ah = new ActionHandle(ad);
		Action action = (Action) Proxy.newProxyInstance(ad.getClass()
				.getClassLoader(), ad.getClass().getInterfaces(), ah);
		action.execute("I'm BaiQiang");
	}
}
