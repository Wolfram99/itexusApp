package ru.itexus.main.Models;

import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class User implements Serializable, ObjectInputValidation {
    private String firstName;
    private String lastName;
    private String email;
    private List<String> listRoles;
    private List<String> listPhones;

    public User(){
        this.listRoles = new ArrayList<>();
        this.listPhones = new ArrayList<>();
    }

    public User(String firstName, String lastName, String email, List<String> listRoles, List<String> listPhones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.listRoles = listRoles;
        this.listPhones = listPhones;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getListRoles() {
        return listRoles;
    }

    public void setListRoles(List<String> listRoles) {
        this.listRoles = listRoles;
    }

    public List<String> getListPhones() {
        return listPhones;
    }

    public void setListPhones(List<String> listPhones) {
        this.listPhones = listPhones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, listPhones, listRoles);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(listPhones, other.listPhones) && Objects.equals(listRoles, other.listRoles);
    }

    @Override
    public String toString() {
        return "User -> " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", listRoles=" + listRoles +
                ", listPhones=" + listPhones;
    }


    @Override
    public void validateObject() throws InvalidObjectException {
        if(listRoles.size()>3 || listPhones.size()>3 ){
            throw new InvalidObjectException("Некорректное количство записей!");
        }
    }

}









//======================================================================================
//public class User implements Serializable, ObjectInputValidation {
//    private Long id;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private List<String> listRoles;
//    private List<String> listPhones;
//
//    public User(){}
//
//    public User(Long id,String firstName, String lastName, String email, List<String> listRoles, List<String> listPhones) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.listRoles = listRoles;
//        this.listPhones = listPhones;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public List<String> getListRoles() {
//        return listRoles;
//    }
//
//    public void setListRoles(List<String> listRoles) {
//        this.listRoles = listRoles;
//    }
//
//    public List<String> getListPhones() {
//        return listPhones;
//    }
//
//    public void setListPhones(List<String> listPhones) {
//        this.listPhones = listPhones;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return id.equals(user.id) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && listRoles.equals(user.listRoles) && listPhones.equals(user.listPhones);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, firstName, lastName, email, listRoles, listPhones);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", listRoles=" + listRoles +
//                ", listPhones=" + listPhones +
//                '}';
//    }
//
//
//    @Override
//    public void validateObject() throws InvalidObjectException {
//        if(listRoles.size()>3 || listPhones.size()>3 ){
//            throw new InvalidObjectException("Некорректное количство записей!");
//        }
//    }
//}
