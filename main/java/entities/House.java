package entities;

import javax.persistence.*;

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

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdadresa() {
        return idadresa;
    }

    public void setIdadresa(int idadresa) {
        this.idadresa = idadresa;
    }

    @Override
    public String toString() {
        return "House{" +
                "idadresa=" + idadresa +
                ", idclient=" + idclient +
                ", adresa='" + adresa + '\'' +
                '}';
    }

    public String getAdresa() {
            return adresa;
        }

        public void setAdresa(String adresa) {
            this.adresa = adresa;
        }

        public House(String adresa,int idclient,int idadresa) {
            this.adresa = adresa;
            this.idclient=idclient;
            this.idadresa=idadresa;
        }

        public House() {
        }

}

