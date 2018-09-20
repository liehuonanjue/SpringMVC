package entin;

public class User {
    private String idd;
    private String nam;
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "idd='" + idd + '\'' +
                ", nam='" + nam + '\'' +
                '}';
    }

    public User(String idd, String nam) {

        this.idd = idd;
        this.nam = nam;
    }

    public String getIdd() {

        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

}
