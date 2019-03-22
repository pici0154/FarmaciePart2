package Domain;
import java.util.Objects;
public class Medicament extends Entity {

    //private String id;
    private String name;
    private String producator;
    private double price;
    private boolean reteta;

    public Medicament(String id, String name, String producator, double price,boolean reteta) {
        super(id);
        this.name = name;
        this.producator = producator;
        this.price = price;
        this.reteta = reteta;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "id='" + this.getId() + '\'' +
                ", name='" + this.name + '\'' +
                ", producator='" + this.producator + '\'' +
                ", pret='" + this.price + '\'' +
                ", reteta='" + this.reteta + '\'' +   '}';

    }


    public String getName() {
        return name;
    }

    public void setNume(String name) {
        this.name = name;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getReteta() {
        return reteta;
    }

    public void setReteta(boolean reteta) {
        this.reteta = reteta;
    }




}
