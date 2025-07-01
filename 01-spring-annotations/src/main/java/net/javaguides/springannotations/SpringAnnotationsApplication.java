package net.javaguides.springannotations;

import net.javaguides.springannotations.configurationproperties.AppProperties;
import net.javaguides.springannotations.configurationproperties.AppPropertiesDemo;import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringAnnotationsApplication.class, args);

		
		AppPropertiesDemo appPropertiesDemo = context.getBean(AppPropertiesDemo.class);
		appPropertiesDemo.display();
	}

}
