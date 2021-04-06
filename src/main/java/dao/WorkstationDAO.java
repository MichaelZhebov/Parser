package dao;

import com.sun.istack.NotNull;
import model.Workstation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class WorkstationDAO implements DAO<Workstation, String> {

    private final SessionFactory factory;

    public WorkstationDAO() {
        this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(@NotNull Workstation workstation) {
        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            session.persist(workstation);
            session.getTransaction().commit();

        }
    }

    @Override
    public void createList(List<Workstation> workstations) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            for (int i = 0; i < workstations.size(); i++) {
                session.merge(workstations.get(i));
                if (i % 20 == 0) {
                    session.flush();
                    session.clear();
                }
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public Workstation read(String id) {
        try (Session session = factory.openSession()) {
            return session.get(Workstation.class, id);
        }
    }

    @Override
    public void update(Workstation workstation) {
        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            session.update(workstation);
            session.getTransaction().commit();

        }
    }

    @Override
    public void delete(Workstation workstation) {
        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            session.delete(workstation);
            session.getTransaction().commit();

        }
    }

    @Override
    public List<Workstation> getAll() {
        try (final Session session = factory.openSession()) {

            return session.createQuery("FROM Workstation").list();

        }
    }
}
