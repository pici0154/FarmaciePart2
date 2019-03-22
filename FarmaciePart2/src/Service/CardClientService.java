package Service;
import Domain.CardClient;
import Repository.IRepository;

import java.util.List;

public class CardClientService {

    private IRepository<CardClient> repository;


    public CardClientService(IRepository<CardClient> repository) {
            this.repository = repository;
        }

        public void insert (String id, String name, String firstname, String CNP, String dateOfBirth, String dateOfRegistration ) {
            CardClient CardClient = new CardClient(id, name, firstname, CNP, dateOfBirth, dateOfRegistration);
            repository.upsert(CardClient);
        }

        public void update(String id, String name, String firstname, String CNP, String dateOfBirth, String dateOfRegistration) {
            CardClient CardClient = new CardClient (id, name, firstname, CNP, dateOfBirth, dateOfRegistration);
            repository.upsert(CardClient);
        }

        public void remove(String id) {
            repository.remove(id);
        }

        public List<CardClient> getAll() {

            return repository.getAll();
        }
    }





