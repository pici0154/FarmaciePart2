import Domain.*;
import Repository.InMemoryRepository;
import  Repository.IRepository;
import Service.CardClientService;
import Service.MedicamentService;
import Service.TranzactieService;
import UI.Console;

    public class Main {

        public static void main(String[] args) {

            IValidator<Medicament> medicamentValidator = new MedicamentValidator();
            IValidator<CardClient> cardClientValidator = new CardClientValidator();
            IValidator<Tranzactie> transactionValidator = new TranzactieValidator();

            IRepository<Medicament> medicamentRepository = new InMemoryRepository(medicamentValidator);
            IRepository<CardClient> cardClientRepository = new InMemoryRepository(cardClientValidator);
            IRepository<Tranzactie> transactionRepository = new InMemoryRepository(transactionValidator);

            MedicamentService medicamentService = new MedicamentService(medicamentRepository);
            CardClientService cardClientService = new CardClientService(cardClientRepository);
            TranzactieService transactionService = new TranzactieService(transactionRepository, medicamentRepository);

            Console console = new Console(medicamentService, cardClientService, transactionService);
            console.run();
        }
    }


