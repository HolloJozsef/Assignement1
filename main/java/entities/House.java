package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="house")

public class House {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name= "idadresa",nullable = false)

        private int idadresa;
         @Column(name= "idproprietar")
         private int idclient;

        @Column(name="adresa")

        private String adresa;
        @OneToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "house_request",
                joinColumns = @JoinColumn(name = "adresa"),
                inverseJoinColumns = @JoinColumn(name = "tip"))
        private Set<Request> cereri=new HashSet<Request>();

    public Set<Request> getCereri() {
        return cereri;
    }

    public void setCereri(Set<Request> cereri) {
        this.cereri = cereri;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    @Override
    public String toString() {
        return "House{" +
                "idadresa=" + idadresa +
                ", idclient=" + idclient +
                ", adresa='" + adresa + '\'' +
                ", cereri=" + cereri +
                '}';
    }

    public House(String adresa,User user, Set<Request> cereri) {
        this.idclient=user.getId();
        this.adresa = adresa;
        this.cereri = cereri;
    }

    public String getAdresa() {
            return adresa;
        }

        public void setAdresa(String adresa) {
            this.adresa = adresa;
        }

        public House(String adresa,User user) {
            this.adresa = adresa;
            this.idclient=user.getId();
        }

        public House() {
        }

}

