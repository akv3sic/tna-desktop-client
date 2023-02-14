package app.model;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private Object card_id;
    private boolean is_staff;
    private boolean is_superuser;
    private boolean is_deleted;

    public User() {
    }

    public User(int id, String first_name, String last_name, String email, Object card_id, boolean is_staff, boolean is_superuser, boolean is_deleted) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.card_id = card_id;
        this.is_staff = is_staff;
        this.is_superuser = is_superuser;
        this.is_deleted = is_deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getCard_id() {
        return card_id;
    }

    public void setCard_id(Object card_id) {
        this.card_id = card_id;
    }

    public boolean isIs_staff() {
        return is_staff;
    }

    public void setIs_staff(boolean is_staff) {
        this.is_staff = is_staff;
    }

    public boolean isIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(boolean is_superuser) {
        this.is_superuser = is_superuser;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
