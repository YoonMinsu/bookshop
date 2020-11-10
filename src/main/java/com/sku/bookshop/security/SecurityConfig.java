package com.sku.bookshop.security;

import com.sku.bookshop.domain.user.Role;
import com.sku.bookshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 정적 자원 시큐리티 설정 적용 안함
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 글 작성과 글 수정은 회원만 가능하다.
                .authorizeRequests()
                .antMatchers("/board/post", "/board/update")
                .hasRole("MEMBER")
                .antMatchers("/**")
                .permitAll()

                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
    }
}
