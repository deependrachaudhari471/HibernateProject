package in.com.prestige.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
	int value();
}

// applying Annotations
class Hello {
	@MyAnnotation(value = 10)
	public void sayHello() {
		System.out.println("Hello Annotation");
	}
}

// Accessing Annotation
public class CustomAnnotation {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
     Hello h = new Hello();
     Method m = h.getClass().getMethod("sayHello");
     MyAnnotation m1 = m.getAnnotation(MyAnnotation.class);
     System.out.println(m1.value());
	}
}
