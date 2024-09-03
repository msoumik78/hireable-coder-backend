package org.example.dao;

import org.example.model.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataHolder {

    public static Map<String, Person> stringPersonMap;

    static {
      stringPersonMap = new ConcurrentHashMap();
      stringPersonMap.put("Peter", new Person("Peter", 45, "India"));
      stringPersonMap.put("Dany", new Person("Dany", 28, "USA"));
    }
}
