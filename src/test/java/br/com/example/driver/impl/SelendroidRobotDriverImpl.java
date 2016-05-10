package br.com.example.driver.impl;

import br.com.example.driver.SelendroidRobotDriver;
import br.com.example.mobile.MobileCapabilities;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

import java.net.URL;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class SelendroidRobotDriverImpl extends RobotDriverImpl<SelendroidDriver> implements SelendroidRobotDriver {

    private SelendroidLauncher selendroidServer = null;

    public SelendroidRobotDriverImpl() throws Exception {
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
