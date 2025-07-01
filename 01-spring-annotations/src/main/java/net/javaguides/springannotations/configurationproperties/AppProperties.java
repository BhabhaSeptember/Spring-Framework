package net.javaguides.springannotations.configurationproperties;

import java.util.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//Annotation allows us to bind configuration properties
//to Java class fields
//i.e.we bind external configurations to a bean in code
//Then that bean can be used throughout the application
//code
@ConfigurationProperties(prefix = "app")
@Component
public class AppProperties {
	
	private String name;
	private String description;
	private String uploadDir;
	private Security security = new Security();
	

	public static class Security {
		
		private String username;
		private String password;
		List<String> roles = new ArrayList<>();
		private boolean enabled;
		Map<String, String> permissions = new HashMap<>();
		
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public List<String> getRoles() {
			return roles;
		}
		
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
		
		public boolean isEnabled() {
			return enabled;
		}
		
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		
		public Map<String, String> getPermissions() {
			return permissions;
		}

		public void setPermissions(Map<String, String> permissions) {
			this.permissions = permissions;
		}

		
		
		
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getUploadDir() {
		return uploadDir;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	
	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}
	
	

}
