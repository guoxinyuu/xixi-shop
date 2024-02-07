
package com.gxy.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ResourceConfigBean rcb;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().startsWith("win")) {
            registry.addResourceHandler(rcb.getPattern())
                    .addResourceLocations(ResourceUtils.FILE_URL_PREFIX + rcb.getWindowLocal());
        } else {
            registry.addResourceHandler(rcb.getPattern())
                    .addResourceLocations(ResourceUtils.FILE_URL_PREFIX + rcb.getLinuxLocal());
        }
    }
}
