In this package you must declare your drivers.
This code is a layer over selenium extending its features. Things you need to do to create a new driver:

1. Create an interface with [DRIVER_NAME]RobotDriver extending RobotDriver and informing driver you want to extend. E.g.
```java
public interface FirefoxRobotDriver extends RobotDriver<FirefoxDriver> {

}
```

2. Create a class implementing this interface and put it inside **impl** package. E.g.
```java
public class FirefoxRobotDriverImpl extends RobotDriverImpl<FirefoxDriver> implements FirefoxRobotDriver {

    public FirefoxRobotDriverImpl() throws InstantiationException, IllegalAccessException {
        super(FirefoxDriver.class);
        driver = new FirefoxDriver();
    }
}
```
### IMPORTANT
**After creating your driver, do not forget to create a new maven profile in pom.xml and put its *driver systemPropertyVariable* with your driver name in lowercase.


You can notice that:
- All drives share the same interface. So RobotDriver is a selenium driver with some custom method that you can add in the future.
- If you look in RobotDriverImpl, all custom methods are declared there. The **waitUntilTextMatches** is not a method from selenium. It exists only in RobotDriver.
For example, with selenium, if you want to wait until some element appears on the page, you need to do:
```java
Webdriver driver = new FirefoxDriver();
WebDriverWait wait = new WebDriverWait(driver, 60);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_button")));
```

But, if you are using RobotDriver. this scenario could be:

```java
RobotDriver driver = Robot.getRobotDriver();
driver.waitUntilVisibilityOfElementLocated((By.id("submit_button"));
```

- This is just an example. You can add more methods as you need.
- You can override any method of your driver.
- Remember: Maybe you want to call **super**, so be attention.
```java
public class SelendroidRobotDriverImpl extends RobotDriverImpl<SelendroidDriver> implements SelendroidRobotDriver {

    private SelendroidLauncher selendroidServer = null;

    /*
        All initialization of this class should be here
     */
    public SelendroidRobotDriverImpl() throws Exception {
        /*
            Remember call super here. It is required.
         */
        super(SelendroidDriver.class);

        SelendroidConfiguration config = new SelendroidConfiguration();
        selendroidServer = new SelendroidLauncher(config);
        selendroidServer.launchSelendroid();

        driver = new SelendroidDriver(new URL("http://0.0.0.0:4444/wd/hub/"), MobileCapabilities.buildToSelendroid());
    }

    @Override
    public void quit() {

        /*
            Remember also call super here if you want
         */
        super.quit();

        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }
    }
}

```
