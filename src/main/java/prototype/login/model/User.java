package prototype.login.model;

import java.io.Serializable;

import javax.naming.Name;

import org.apache.directory.shared.ldap.util.HashCodeBuilder;
import org.apache.directory.shared.ldap.util.ToStringBuilder;
import org.apache.directory.shared.ldap.util.ToStringStyle;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = {"inetOrgPerson", "organizationalPerson", "person", "top"})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Name dn;
	
	@Attribute(name = "uid")
	@DnAttribute(value = "uid", index = 1)
	private String uid;
	
	@Attribute(name = "cn")
	private String fullName;
	
	@Attribute(name = "sn")
	private String lastName;
	
	@Attribute(name = "userPassword")
	private String password;

	public Name getDn() {
		return dn;
	}

	public void setDn(Name dn) {
		this.dn = dn;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
