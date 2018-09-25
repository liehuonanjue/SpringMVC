package entin;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    @NotNull(message = "用户名不能为空")
    @Size(min = 4, max = 6, message = "用户名大于四个字节小于6个")
    private String name;
    @NotNull(message = "密码不能为空")
    @Size(min = 4, max = 6, message = "密码大于四个字节小于6个")
    private String pwd;
    @Email(message = "邮箱不正确")
    @NotNull(message = "邮箱不能为空")
    private String email;
    @Pattern(regexp = "^1[13579]\\d{9}$", message = "手机格式不正确")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public User() {
    }

    public User(String name, String pwd, String email, String phone) {

        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.phone = phone;
    }


}
