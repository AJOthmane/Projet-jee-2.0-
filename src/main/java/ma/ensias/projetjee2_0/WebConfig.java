package ma.ensias.projetjee2_0;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:9000","https://shipit-spring.web.app")
                .allowCredentials(true)
                .allowedMethods("PUT", "GET", "POST", "DELETE", "OPTION", "PATCH");
    }
}