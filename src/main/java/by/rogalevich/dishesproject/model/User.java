package by.rogalevich.dishesproject.model;

import javax.persistence.*;

@Entity// This tells Hibernate to make a table out of this class
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String password;
    private Boolean role;
    private String email;


    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Userr author;

    public String GetAuthorName(){
        return author!=null ? author.getUsername():"<none>";
    }

    public Userr getAuthor() {
        return author;
    }

    public void setAuthor(Userr author) {
        this.author = author;
    }*/

    public User() {
    }

    public User(String name, String password, Boolean role, String email) {
        this.name=name;
        this.password=password;
        this.role=role;
        this.email=email;

        //this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
