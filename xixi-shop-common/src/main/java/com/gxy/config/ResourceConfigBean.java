
package com.gxy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResourceConfigBean {
    @Value("${spring.resource.path}")
    private String path;
    @Value("${spring.resource.path.pattern}")
    private String pattern;
    @Value("${spring.resource.folder.windows}")
    private String windowLocal;
    @Value("${spring.resource.folder.linux}")
    private String LinuxLocal;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getWindowLocal() {
        return windowLocal;
    }

    public void setWindowLocal(String windowLocal) {
        this.windowLocal = windowLocal;
    }

    public String getLinuxLocal() {
        return LinuxLocal;
    }

    public void setLinuxLocal(String linuxLocal) {
        LinuxLocal = linuxLocal;
    }
}
