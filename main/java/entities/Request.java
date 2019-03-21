package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="request")
public class Request {
    @Id
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
