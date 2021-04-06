package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "workstations")
public class Workstation extends AbstractComputer {

    @Column(name = "disk_size")
    private int diskSize;

    public Workstation() {
    }

    @JsonCreator
    public Workstation(
            @JsonProperty("ip") String ip,
            @JsonProperty("name") String name,
            @JsonProperty("createDate") Date createdDate,
            @JsonProperty("isWork") Boolean isWork,
            @JsonProperty("Repository") Repository repository,
            @JsonProperty("os") String os,
            @JsonProperty("diskSize") int diskSize) {
        super(ip, name, createdDate, isWork, repository, os);
        this.diskSize = diskSize;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    @Override
    public String toString() {
        return "Workstation{" +
                super.toString() +
                "diskSize=" + diskSize +
                '}';
    }
}
