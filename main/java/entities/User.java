package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String pass;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name = "house_user",
           joinColumns = @JoinColumn(name = "email"),
           inverseJoinColumns = @JoinColumn(name = "adresa"))

    private Set<House> proprietar=new HashSet<House>();
    public User(String email, String pass,int id) {
        this.email = email;
        this.pass = pass;
        this.id=id;
    }

    public User(int id,String email, String pass, Set<House> proprietar) {
        this.id=id;
        this.email = email;
        this.pass = pass;
        this.proprietar = proprietar;
    }

    public User() {
    }

    public Set<House> getProprietar() {
        return proprietar;
    }

    public void setProprietar(Set<House> proprietar) {
        this.proprietar = proprietar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean addHouse(House h){
        proprietar.add(h);
        return proprietar.contains(h);
    }
    public boolean removeHouse(House h){
        proprietar.remove(h);
        return this.proprietar.remove(h);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", proprietar=" + proprietar +
                '}';
    }
}
