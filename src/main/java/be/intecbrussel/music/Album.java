package be.intecbrussel.music;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
    public class Album{
        @Id
        private long id;
        private String title;
        private String author;

        @ElementCollection
        private List<String> tracks = new ArrayList<>();


        public Album(long id, String title, String author, List<String> tracks) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.tracks = tracks;
        }

        public Album() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }


        public void setAuthor(String author) {
            this.author = author;
        }

        public List<String> getTracks() {
            return tracks;
        }

        public void setTracks(List<String> tracks) {
            this.tracks = tracks;
        }
    }




