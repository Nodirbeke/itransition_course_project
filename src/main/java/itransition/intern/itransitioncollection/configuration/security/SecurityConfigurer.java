package itransition.intern.itransitioncollection.configuration.security;

import itransition.intern.itransitioncollection.service.authUser.AuthUserService;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfigurer {
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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .antMatchers(SecurityConfigurer.SECURED_URLS).authenticated()
                                .anyRequest().permitAll())

                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer
                                .loginPage("/auth/login")
                                .failureForwardUrl("/error/error")
                                .defaultSuccessUrl("/home", true)
                                .loginProcessingUrl("/auth/login"))

                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/auth/logout")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                                .invalidateHttpSession(true)
                                .clearAuthentication(true));
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers(WHITE_LIST_RESOURCES);
    }

}
