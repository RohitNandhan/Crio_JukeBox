package com.crio.old.jukebox.entites;

public class User extends BaseEntity {
    private String name;


    public User(String id,String name) {
        super(id);
        this.name=name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ""+id+" "+name;
    }
}
