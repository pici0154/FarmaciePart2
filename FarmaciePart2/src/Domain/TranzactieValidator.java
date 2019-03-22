package Domain;

public class TranzactieValidator implements IValidator<Tranzactie> {

        public TranzactieValidator() {
        }

        public void validate(Tranzactie Tranzactie) {

            String errors = "";
            if (Tranzactie.getId_medicament().isEmpty() ) {
                errors += "The Id_medicament must be given!\n";
            }
           // if (Tranzactie.getId_card_client() == "") {
            //    errors += "The Id_card_client doesn't exist!\n";
            //}
            if (Tranzactie.getNr_bucati() == null) {
                errors += "The nr_bucati must be > 0!\n";
            }
            if (Tranzactie.getDate() == "") {
                errors += "The Date must be given!\n";
            }
            if (Tranzactie.getHour() == "") {
                errors += "The Hour must be given!\n";
            }
            if (!errors.isEmpty()) {
                throw new RuntimeException(errors);
            }


        }
    }

