package be.intecbrussel.entities;

import be.intecbrussel.entities.GenderType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

@Entity
@Table(name = "PERSONS", indexes = {@Index(name="LAST_NAME_INDEX", columnList = "LAST_NAME"),
@Index(name="BIRTHDAY_INDEX", columnList = "BIRTHDAY")})
@SecondaryTable(name="URLS")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private long id;

    @Version
    @Column(name = "VERSION")
    private long version;
    @Column(name = "FIRST_NAME", length = 40, nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", length = 40, nullable = false)
    private String lastName;
    @Column(name="BIRTHDAY")
    private LocalDate birthday;
    @Column(name="GENDER")
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @Column(name="PICTURE")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;
    @Column(name="COMMNT")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String comment;
    @Column(name="MARRIED", columnDefinition = "BOOLEAN")
    private boolean married;

    @Column(name="HOMEPAGE", table = "URLS")
    private String homepage;

    @Embedded
    private Address address;


    private int age;


    public Person (){

    }

    public Person(long version, String firstName, String lastName, LocalDate birthday, GenderType gender,
                  byte[] picture, String comment, boolean married, String homepage, Address address, int age) {
        this.version = version;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.picture = picture;
        this.comment = comment;
        this.married = married;
        this.homepage = homepage;
        this.address = address;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Transient
    public int getAge() {
        return Period.between(LocalDate.now(),birthday).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", picture=" + Arrays.toString(picture) +
                ", comment='" + comment + '\'' +
                ", married=" + married +
                ", homepage='" + homepage + '\'' +
                ", address=" + address +
                ", age=" + age +
                '}';
    }
}
