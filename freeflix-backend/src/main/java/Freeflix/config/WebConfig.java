package Freeflix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
			.allowedHeaders("*");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Serve HLS playlists from either src/main/resources/static/hls or from an external folder
		registry.addResourceHandler("/hls/**")
			.addResourceLocations("file:./src/main/resources/static/hls/", "classpath:/static/hls/");
	}
}
