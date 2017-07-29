package prototype.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Repository;

import prototype.login.model.User;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.ldap.LdapName;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private final LdapTemplate ldapTemplate;

	@Autowired
	public UserDaoImpl(LdapTemplate ldapTemplate) {
		super();
		this.ldapTemplate = ldapTemplate;
	}

	@Override
	public boolean authenticate(String base, String username, String password) {
		// TODO
		return false;
	}
	
	@Override
	public void create(User user) {
		ldapTemplate.create(user);
	}

	@Override
	public void update(User user) {
		ldapTemplate.update(user);
	}

	@Override
	public void delete(User user) {
		ldapTemplate.delete(ldapTemplate.findByDn(buildDn(user), User.class));
	}

	@Override
	public List<String> getAllUserNames() {
		return ldapTemplate.search(query().attributes("cn").where("objectclass").is("person"), new AttributesMapper<String>() {
								public String mapFromAttributes(Attributes attrs) throws NamingException {
									return attrs.get("cn").get().toString();
								}
        		});
	}

	@Override
	public List<User> getAll() {
		return ldapTemplate.findAll(User.class);
	}

	private LdapName buildDn(User user) {
		return buildDn(user.getFullName());
	}

	private LdapName buildDn(String fullname) {
		return LdapNameBuilder.newInstance()
				.add("cn", fullname)
				.build();
	}
	
}
