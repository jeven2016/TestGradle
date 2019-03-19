package spring.core;

import static org.springframework.test.util.AssertionErrors.assertTrue;

import java.io.IOException;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class PathMatchingResourcePatternResolverTest {


  @Test
  public void test1() throws IOException {

    shouldExist("classpath*:spring/**/*ResourcePatternResolverTest*.class");
    shouldExist("spring/**/*ResourcePatternResolverTest*.class");
    shouldExist("spring/**/*ResourcePatternResolverTest*");
    shouldExist("/spring/**/*ResourcePatternResolverTest*");
    shouldExist("org/springframework/core/**/ResourcePatternResolver*");

    inExist("spring/*ResourcePatternResolverTest*");
  }

  private void shouldExist(String pattern) throws IOException {
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    Resource[] resources = resolver.getResources(pattern);

    assertTrue("shouldExist", resources.length > 0);
  }

  private void inExist(String pattern) throws IOException {
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    Resource[] resources = resolver.getResources(pattern);

    assertTrue("inExist", resources.length == 0);
  }
}

