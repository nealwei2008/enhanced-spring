package com.yoloho.enhanced.spring;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 新版本的jdk中，测试用例执行时，需要添加 --add-opens java.base/java.util=ALL-UNNAMED
 */
public class MySpringJUnit4ClassRunner extends SpringJUnit4ClassRunner {
    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    public MySpringJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
        environmentVariables.set("ERU_POD", "test");
        environmentVariables.set("ENV_PROP_jdbc_url", "newVal");
        environmentVariables.set("ENV_PROP_jdbc_url__new", "newVal1");
    }

}
