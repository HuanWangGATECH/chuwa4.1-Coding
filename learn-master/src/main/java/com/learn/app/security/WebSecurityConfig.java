//package com.learn.app.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Resource
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    private LearnControllerAuthEntryPoint authenticationEntryPoint;
//
//    @Autowired
//    private DataSource dataSource;
//
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////
////        http.authorizeRequests()
////                .antMatchers("/addEmployee","/h2-console/**/**","/resources/**","/employee/**","/token/**").permitAll()
////     //            .antMatchers("/employee/**").authenticated().and().httpBasic().and().authorizeRequests()
////                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
////            //    .rememberMe().tokenRepository(persistentTokenRepository()).userDetailsService(userDetailsService);
////            //   .rememberMe().userDetailsService(userDetailsService);
////
////        http.csrf().disable();
////        http.headers().frameOptions().disable();
////
////      //  http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
////
////
////    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////
////        http.authorizeRequests()
////                .antMatchers("/addEmployee","/h2-console/**/**","/resources/**","/employee/**","/token/**").permitAll()
////                .anyRequest().authenticated().and().formLogin().and().authorizeRequests()
////                        .and().rememberMe().userDetailsService(userDetailsService);
////
////        http.csrf().disable();
////        http.headers().frameOptions().disable();
////
////    }
//
//    /**
//     * version 1 with simple form based login
//     *
//     **/
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/addEmployee","/h2-console/**/**","/resources/**","/token/**").permitAll()
//                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().permitAll()
//                .and().rememberMe().userDetailsService(userDetailsService);
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        return daoAuthenticationProvider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//        db.setDataSource(dataSource);
//        return db;
//    }
//
//    @Bean
//    public JWTBasedAuthFilter authenticationJwtTokenFilter() {
//        return new JWTBasedAuthFilter();
//    }
//
//}
