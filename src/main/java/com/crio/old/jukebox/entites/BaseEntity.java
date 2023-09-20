package com.crio.old.jukebox.entites;

class BaseEntity {
    protected final String id;

    public BaseEntity(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
