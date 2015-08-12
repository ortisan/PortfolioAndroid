package br.com.ortiz.portfolio.model;

/**
 * Created by 56789 on 12/08/2015.
 */
public class Motor {

    private int rpm;

    public Motor() {
    }

    public void accelerate(int value) {
        this.rpm += value;
    }

    public void brake() {
        this.rpm = 0;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }
}
