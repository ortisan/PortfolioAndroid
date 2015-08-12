package br.com.ortiz.portfolio.model;

import javax.inject.Inject;

/**
 * Created by 56789 on 12/08/2015.
 */
public class Vehicle {

    private Motor  motor;


    @Inject
    public Vehicle(Motor motor) {
        this.motor = motor;
    }

    public void increaseSpeed(int value) {
        this.motor.accelerate(value);
    }

    public void stop() {
        this.motor.brake();
    }

    public int getSpeed() {
        return motor.getRpm();
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
