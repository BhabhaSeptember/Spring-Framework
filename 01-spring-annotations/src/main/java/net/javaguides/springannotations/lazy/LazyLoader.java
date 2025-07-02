package net.javaguides.springannotations.lazy;

import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Component;

//NOTES: 
//By default, Spring creates all singleton beans eagerly
//at the startup/bootstrapping of the application context
//We can load the Spring beans lazily(on-demand) using
//the @Lazy annotation
//@Lazy annotation can be used with @Configuration,
//@Component and @Bean annotations
//Eager initialization is recommended: to avoid and 
//detect all possible errors immediately rather than
//at runtime
@Component
@Lazy
public class LazyLoader {

	public LazyLoader() {
		System.out.println("LazyLoader...");
	}
}
