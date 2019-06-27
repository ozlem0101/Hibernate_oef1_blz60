package be.intecbrussel;


import be.intecbrussel.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SavePerson {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Person p = new Person();
        em.persist(p);
        tx.commit();
        emf.close();

        }

        private static byte[] getPictureFromUrl(String location){
        Path p = Paths.get(location);
        byte[] bytes = new byte[0];
        try {
            bytes= Files.readAllBytes(p);
            /*(FileInputStream fis = new FileInputStream(location)){
                int nextByte=0;
                while ((nextByte = fis.read())!=-1){
                    byteArrayList.add((byte)nextByte);
                }*/

            }catch (IOException e){
            e.printStackTrace();
        } return bytes;
        }
}


