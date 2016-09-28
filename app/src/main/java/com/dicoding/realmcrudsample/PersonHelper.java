package com.dicoding.realmcrudsample;

import android.content.Context;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by sidiqpermana on 9/28/16.
 */

public class PersonHelper {
    private Realm realm;

    public PersonHelper(){
        realm = Realm.getDefaultInstance();
    }

    public void insert(long id, String name){
        realm.beginTransaction();
        Person person = realm.createObject(Person.class);
        person.setName(name);
        person.setId(id);
        realm.commitTransaction();
    }

    public ArrayList<Person> get(){
        RealmResults<Person> realmQuery = realm.where(Person.class).findAll();
        ArrayList<Person> list = null;
        if (realmQuery != null){
            if(realmQuery.size() > 0){
                list = new ArrayList<>();
                for (Person person : realmQuery){
                    list.add(person);
                }
            }
        }

        return list;
    }

    public void update(long id, String name){
        Person person = realm.where(Person.class).equalTo("id", id).findFirst();
        realm.beginTransaction();
        person.setName(name);
        realm.commitTransaction();
    }

    public void delete(long id){
        Person person = realm.where(Person.class).equalTo("id", id).findFirst();
        realm.beginTransaction();
        person.deleteFromRealm();
        realm.commitTransaction();
    }
}
