public class Credentials {
    private String email, password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return new String("Email: " + email + "\n" +
                "Password: " + password + "\n");
    }
}
