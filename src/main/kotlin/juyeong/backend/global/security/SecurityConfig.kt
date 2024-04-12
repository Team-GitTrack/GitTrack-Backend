package juyeong.backend.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import juyeong.backend.global.config.FilterConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy.STATELESS
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig(
    private val objectMapper: ObjectMapper,
) {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf().disable()
            .formLogin().disable()
            .cors()

            .and()
            .sessionManagement()
            .sessionCreationPolicy(STATELESS)
            .and().oauth2Login()

            .and()
            .authorizeHttpRequests()
            .antMatchers("/**").permitAll()
            .anyRequest().permitAll()

            .and().apply(FilterConfig(objectMapper))
            .and().build()
    }
}
