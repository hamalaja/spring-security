package vn.hamalaja.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfigCustomize sẽ thực hiện các action sau:
 * <p>
 * <ul>
 * <li>Cho phép full access các đường dẫn /css/***, /index
 * <li>Yêu cầu xác thực cho URL bắt đầu bằng /user/ với quyền là USER
 * <li>Khi yêu cầu xác thực thì nhảy tới trang login-custom
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
@EnableWebSecurity
public class SecurityConfigCustomize extends WebSecurityConfigurerAdapter {

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().antMatchers("/css/**",
	// "/index").permitAll().antMatchers("/user/**").hasRole("USER").and().formLogin()
	// .loginPage("/login-custom").permitAll().failureUrl("/login-error").permitAll();
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login-custom").permitAll();
	}


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin").password("123456").roles("USER", "ADMIN");
	}
}
