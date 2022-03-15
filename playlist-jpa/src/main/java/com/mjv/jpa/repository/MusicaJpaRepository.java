package com.mjv.jpa.repository;

import com.mjv.jpa.model.Musica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
