package com.mklueh.pi;

import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Created by Marian at 28.03.2022
 */
@Slf4j
@Getter
@ApplicationScoped
public class LightBulb {

    private static final Integer PIN_LED = 7;

    @Inject
    Context context;

    private DigitalOutput light;

    @PostConstruct
    public void init() {
        light = context.create(DigitalOutput.newConfigBuilder(context)
                .id("led")
                .name("LED")
                .address(PIN_LED)
                .shutdown(DigitalState.LOW)
                .initial(DigitalState.LOW)
                .provider("pigpio-digital-output"));

        log.info("Light bulb initialized");
    }

    public void toggle(){
        light.toggle();
    }

    public void on() {
        light.on();
    }

    public void off() {
        light.off();
    }

    public boolean isOn() {
        return light.isOn();
    }


}
