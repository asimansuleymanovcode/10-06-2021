package az.code.springdata.configs;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers( "/students/admin").hasRole("ADMIN")
                .antMatchers("/students/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/students/any").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String pass1 = passwordEncoder().encode("user");
//        String pass2 = passwordEncoder().encode("admin");
//        System.out.println(pass1 + " " + pass2);
//
//                auth.inMemoryAuthentication().withUser("user")
//                .password(pass1)
//                .roles("USER");
//        auth.inMemoryAuthentication().withUser("admin")
//                .password(pass2)
//                .roles("ADMIN");
//
//    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
