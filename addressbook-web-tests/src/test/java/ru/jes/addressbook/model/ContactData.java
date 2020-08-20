package ru.jes.addressbook.model;

public class ContactData {

    //коммит для задания №9
    private int id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String phone;

    //коммит для задания №9
    public ContactData(int id, String firstname, String lastname, String email, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;

    }

    //коммит для задания №9
    public ContactData(String firstname, String lastname, String email, String phone) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        //коммит для задания №9
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
    //коммит для задания №9
    public String getFirstname() {
        return firstname;
    }
    //коммит для задания №9
    public String getLastname() {
        return lastname;
    }
    //коммит для задания №9
    public String getEmail() {
        return email;
    }
    //коммит для задания №9
    public String getPhone() {
        return phone;
    }
    //коммит для задания №9
    public int getId() {
        return id;
    }
    //коммит для задания №9
    public void setId(int id) {
        this.id = id;
    }

    @Override
    //коммит для задания №9
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';

    }//коммит для задания №9

    @Override
    //коммит для задания №9
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //коммит для задания №9
        ContactData that = (ContactData) o;
        //коммит для задания №9
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }   //коммит для задания №9

    @Override
    //коммит для задания №9
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }//коммит для задания №9

}
