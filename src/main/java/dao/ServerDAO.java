package dao;

import com.sun.istack.NotNull;
import model.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class ServerDAO implements DAO<Server, String> {

    private final SessionFactory factory;

    public ServerDAO() {
        this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(@NotNull Server server) {
        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            session.persist(server);
            session.getTransaction().commit();

        }
    }

    @Override
    public void createList(List<Server> servers) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            for (int i = 0; i < servers.size(); i++) {
                session.merge(servers.get(i));
                if (i % 20 == 0) {
                    session.flush();
                    session.clear();
                }
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public Server read(String id) {
        try (Session session = factory.openSession()) {
            return session.get(Server.class, id);
        }
    }

    @Override
    public void update(Server server) {
        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            session.update(server);
            session.getTransaction().commit();

        }
    }

    @Override
    public void delete(Server server) {
        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            session.delete(server);
            session.getTransaction().commit();

        }
    }

    @Override
    public List<Server> getAll() {
        try (final Session session = factory.openSession()) {

            return session.createQuery("FROM Server").list();

        }
    }
}
