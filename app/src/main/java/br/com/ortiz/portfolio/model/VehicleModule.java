package br.com.ortiz.portfolio.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 56789 on 12/08/2015.
 */

@Module
public class VehicleModule {
    @Provides
    @Singleton
    Motor provideMotor() {
        return new Motor();
    }

    @Provides
    @Singleton
    Vehicle provideVehicle(Motor motor) {
        return new Vehicle(motor);
    }
}
