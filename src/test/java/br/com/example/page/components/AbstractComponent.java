package br.com.example.page.components;

import br.com.example.driver.RobotDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public abstract class AbstractComponent {

    protected RobotDriver driver;

    public AbstractComponent(RobotDriver driver) {
        this.driver = driver;
    }
}
