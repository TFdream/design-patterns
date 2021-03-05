package io.bitmuse.designpatterns.builder;

import io.bitmuse.designpatterns.builder.simple.Person;
import io.bitmuse.designpatterns.builder.simple.PersonBuilder;

/**
 * @author Ricky Fung
 */
public class PersonBuilderDemo {

    public static void main(String[] args){

        Person person = new PersonBuilder()
                .firstName("ricky")
                .lastName("fung")
                .age(27)
                .street("建国路")
                .district("朝阳")
                .city("北京市")
                .province("北京")
                .isFemale(false)
                .isEmployed(true)
                .build();

        System.out.println(person);
    }
}