package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    private long id;

    public Repository() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                '}';
    }
}
