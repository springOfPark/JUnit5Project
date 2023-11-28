package me.ktpark.javaTest.levelOne.extension;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;


public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private long THRESHOLD;

    public FindSlowTestExtension(long THRESHOLD) {
        this.THRESHOLD = THRESHOLD;
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {

        String testClassName = extensionContext.getRequiredTestClass().getName();
        String testMethodName = extensionContext.getRequiredTestMethod().getName();

        ExtensionContext.Store store = extensionContext.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
        store.put("START_TIME", System.currentTimeMillis());

    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {

        String testClassName = extensionContext.getRequiredTestClass().getName();
        String testMethodName = extensionContext.getRequiredTestMethod().getName();

        Method requiredTestMethod = extensionContext.getRequiredTestMethod();
        SpringBootTest annotation = requiredTestMethod.getAnnotation(SpringBootTest.class);

        ExtensionContext.Store store = extensionContext.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
        long startTime = store.remove("START_TIME", long.class);
        long duration = System.currentTimeMillis() - startTime;
        if (duration > THRESHOLD && annotation != null) {
            System.out.println("이 메소드를 slowTest 로 사용해주세요. 좀 느린 것 같습니다.");
        }

    }

}
