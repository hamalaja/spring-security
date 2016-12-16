package vn.hamalaja.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * SecurityConfig sẽ thực hiện các action sau:
 * <p>
 * <ul>
 * <li>Yêu cầu xác thực cho mọi URL khi có request.
 * <li>Tự sinh form login.
 * <li>Cho phép user với username và password để xác thực.
 * <li>Cho phép user logout.
 * <li>Ngăn chặn tấn công CSRF.
 * <li>Bảo vệ Session cố định.
 * <li>Tích hợp Security vào Header với nhiều công nghệ.
 * <li>Tích hợp các phương thức Servlet API. <code>
 * <ul>
 * <li>HttpServletRequest#getRemoteUser()
 * <li>HttpServletRequest.html#getUserPrincipal()
 * <li>HttpServletRequest.html#isUserInRole(java.lang.String)
 * <li>HttpServletRequest.html#login(java.lang.String, java.lang.String)
 * <li>HttpServletRequest.html#logout()
 * <li>và nhiều phương thước khác tham khảo http://docs.spring.io/spring-security/site/docs/current/guides/html5//helloworld-javaconfig.html#servlet-api-integration
 * 
 * </ul>
 * </code>
 * <p>
 * </ul>
 * 
 * @author lamhm
 */
//@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin").password("123456").roles("USER", "ADMIN");
	}
}
