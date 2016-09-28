package com.dicoding.realmcrudsample;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by sidiqpermana on 9/28/16.
 */

public class RealmApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
