package Service;
import Domain.CardClient;
import Domain.Medicament;
import Repository.IRepository;

import java.util.List;

public class MedicamentService {
        private IRepository<Medicament> repository;

        public MedicamentService(IRepository<Medicament> repository) {
            this.repository = repository;
        }

        public void insert(String id, String name, String producator, double price, boolean reteta) {
            Medicament Medicament = new Medicament(id, name, producator, price,reteta);
            repository.upsert(Medicament);
        }

        public void update(String id, String name, String producator, double price, boolean reteta) {
            Medicament Medicament = new Medicament(id, name, producator, price,reteta);
            repository.upsert(Medicament);
        }

        public void remove(String id) {
            repository.remove(id);
        }

        public List<Medicament> getAll() {
            return repository.getAll();
        }
    }


