package com.mklueh.pi;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 * Created by Marian at 28.03.2022
 */
@ApplicationScoped
public class RaspberryBeanFactory {

    @Produces
    public Context context() {
        return Pi4J.newAutoContext();
    }

    @PreDestroy
    public void shutdown(){
        context().shutdown();
    }

}
