package br.com.ortiz.portfolio.model;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 56789 on 12/08/2015.
 */

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {
    Vehicle provideVehicle();
}
