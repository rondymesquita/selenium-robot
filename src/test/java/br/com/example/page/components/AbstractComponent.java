package br.com.example.page.components;

import br.com.example.driver.AbstractDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public abstract class AbstractComponent {

    protected AbstractDriver driver;

    public AbstractComponent(AbstractDriver driver) {
        this.driver = driver;
    }
}
