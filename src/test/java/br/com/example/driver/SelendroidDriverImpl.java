package br.com.example.driver;

import br.com.example.mobile.MobileCapabilities;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class SelendroidDriverImpl  extends AbstractDriverImpl<SelendroidDriver> implements AbstractSelendroidDriver{

    private SelendroidLauncher selendroidServer = null;

    public SelendroidDriverImpl() throws Exception {
        super(SelendroidDriver.class);

        SelendroidConfiguration config = new SelendroidConfiguration();
        selendroidServer = new SelendroidLauncher(config);
        selendroidServer.launchSelendroid();

        driver = new SelendroidDriver(new URL("http://0.0.0.0:4444/wd/hub/"), MobileCapabilities.buildToSelendroid());
    }

    @Override
    public void quit() {

        super.quit();

        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }
    }
}
