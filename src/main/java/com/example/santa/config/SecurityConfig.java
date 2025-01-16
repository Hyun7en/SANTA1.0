package com.example.santa.config;

import com.example.santa.login.vo.UserDetailsVO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // 로그인 및 정적 리소스 허용
                        .requestMatchers("/login", "/login/**", "/css/**", "/js/**", "/images/**", "/assets2/**", "/register", "/find/**", "/api/login", "/user", "/submit", "/register/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        // 관리자만 접근 가능
                        .requestMatchers("/admin/**").hasAuthority("ROLE_root")

                        // 관리자와 일반 사용자 모두 접근 가능
                        .requestMatchers("/home/**", "/outgoing/**", "/transit/**", "/inventory/**", "/order/**", "/board/**", "/incoming/**", "/notice/**", "/reply/**", "/profile/**").hasAnyAuthority("ROLE_root", "ROLE_general")

                        // 기타 모든 요청은 인증 필요
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화
                .formLogin().disable() // 기본 로그인 비활성화
                .logout().disable() // 기본 로그아웃 비활성화
                .addFilterBefore(sessionAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // 세션 기반 인증 필터 추가

        return http.build();
    }

    @Bean
    public OncePerRequestFilter sessionAuthenticationFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    Object user = session.getAttribute("userDetails");
                    if (user != null && user instanceof UserDetailsVO) {
                        UserDetailsVO userDetails = (UserDetailsVO) user;

                        // 디버깅: 사용자 정보 확인
                        System.out.println("User ID: " + userDetails.getUserId());
                        System.out.println("User Role: " + userDetails.getRole());

                        // ROLE_ 접두사 추가
                        List<SimpleGrantedAuthority> authorities = Collections.singletonList(
                                new SimpleGrantedAuthority("ROLE_" + userDetails.getRole())
                        );

                        // Spring Security 인증 컨텍스트 설정
                        UsernamePasswordAuthenticationToken auth =
                                new UsernamePasswordAuthenticationToken(userDetails, null, authorities);

                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
                filterChain.doFilter(request, response);
            }
        };
    }
}
