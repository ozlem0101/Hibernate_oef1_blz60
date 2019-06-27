package be.intecbrussel.music;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class MusicApp {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();
        Album album = new Album();
        album.setAuthor("Igorrr");
        album.setTitle("Savage Sinusoid");
        ArrayList<String> tracks = new ArrayList<>();
        tracks.add("Cheval");
        tracks.add("viande");
        tracks.add("ieuD");
        tracks.add("Opus Brain");
        album.setTracks(tracks);
        EntityTransaction tx =em.getTransaction();
        tx.begin();
        em.persist(album);
        tx.commit();
        emf.close();
    }


}
