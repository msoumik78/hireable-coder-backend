package org.example.dao;


import org.example.model.Person;
import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements IDao{
    @Override
    public Person getPersonDetail(String bankCustomerName) {
        return DataHolder.stringPersonMap.get(bankCustomerName);
    }

}
