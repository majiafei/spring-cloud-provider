<<<<<<< HEAD
package org.giveu.springcloud.mjf.provider.config.beetl;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web 配置类
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:03:32
 */
@Configuration
public class BeetlConfig {

	
	@Value("${spring.mvc.view.prefix}")
	private String prefix;
	
    /**
     * beetl的配置
     */
    @Bean(initMethod = "init")
    public BeetlGroupUtilConfiguration beetlConfiguration() {
    	BeetlGroupUtilConfiguration beetlConfiguration = new BeetlGroupUtilConfiguration();
        beetlConfiguration.setResourceLoader(new ClasspathResourceLoader(BeetlConfig.class.getClassLoader(), prefix));
        //beetlConfiguration.setConfigProperties(beetlProperties.getProperties());
        return beetlConfiguration;
    }

    /**
     * beetl的视图解析器
     */
    @Bean
    public BeetlSpringViewResolver beetlViewResolver() {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setConfig(beetlConfiguration());
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        return beetlSpringViewResolver;
    }
}
=======
package org.giveu.springcloud.mjf.provider.config.beetl;

import java.io.IOException;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

@Configuration
public class BeetlConfig {

	@Value("${spring.mvc.view.prefix}")
	private String prefix;

//	@Bean(initMethod = "init")
//	public BeetlGroupUtilConfiguration beetlGroupUtilConfiguration() {
//		BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
//		beetlGroupUtilConfiguration
//				.setResourceLoader(new ClasspathResourceLoader(BeetlConfig.class.getClassLoader(), prefix));
//		return beetlGroupUtilConfiguration;
//	}
//
//	/**
//	 * beetl的视图解析器
//	 */
//	@Bean
//	public BeetlSpringViewResolver beetlViewResolver() {
//		BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
//		beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration());
//		beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
//		beetlSpringViewResolver.setOrder(0);
//		return beetlSpringViewResolver;
//	}
	
	
	@Bean(initMethod = "init")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        try {
            // WebAppResourceLoader 配置root路径是关键
            WebAppResourceLoader webAppResourceLoader =
                    new WebAppResourceLoader(patternResolver.getResource("classpath:/").getFile().getPath());
            beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取配置文件信息
        return beetlGroupUtilConfiguration;
    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver() {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setPrefix("WEB-INF/view/");
        beetlSpringViewResolver.setSuffix(".html");
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(getBeetlGroupUtilConfiguration());
        return beetlSpringViewResolver;
    }

}
>>>>>>> branch 'dev' of https://github.com/majiafei/spring-cloud-provider.git
