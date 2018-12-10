package Znakov.Practice4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Conductor {
    private List<String> songs=new ArrayList<>();
    private String name;

    public void playConcert(Director director){
        Random random=new Random();
        int q=random.nextInt(songs.size());
        System.out.println("\u001B[31mДерижер вирішив виконати композицію - "+songs.get(q));
        System.out.println("\u001B[33m");
        setScore(director);
        System.out.println();
        System.out.println("\u001B[34mКонцерт почався");
        System.out.println();
        System.out.println("\u001B[31mКонцерт закінчено!!!!");
        System.out.println();

    }

    public void setScore(Director director){
        System.out.println("Дерижер роздає партії");
        director.getMusicians().stream().forEach(n->n.setScore("test"));
    }
    public void addSong(String song){
        songs.add(song);
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
