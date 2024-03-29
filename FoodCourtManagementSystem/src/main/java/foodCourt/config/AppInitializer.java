package foodCourt.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppSecurityConfig.class, AppConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
