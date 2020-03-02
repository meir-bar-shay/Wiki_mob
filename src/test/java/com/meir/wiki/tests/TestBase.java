package com.meir.wiki.tests;

import com.meir.wiki.manager.ApplicationManager;
import com.meir.wiki.utils.Listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Arrays;

@Listeners(Listener.class)

public class TestBase {

    public static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTestLog(Method m, Object[] parameter) {
        logger.info("Start test " + m.getName() + "with parameters" + Arrays.asList(parameter));
    }

    @AfterMethod
    public void stopTestLog(Method m)
    {
        logger.info("Stop test " + m.getName());
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        app.init();

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        app.stop();
    }

}
