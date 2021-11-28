package model;

public class Driver {
    String Name;
    String NIC;
    String LNum;
    String Address;
    String Contact;

    public Driver() {
    }

    public Driver(String name, String NIC, String LNum, String address, String contact) {
        Name = name;
        this.NIC = NIC;
        this.LNum = LNum;
        Address = address;
        Contact = contact;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getLNum() {
        return LNum;
    }

    public void setLNum(String LNum) {
        this.LNum = LNum;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "Name='" + Name + '\'' +
                ", NIC='" + NIC + '\'' +
                ", LNum='" + LNum + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact='" + Contact + '\'' +
                '}';
    }


}
