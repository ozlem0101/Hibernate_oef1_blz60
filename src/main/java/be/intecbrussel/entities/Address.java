package be.intecbrussel.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

    @Embeddable
    public class Address {
        @Column(name="STREET")
        private String street;
        @Column(name="NUMBER")
        private String number;
        @Column(name="ZIPCODE")
        private String zipcode;
        @Column(name="CITY")
        private String city;
        @Column(name="COUNTRY")
        private String country;


        public Address(){

        }

        public Address(String street, String number, String zipcode, String city, String country) {
            this.street = street;
            this.number = number;
            this.zipcode = zipcode;
            this.city = city;
            this.country = country;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }


    }

