package prototype.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

// FIXME Some error with LDAP schema! Need to have deep understanding about Directory Database
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest().fullyAuthenticated()
				.and()
			.formLogin();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=people") // equivalent with .userSearchBase("ou=people").userSearchFilter("(uid={0})")
				.groupSearchBase("ou=groups")
				.groupSearchFilter("member={0}")
				.contextSource(contextSource())
				.passwordCompare()
					.passwordEncoder(new LdapShaPasswordEncoder())
					.passwordAttribute("userPassword");
	}

	@Bean
	public DefaultSpringSecurityContextSource contextSource() {
		return  new DefaultSpringSecurityContextSource(Arrays.asList("ldap://localhost:8389/"), "dc=bellyfeed,dc=org");
	}

}
