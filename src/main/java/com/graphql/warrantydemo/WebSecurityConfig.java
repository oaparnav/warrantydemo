/*
 * package com.graphql.warrantydemo;
 * 
 * import static org.springframework.security.oauth2.jwt.JwtClaimNames.AUD;
 * 
 * import java.util.Arrays; import java.util.Collection; import
 * java.util.stream.Collectors;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.annotation.Order; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.oauth2.core.OAuth2Error; import
 * org.springframework.security.oauth2.jwt.Jwt; import
 * org.springframework.security.oauth2.jwt.JwtDecoder; import
 * org.springframework.security.oauth2.jwt.JwtValidationException; import
 * org.springframework.security.oauth2.server.resource.authentication.
 * JwtAuthenticationToken;
 * 
 * import net.minidev.json.JSONArray;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Configuration
 * 
 * @Order(10) public static class ResourceServerSecurityConfiguration extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Value("${resourceId}") String audience;
 * 
 * @Autowired JwtDecoder jwtDecoder;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * JwtDecoder newJwtDecoder = wrapJwtDecoderWithAudienceCheck(this.jwtDecoder,
 * audience);
 * 
 * http .csrf().disable() .requestMatcher((request) -> {
 * 
 * return request.getRequestURI().contains("/graphql"); }) .authorizeRequests()
 * .requestMatchers((request) -> true).hasAuthority("msl.warrantycoverage")
 * .anyRequest().authenticated() .and() .sessionManagement()
 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS) .and()
 * .oauth2ResourceServer() .jwt() .decoder(newJwtDecoder)
 * .jwtAuthenticationConverter((jwt) -> { Collection<? extends GrantedAuthority>
 * authorities =
 * Arrays.stream(((JSONArray)jwt.getClaims().get("roles")).toArray(new
 * String[0])).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
 * return new JwtAuthenticationToken(jwt, authorities); }); }
 * 
 * static JwtDecoder wrapJwtDecoderWithAudienceCheck(JwtDecoder jwtDecoder,
 * String audience) { return (token) -> { Jwt jwt = jwtDecoder.decode(token); if
 * (jwt.containsClaim(AUD) && !jwt.getClaimAsStringList(AUD).contains(audience))
 * { throw new JwtValidationException("Audience field does not match: " +
 * audience, Arrays.asList(new OAuth2Error("invalid_aud"))); } return jwt; }; }
 * 
 * } }
 */