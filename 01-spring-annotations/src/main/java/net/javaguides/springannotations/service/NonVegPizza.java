//================== ANNOTATION BASED CONFIGURATION ===========================

//package net.javaguides.springannotations.service;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//@Primary //annotation based configuration
//@Component //annotation based configuration
//public class NonVegPizza implements Pizza {
//	
//	@Override
//	public String getPizza() {
//		return "Non-Veg Pizza!";
//	}
//
//}

//================== JAVA BASED CONFIGURATION ===========================

package net.javaguides.springannotations.service;

public class NonVegPizza implements Pizza {
	
	@Override
	public String getPizza() {
		return "Non-Veg Pizza!";
	}

}

