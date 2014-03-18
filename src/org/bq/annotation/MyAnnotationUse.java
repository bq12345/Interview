package org.bq.annotation;

/**
 * @author °×Ç¿
 * @version 1.0
 */
@MyAnnotation(hello="nihao",world="wyj")

public class MyAnnotationUse {
	@MyAnnotation(hello="nihao",world="wyj",color=Color.GREEN)
	
	public void output(){
		System.out.println("hhhh");
	}
}
