package be.intecbrussel;

import be.intecbrussel.entities.Address;
import be.intecbrussel.entities.GenderType;
import be.intecbrussel.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.time.LocalDate;

public class PersonApp {
    public static void main(String[] args) {


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
        tx.begin();
    Person p = new Person();

        p.setBirthday(LocalDate.of(2000,1,1));
        p.setFirstName("Jesus");
        p.setLastName("from Nazareth");
        p.setGender(GenderType.MAN);
        p.setMarried(false);
        p.setComment("Superstar");
        p.setHomepage("www.google.com");
        p.setPicture(getPictureFromUrl("C://jesusstuff/Jesus.jpg"));
        p.setAddress(new Address("heartstreet","3","1000","Brussel","no country"));

        em.persist(p);
        tx.commit();
        emf.close();
}

private static byte[] getPictureFromUrl(String location) {
    Path p = Paths.get(location);
    byte[] bytes = new byte[0];
    try {
        bytes = Files.readAllBytes(p);
    }catch (Exception e){
        e.printStackTrace();
    }
/*    ArrayList<Byte> byteArrayList = new ArrayList<>();
    byte[] picture = null;

        try (FileInputStream fis = new FileInputStream(location)){
            int nextByte = 0;
            while ((nextByte = fis.read()) != -1) {

                byteArrayList.add((byte)nextByte);
            }
           //byteArrayList.stream().toArray((Byte s)->s.byteValue());
            picture = new byte[byteArrayList.size()];
            for(int i = 0; i<byteArrayList.stream().toArray().length;i++){
                picture[i]=byteArrayList.get(i);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
*/        return bytes;

//byte[] bytes = new byte[0]
}
}
