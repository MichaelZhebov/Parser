package dao;

import java.util.List;

public interface DAO<Entity, Key> {

    void create(Entity entity);
    void createList(List<Entity> entityList);
    Entity read(Key id);
    void update(Entity entity);
    void delete(Entity entity);
    List<Entity> getAll();

}
