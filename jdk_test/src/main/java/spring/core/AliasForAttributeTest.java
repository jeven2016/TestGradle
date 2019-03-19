package spring.core;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Map;
import org.junit.Test;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.GetMapping;

public class AliasForAttributeTest {

  @MyConfig(path = "/myPath")
  public void myAnnotatedMethod() {

  }

  @Test
  public void test1() throws NoSuchMethodException {
    Method method = MyConfig.class.getMethod("path");
    Annotation annotation = AnnotationUtils
        .findAnnotation(method, AliasFor.class);

    Map<String, Object> map = AnnotationUtils.getAnnotationAttributes(annotation);
    map.entrySet().forEach(action -> {
      System.out.println(action.getKey() + "=" + action.getValue());
    });
  }

}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface MyConfig {

  @AliasFor(annotation = GetMapping.class)
  String[] path() default {};

}



