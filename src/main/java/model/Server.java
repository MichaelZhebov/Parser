package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "servers")
public class Server extends AbstractComputer {

    @Column(name = "code_name")
    private String codeName;

    public Server() {
    }

    @JsonCreator
    public Server(
            @JsonProperty("ip") String ip,
            @JsonProperty("name") String name,
            @JsonProperty("createDate") Date createdDate,
            @JsonProperty("isWork") Boolean isWork,
            @JsonProperty("Repository") Repository repository,
            @JsonProperty("os") String os,
            @JsonProperty("codeName") String codeName) {
        super(ip, name, createdDate, isWork, repository, os);
        this.codeName = codeName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public String toString() {
        return "Server{" +
                super.toString() +
                "codeName='" + codeName + '\'' +
                '}';
    }
}
