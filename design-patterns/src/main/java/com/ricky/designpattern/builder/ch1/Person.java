package com.ricky.designpattern.builder.ch1;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-07-06 16:39
 */
public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final int age;
    private final String street;
    private final String district;
    private final String city;
    private final String province;
    private final boolean isFemale;
    private final boolean isEmployed;

    public Person(String firstName, String lastName, String middleName, int age, String street,
                  String district, String city, String province, boolean isFemale, boolean isEmployed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.street = street;
        this.district = district;
        this.city = city;
        this.province = province;
        this.isFemale = isFemale;
        this.isEmployed = isEmployed;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", isFemale=" + isFemale +
                ", isEmployed=" + isEmployed +
                '}';
    }
}
