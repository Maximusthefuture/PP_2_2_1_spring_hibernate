package hiber.model;


import javax.persistence.*;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    @Override
    public String toString() {
        return "Car: " + getModel() + " , series: " + getSeries();
    }
}
