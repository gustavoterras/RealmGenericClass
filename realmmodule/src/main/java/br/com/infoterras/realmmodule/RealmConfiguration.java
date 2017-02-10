package br.com.infoterras.realmmodule;

import android.content.Context;

import io.realm.Realm;

/**
 * Created by Gustavo on 10/02/2017.
 */

public class RealmConfiguration {

    private static RealmConfiguration instance = null;

    private RealmConfiguration(){}

    public synchronized static RealmConfiguration getInstance() {
        if (instance == null)
            instance = new RealmConfiguration();

        return instance;
    }

    public void init(Context context, long schemaVersion, EntityMigration entityMigration){
        Realm.init(context);
        io.realm.RealmConfiguration config = new io.realm.RealmConfiguration.Builder()
                .schemaVersion(schemaVersion)
                //.migration(entityMigration)
                .build();

        Realm.setDefaultConfiguration(config);
    }
}
