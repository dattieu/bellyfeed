package prototype.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;

@Configuration
public class LoginConfig {

	@Bean
	public LdapTemplate ldapTemplate() {
		return new LdapTemplate();
	}
	
}
