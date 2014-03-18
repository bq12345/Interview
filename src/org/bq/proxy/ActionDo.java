package org.bq.proxy;

public class ActionDo implements Action{
	@Override
	public void execute(String s){
		System.out.println("Do in real method!!!   "+s);
	}
}
