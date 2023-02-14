package app.model;

public class Location{
    private int id;
    private String name;
    private boolean is_deleted;

    public Location() {
    }

    public Location(int id, String name, boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.is_deleted = is_deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}

