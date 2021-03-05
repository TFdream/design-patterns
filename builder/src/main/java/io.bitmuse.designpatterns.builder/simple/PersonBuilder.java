package io.bitmuse.designpatterns.builder.simple;

/**
 * @author Ricky Fung
 */
public class PersonBuilder {
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private String street;
    private String district;
    private String city;
    private String province;
    private boolean isFemale;
    private boolean isEmployed;

    public PersonBuilder(){
    }

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }
    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }
    public PersonBuilder street(String street) {
        this.street = street;
        return this;
    }

    public PersonBuilder district(String district) {
        this.district = district;
        return this;
    }

    public PersonBuilder city(String city) {
        this.city = city;
        return this;
    }

    public PersonBuilder province(String province) {
        this.province = province;
        return this;
    }

    public PersonBuilder isFemale(boolean isFemale) {
        this.isFemale = isFemale;
        return this;
    }

    public PersonBuilder isEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
        return this;
    }

    public Person build() {
        return new Person(firstName, lastName, middleName, age, street, district, city, province, isFemale, isEmployed);
    }
}