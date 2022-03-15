package com.mjv.jpa.repository;

import com.mjv.jpa.model.Musica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MusicaJpaRepository {

    private EntityManager em;

    public MusicaJpaRepository(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Musicas");
        em = entityManagerFactory.createEntityManager();
    }

    public void save(Musica musica){
        em.getTransaction().begin();
        em.persist(musica);
        em.getTransaction().commit();
    }

    public List<Musica> findAll(String keyword){
        Query query = em.createQuery("SELECT a FROM Musica a WHERE a.artista = :key" +
                    " OR a.album = :key" +
                     " OR a.genero = :key");
        query.setParameter("key", keyword);
        return query.getResultList();

    }
}
