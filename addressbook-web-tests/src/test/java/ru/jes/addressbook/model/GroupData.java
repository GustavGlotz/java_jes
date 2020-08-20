package ru.jes.addressbook.model;

public class GroupData {
    //коммит для задания №9
    private int id;
    private final String name;
    private final String header;
    private final String footer;

    //коммит для задания №9
    public GroupData(String name, String header, String footer) {
        this.id = Integer.MAX_VALUE;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }  //коммит для задания №9

    public GroupData(int id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }  //коммит для задания №9

    public int getId() {
        return id;
    }
    //коммит для задания №9
    public void setId(int id) {
        this.id = id;
    }

    //коммит для задания №9
    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }   //коммит для задания №9

    @Override
         //коммит для задания №9
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //коммит для задания №9
        GroupData groupData = (GroupData) o;

        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }
    //коммит для задания №9
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
    //коммит для задания №9
    public String getName() {
        return name;
    }
    //коммит для задания №9
    public String getHeader() {
        return header;
    }
    //коммит для задания №9
    public String getFooter() {
        return footer;
    }
    //коммит для задания №9
}
