package com.realmexample;

import android.app.Application;

import br.com.infoterras.realmmodule.EntityMigration;
import br.com.infoterras.realmmodule.RealmConfiguration;

/**
 * Created by Gustavo on 10/02/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration.getInstance().init(this, 0, new EntityMigration());

    }
}
