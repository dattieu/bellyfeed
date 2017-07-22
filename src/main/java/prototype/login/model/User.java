package prototype.login.model;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = { "person", "top" })
public class User {

	@Id
	private Name dn;

}
