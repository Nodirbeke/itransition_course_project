package itransition.intern.itransitioncollection.configuration.security;

import itransition.intern.itransitioncollection.service.authUser.AuthUserService;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    public static final String[] SECURED_URLS = {
            "/auth/create",
            "/auth/list",
            "/auth/getAll",
            "/auth/update/**",
            "/auth/block/**",
            "/auth/unblock/**",
            "/auth/delete/**",
            "/auth/get/**",
            "/auth/detail/**",

            "/collection/create",
            "/collection/update/**",
            "/collection/delete/**",

            "/item/create",
            "/item/update/**",
            "/item/delete/**",

            "/comment/create",
            "/comment/update/**",
            "/comment/delete/**",

            "/like/create",
            "/like/delete/**",
    };
    public static final String[] WHITE_LIST_RESOURCES = {
            "/css/**", "/webjars/**", "/js/**", "/error", "/images/**"
    };
    private final AuthUserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .antMatchers(SecurityConfigurer.SECURED_URLS).authenticated()
                                .anyRequest().permitAll())

                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer
                                .loginPage("/auth/login")
                                .defaultSuccessUrl("/home/", false)
                                .loginProcessingUrl("/auth/login"))

                .rememberMe(httpSecurityRememberMeConfigurer -> {
                    httpSecurityRememberMeConfigurer
                            .rememberMeParameter("remember-me");})

                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/auth/logout")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .deleteCookies("JSESSIONID", "remember-me"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) {
        web.
                ignoring().antMatchers(WHITE_LIST_RESOURCES);
    }

}
