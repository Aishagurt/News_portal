package shop.entities;

public class Users {
    Long id;
    String email;
    String password;
    String fullName;
    String role_id;
    public Users(){
    }

    public Users(Long id, String email, String password, String fullName, String role_id) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role_id = role_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
}
