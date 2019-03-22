package Domain;
import java.util.Objects;

public class CardClient extends Entity {

 //   private String idCard;
    private String name;
    private String firstname;
    private String CNP;
    private String DateOfBirth;
    private String DateOfRegistration;

    public CardClient(String idCard, String name, String firstname, String CNP, String dateOfBirth, String dateOfRegistration) {
        super(idCard);
        this.name = name;
        this.firstname = firstname;
        this.CNP = CNP;
        DateOfBirth = dateOfBirth;
        DateOfRegistration = dateOfRegistration;
    }

    @Override
    public String toString() {
        return "ClientId: "+ this.getId()+"Name: "+this.name +"Firstname: "+this.firstname
                +"CNP: "+this.CNP +"DateOfBirth: "+ this.DateOfBirth+"Date of registration: " + this.DateOfRegistration ;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getDateOfRegistration() {
        return DateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        DateOfRegistration = dateOfRegistration;
    }

}