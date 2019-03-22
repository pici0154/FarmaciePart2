package Service;
import Domain.Medicament;
import Domain.Tranzactie;
import Repository.IRepository;

import java.util.List;


public class TranzactieService {


        private IRepository<Tranzactie> tranzactieRepository;
        private IRepository<Medicament> medicamentRepository;

        public TranzactieService(IRepository<Tranzactie> tranzactieRepository,
                                 IRepository<Medicament> medicamentRepository)
        {
            this.tranzactieRepository = tranzactieRepository;
            this.medicamentRepository = medicamentRepository;
        }

        public void insert ( String id_tranzactie,String id_medicament, String id_card_client, String nr_bucati, String date, String hour ) {

        // after insert we will check if we need to do the discount
            Medicament medicamentSold = medicamentRepository.findById(id_medicament);
            if (medicamentSold == null) {
                throw new RuntimeException("There is no medicament with the given id!");
            }
            double basePrice = medicamentSold.getPrice();
            double discount = 0;
            if (id_card_client != null && id_medicament != null
                    && medicamentRepository.findById(id_medicament).getReteta() == false) {
                discount = 0.1; // 10% discount
                System.out.println("Discount of 10% applied!");
            }else if(id_card_client != null && id_medicament != null &&
                    medicamentRepository.findById(id_medicament).getReteta() == true){
                discount = 0.15; //15% discount
                System.out.println("Discount of 15% applied!");
            }
            Tranzactie Tranzactie = new Tranzactie(id_tranzactie, id_medicament, id_card_client,  nr_bucati, date, hour,discount);
            tranzactieRepository.upsert(Tranzactie);

        }

        public void update( String id_tranzactie, String id_medicament, String id_card_client, String nr_bucati, String date, String hour) {

            Medicament medicamentSold = medicamentRepository.findById(id_medicament);
            if (medicamentSold == null) {
                throw new RuntimeException("There is no medicament with the given id!");
            }
            double basePrice = medicamentSold.getPrice();
            double discount = 0;
            if ( id_medicament != null && medicamentRepository.findById(id_medicament).getReteta() == false) {
                discount = 0.1; // 10% discount
                System.out.println("Discount of 10% applied!");
            }else if(id_card_client != null && id_medicament != null && medicamentRepository.findById(id_medicament).getReteta() == true){
                discount = 0.15; //15% discount
                System.out.println("Discount of 15% applied!");
            }
            Tranzactie Tranzactie = new Tranzactie(id_tranzactie, id_medicament, id_card_client,  nr_bucati, date, hour,discount);

            tranzactieRepository.upsert(Tranzactie);
        }

        public void remove(String id) {
            tranzactieRepository.remove(id);
        }

        public List<Tranzactie> getAll() {
            return tranzactieRepository.getAll();
        }
    }






