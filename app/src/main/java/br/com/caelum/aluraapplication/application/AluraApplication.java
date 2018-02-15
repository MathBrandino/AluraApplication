package br.com.caelum.aluraapplication.application;

import android.app.Application;

import br.com.caelum.aluraapplication.dagger.AluraComponent;
import br.com.caelum.aluraapplication.dagger.DaggerAluraComponent;

/**
 * Created by matheusbrandino on 2/14/18.
 */

public class AluraApplication extends Application {

    private static AluraApplication instance;

    private AluraComponent component;


    public static AluraApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        this.component = DaggerAluraComponent.create();

    }

    public AluraComponent getComponent() {
        return component;
    }
}
