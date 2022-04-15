package com.example.ProjetoIntegradorBackEnd.security;

import com.example.ProjetoIntegradorBackEnd.service.DetalheUsuarioServiceimpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@AllArgsConstructor
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

    private final DetalheUsuarioServiceimpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/usuario").permitAll()
//                .antMatchers(HttpMethod.GET, "/usuario").permitAll()
                .antMatchers(HttpMethod.GET, "/produto").permitAll()
                .antMatchers(HttpMethod.GET, "/produto/id/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/imagem").permitAll()
                .antMatchers(HttpMethod.GET, "/imagem/produto/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/categoria").permitAll()
                .antMatchers(HttpMethod.GET, "/cidade").permitAll()
                .antMatchers(HttpMethod.GET, "/reserva/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/detalhes").permitAll()
                .antMatchers(HttpMethod.GET, "/reserva").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAutenticarFilter(authenticationManager()))
                .addFilter(new JWTValidarFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    CorsConfigurationSource corsConfiguration() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;

    }

}
