//=========== ANNOTATION BASED CONFIGURATION =========


//package net.javaguides.springannotations.service;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
////We use @Primary annotation to give higher preference to
////a bean when there are multiple beans of the same type
////It is an alternative to @Qualifier annotation
////@Primary //annotation based configuration
//@Component //annotation based configuration
//public class VegPizza implements Pizza{
//	
//	@Override
//	public String getPizza() {
//		return "Veg Pizza!";
//	}
//
//}

//================== JAVA BASED CONFIGURATION ===========================

package net.javaguides.springannotations.service;

public class VegPizza implements Pizza{
	
	@Override
	public String getPizza() {
		return "Veg Pizza!";
	}

}
