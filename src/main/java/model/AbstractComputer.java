package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractComputer {

    @Id
    private String ip;
    @Column(name = "name")
    private String name;
    @Column(name = "create_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
    private Date createDate;
    @Column(name = "is_work")
    private Boolean isWork;
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "repository_id")
    private Repository repository;
    @Column(name = "os")
    private String os;

    public AbstractComputer(String ip, String name, Date createDate, Boolean isWork, Repository repository, String os) {
        this.ip = ip;
        this.name = name;
        this.createDate = createDate;
        this.isWork = isWork;
        this.repository = repository;
        this.os = os;
    }

    public AbstractComputer() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getWork() {
        return isWork;
    }

    public void setWork(Boolean work) {
        isWork = work;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", isWork=" + isWork +
                ", repository=" + repository +
                ", os='" + os + '\'' +
                '}';
    }
}
