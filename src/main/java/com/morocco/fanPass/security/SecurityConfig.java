package com.morocco.fanPass.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import java.util.List;
@Configuration //Indique que cette classe définit une configuration Spring.
@EnableWebSecurity //Active Spring Security et permet de personnaliser la sécurité.

public class SecurityConfig {

    /** 1- fonctionnement
     * L'utilisateur (admin/admin123) envoie une requête avec Basic Auth.
     * Spring Security intercepte la requête et l'envoie au AuthenticationManager.
     * Le AuthenticationManager appelle DaoAuthenticationProvider.
     * DaoAuthenticationProvider vérifie l’utilisateur dans UserDetailsService.
     * Spring Security compare le mot de passe encodé avec celui stocké.
     * Si tout est correct → accès autorisé ! Sinon → 401 Unauthorized.
     */
    @Bean //Configuration du filtre de sécurité
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /**  2. Configuration du filtre de sécurité
         * Les API REST sont souvent appelées par des clients externes (Postman, front-end, etc.).
         * CSRF est surtout utile pour les applications web avec des sessions.
         * Pour simplifier les tests, on le désactive.
         * /api/personnes/** et /api/circulaires/** → Nécessitent une authentification.
         * Les autres (anyRequest) → Accès libre.
         */
        http
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF pour tests avec Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/team/delete/**", "/stadium/delete/**").authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(httpBasic -> {}); // Activer Basic Auth
        return http.build();
    }
    /**
     * 3- Activation de l’authentification Basic
     * Permet d’envoyer un username et un password directement dans l'en-tête HTTP.
     * Gestion des utilisateurs en mémoire
     * CustomUserDetailsService
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123")) // Encodage correct du mot de passe
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user); //Stockage en mémoire
    }
    /**
     * 4- BCryptPasswordEncoder est une méthode de hachage sécurisée.
     * Permet à Spring Security de comparer correctement les mots de passe.
     *
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /**
     *
     * 5- Gestion de l'authentification
     * DaoAuthenticationProvider est le composant de Spring Security qui vérifie les identifiants.
     * Utilise UserDetailsService pour récupérer l'utilisateur.
     * Utilise PasswordEncoder pour vérifier le mot de passe.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }
    /** 6. Création du AuthenticationManager
     *AuthenticationManager est responsable de l'authentification des utilisateurs.
     * ProviderManager permet d'utiliser plusieurs stratégies d'authentification.
     * Ici, il utilise DaoAuthenticationProvider.
     *     */
    @Bean
    public AuthenticationManager authenticationManager(DaoAuthenticationProvider authenticationProvider) {
        return new ProviderManager(List.of(authenticationProvider));
    }
}
