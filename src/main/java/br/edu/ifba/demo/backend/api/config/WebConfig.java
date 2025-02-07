package br.edu.ifba.demo.backend.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") 
                .allowedOrigins("http://localhost:8080") // url por onde o frontend acessa o backend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // aq são os métodos q o front pode acessar
                .allowedHeaders("*") 
                .allowCredentials(true); 
    }
}
