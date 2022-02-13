package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
				.cors().and().csrf().disable()
//                .addFilterAfter(contentCachingFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilter(UsernamePasswordAuthenticationFilter.class)
//                .addFilter(UsernamePasswordAuthenticationFilter)
                .authorizeRequests()
                .antMatchers("/","/*Icon", "/**/favicon.ico/**","/**icon","/**/*.map/**","/**/*.ttf/**","/**/*.woff/**", "/*.ico", "/*.png", "/*.jpg", "/*.svg", "/**/*.ico/**", "/**/*.png/**", "/**/*.gif/**", "/**/*.svg/**", "/**/*.jpg/**", "/**/*.html/**", "/**/*.css/**", "/**/*.js/**")
                    .permitAll()
                .antMatchers("/login")
                    .permitAll()
                .antMatchers("/userlogin")
                    .permitAll()
                .antMatchers("/userdata")
                    .permitAll()
                .antMatchers("/registration")
                    .permitAll()
//                .antMatchers("/home")
                .antMatchers("/dashboard")
                    .hasAuthority("USER")
                .antMatchers("/newBooking")
                    .hasAuthority("USER")
                .antMatchers("/admin",
                                         "/adminDashboard")
//                    .hasAuthority("ADMIN")
                    .permitAll()
                .antMatchers("/addedParking")
                    .hasAuthority("ADMIN")
                .antMatchers("/worker")
                    .hasAuthority("WORKER")

                /*
                *       change the authority for /removeWorker and /removeParking
                * */
                .antMatchers("/removeParking")
//                    .hasAuthority("ADMIN")
                    .permitAll()
                .antMatchers("/removeWorker")
//                    .hasAuthority("ADMIN")
                    .permitAll()


                .anyRequest()
                    .authenticated()
//                .and()
                .and()
                    .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler)
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                    .logout()
//                    .logoutUrl("/afterLogout")
//                    .logoutSuccessUrl("/login")
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID")
//                    .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))
//                    .permitAll()
//                    .logoutSuccessHandler((request, response, authentication) -> {
//                        response.setStatus(HttpServletResponse.SC_OK);
//                    })
                .and()
                    .httpBasic();

    }
}