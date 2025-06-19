 package tacos;
 import static org.hamcrest.Matchers.containsString;
 import static 
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 import static 
org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
 import static 
org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 import static 
org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
 import org.junit.jupiter.api.Test;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
 import org.springframework.test.web.servlet.MockMvc;
 
//Annotation arranges for test to run in context of Spring MVC application
// registers HomeController in Spring MVC so requests can be sent to it
 @WebMvcTest(HomeController.class)   
public class HomeControllerTest {
	 
  @Autowired
//MockMvc object injected for test to drive the mockup  
  private MockMvc mockMvc; 
  
  @Test
  public void testHomePage() throws Exception {
//mockMvc object performs an HTTP GET request for "/" root path	  
 mockMvc.perform(get("/"))  
//expects HTTP 200 status 
.andExpect(status().isOk())  
//view should have logical name of 'home'
.andExpect(view().name("home")) 
//rendered view should contain given text
.andExpect(content().string(        
containsString("Welcome to...")));
 
  }
 }