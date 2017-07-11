package com.mindflow.pattern.builder.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-06 16:41
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
                .create();

        System.out.println(person);
    }
}
