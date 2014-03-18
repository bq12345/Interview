package org.bq.annotation;

//import static org.junit.Assert.*;

import java.lang.reflect.Method;
import org.junit.Test;

public class MyAnnotationUseTest {

	@Test
	public void test() {
		try {
			Class<?> test=Class.forName("org.bq.annotation.MyAnnotationUse");
			Method[] methods=test.getMethods();
			boolean flag=test.isAnnotationPresent(MyAnnotation.class);
			if(flag){
				MyAnnotation ma=(MyAnnotation) test.getAnnotation(MyAnnotation.class);
				System.out.println(ma.hello());
				System.out.println(ma.world());
			}
			for(Method m:methods){
				if(m.isAnnotationPresent(MyAnnotation.class)){
					MyAnnotation my=(MyAnnotation)m.getAnnotation(MyAnnotation.class);
					System.out.println("-------In Methods------");
					System.out.println(my.hello());
					System.out.println(my.world());
					Color color = my.color();
					switch (color) {
					case BLANK:
						System.out.println(color);
						break;
					case RED:
						System.out.println(color);
						break;
					case GREEN:
						System.out.println(color);
						break;
					case YELLOW:
						System.out.println(color);
						break;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}

}
