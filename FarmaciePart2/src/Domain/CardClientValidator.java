package Domain;

public class CardClientValidator implements  IValidator<CardClient> {
    public CardClientValidator() {
    }

    public void validate(CardClient CardClient) {

        String errors = "";

        if (CardClient.getCNP() == "") {
            errors += "The CNP must be > 0!\n";
        }

        if (CardClient.getDateOfBirth() == "") {
            errors += "The DateOfBirth must be > 0!\n";
        }
        if (CardClient.getDateOfRegistration() == "") {
            errors += "The DateOfRegistration must be > 0!\n";
        }
        if (!errors.isEmpty()) {
            throw new RuntimeException(errors);
        }


    }
}