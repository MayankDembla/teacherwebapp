package com.praadis.teacherapp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;


@Configuration
@Order(1)
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {

    // First Create One Entry Point
    private DigestAuthenticationEntryPoint getDigestEntryPoint(){
        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint() ;
        digestAuthenticationEntryPoint.setRealmName("admin-digest-realm"); // unique Identifier.
        digestAuthenticationEntryPoint.setKey("someDigestKey"); // Key is used to generate the nonce.
        return  digestAuthenticationEntryPoint ;
    }

    // Configuring the Authentication Manager

    // 1. Password Encoder - No Encoding
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
        //  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

   // 2. Configure the Authentication Manager.

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       auth.inMemoryAuthentication()
               .withUser("digestmayank")
               .password(passwordEncoder().encode("digestsecret"))
               .roles("USER")
          .and()
               .withUser("admin")
               .password(passwordEncoder().encode("adminsecret"))
               .roles("ADMIN") ;
   }

  // User Detail Service

  @Bean
  public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean() ;
  }

  // Configuring the User Detail Service Digest Authenticate Filter

    private DigestAuthenticationFilter getDigestAuthenticationFilter() throws Exception {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter() ;

        digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());

        digestAuthenticationFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
        return digestAuthenticationFilter ;
    }

    // Override the Configure Method.

    protected void configure(HttpSecurity http ) throws Exception {

        http.headers().disable().antMatcher("/teacher/admin/**")
                          .addFilter(getDigestAuthenticationFilter())
                          .exceptionHandling()
                          .authenticationEntryPoint(getDigestEntryPoint())
        .and()
                          .authorizeRequests()
                          .antMatchers("/teacher/admin/**")
                          .hasRole("ADMIN");
    }

}
