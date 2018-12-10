package Znakov.Practice4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Director {
    private List<Musician> musicians=new ArrayList<>();
    private List<Date> dates=new ArrayList<>();
    private Conductor conductor;

    public List<Musician> getMusicians(){
        return musicians;
    }

    public void placeConcert(Date date){
        if(dates.contains(date)){
            System.out.println("Ця дата вже зайнята.");
        }
        else {

            dates.add(date);
            System.out.println("Дата заброньована.");
        }
    }
    public void playConcert(Date date){
        if ( dates.remove(date)) {
        conductor.playConcert(this);
            giveSalary();
        }else {
            System.out.println("Немає концерту "+date);
        }


    }
    public void addMusician(Musician mu)
    {
        System.out.println("Музикант "+mu.getName()+" прийнятий на роботу");
        musicians.add(mu);
    }

    private void giveSalary(){
        musicians.stream().forEach((n)->{
            System.out.println("\u001B[35mМузикант "+n.getName()+" отримав зарплатню в розмірі - "+n.getSalary().doubleValue());

        });
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
