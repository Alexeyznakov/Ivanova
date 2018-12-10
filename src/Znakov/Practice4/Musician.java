package Znakov.Practice4;


import java.math.BigDecimal;

public class Musician {
    private String name;
    private BigDecimal salary;
    private String score;

    public Musician(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        System.out.println("Музикант "+name+" отримав партію від дерижера");
        this.score = score;
    }
}
