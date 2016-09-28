package com.dicoding.realmcrudsample;

import io.realm.RealmObject;

/**
 * Created by sidiqpermana on 9/28/16.
 */

public class Person extends RealmObject {
    private String name;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
