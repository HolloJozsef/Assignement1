package entities;

import javax.persistence.*;

@Entity
@Table(name="request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcerere")
    private int idcerere;
    @Column(name="tip")
    private String requestType;
    @Column(name="idcasa")
    private int idcasa;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public int getIdcasa() {
        return idcasa;
    }

    public void setIdcasa(int idcasa) {
        this.idcasa = idcasa;
    }

    public Request(String requestType, int idcasa) {
        this.requestType = requestType;
        this.idcasa = idcasa;
    }
    public Request(String requestType, int idcasa,int idcerere) {
        this.requestType = requestType;
        this.idcasa = idcasa;
        this.idcerere=idcerere;
    }
    public int getIdcerere() {
        return idcerere;
    }

    public void setIdcerere(int idcerere) {
        this.idcerere = idcerere;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestType='" + requestType + '\'' +
                ", idcasa=" + idcasa +
                '}';
    }

    public Request() {
    }
}
