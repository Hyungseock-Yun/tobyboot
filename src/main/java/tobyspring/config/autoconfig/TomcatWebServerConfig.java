//package tobyspring.config.autoconfig;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.*;
//import org.springframework.core.env.Environment;
//import org.springframework.core.type.AnnotatedTypeMetadata;
//import org.springframework.util.ClassUtils;
//import tobyspring.config.ConditionalMyOnClass;
//import tobyspring.config.EnableMyConfigurationProperties;
//import tobyspring.config.MyAutoConfiguration;
//
//@MyAutoConfiguration
//@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
////@Conditional(TomcatWebServerConfig.TomcatCondition.class)
////@Import(ServerProperties.class)
//@EnableMyConfigurationProperties(ServerProperties.class)
//public class TomcatWebServerConfig {
//
////  @Value("${contextPath}")
////  String contextPath;
////
////  @Value("${port}")
////  int port;
//
//  @Bean("tomcatWebServerFactory")
//  @ConditionalOnMissingBean
//  public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
//    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//
//    factory.setContextPath(properties.getContextPath());
//    factory.setPort(properties.getPort());
//
//    return factory;
//  }
//
////  static class TomcatCondition implements Condition {
////    @Override
////    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
////      return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat", context.getClassLoader());
////    }
////  }
//}
