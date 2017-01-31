package com.realmexample.dao;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by Gustavo on 31/01/2017.
 */

public class DataManager<S extends RealmModel> {

    public DataManager() {}

    public long getNextId(Class<S> clazz){
        Realm instance = Realm.getDefaultInstance();
        return instance.where(clazz).count() != 0 ? instance.where(clazz).max("id").intValue() + 1 : 1;
    }

    public void save(S realmObject) {
        Realm instance = Realm.getDefaultInstance();
        instance.beginTransaction();
        instance.insertOrUpdate(realmObject);
        instance.commitTransaction();
        instance.close();
    }

    public RealmResults<S> selectAll(Class<S> clazz) {
        Realm instance = Realm.getDefaultInstance();
        return instance.where(clazz).findAll();
    }

    public RealmResults<S> selectEqualsTo(Class<S> clazz, String args1, String args2) {
        Realm instance = Realm.getDefaultInstance();
        return instance.where(clazz).equalTo(args1, args2).findAll();
    }

    public RealmResults<S> selectLessThan(Class<S> clazz, String args1, int args2) {
        Realm instance = Realm.getDefaultInstance();
        return instance.where(clazz).lessThan(args1, args2).findAll();
    }

    public RealmResults<S> selectGreaterThan(Class<S> clazz, String args1, int args2) {
        Realm instance = Realm.getDefaultInstance();
        return instance.where(clazz).greaterThan(args1, args2).findAll();
    }

    public S selectById(long id, Class<S> clazz) {
        Realm instance = Realm.getDefaultInstance();
        return instance.where(clazz).equalTo("id", id).findFirst();
    }
}
