package in.com.prestige.test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Creating Custom Annotation
//Meta Annotations
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)//what poitn we have to work
@Target(ElementType.TYPE)
@interface SmartPhone {
	String os();
	int version();

}
@SmartPhone(os="Android",version=6)
class NokiaSeries{
	String model;
	int price;
	
	public NokiaSeries(String model,int price){
		this.model = model;
		this.price = price;
	}
}

public class CustomAnnotation2 {
     public static void main(String[] args) {
    	 NokiaSeries obj = new NokiaSeries("c1-01", 2000);
    	 Class c = obj.getClass();
    	 Annotation an = c.getAnnotation(SmartPhone.class);
    	 SmartPhone s = (SmartPhone)an;
    	 System.out.println(s.os()+"..."+s.version());
    	 
	}
}
