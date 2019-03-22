package Domain;

public class Tranzactie extends Entity {

    //private String id_tranzactie;
    private String id_medicament;
    private String id_card_client;
    private String nr_bucati;
    private String date;
    private String hour;
    private  double discount;

    public Tranzactie(String id_tranzactie, String id_medicament, String id_card_client, String nr_bucati, String date, String hour,double discount) {
        super(id_tranzactie);
        this.id_medicament = id_medicament;
        this.id_card_client = id_card_client;
        this.nr_bucati = nr_bucati;
        this.date = date;
        this.hour = hour;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "TranzactionId: "+ this.getId()
                +"ID Medicament: "+this.id_medicament
                +"ID Card Client: "+this.id_card_client
                +"Nr Bucati: "+this.nr_bucati
                +"Date: "+ this.date
                +"Hour: " + this.hour
                +"Discount: " + this.discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public String getId_medicament() {
        return id_medicament;
    }

    public void setId_medicament(String id_medicament) {
        this.id_medicament = id_medicament;
    }

    public String getId_card_client() {
        return id_card_client;
    }

    public void setId_card_client(String id_card_client) {
        this.id_card_client = id_card_client;
    }

    public String getNr_bucati() {
        return nr_bucati;
    }

    public void setNr_bucati(String nr_bucati) {
        this.nr_bucati = nr_bucati;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }



}
