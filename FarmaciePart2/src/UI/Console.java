package UI;

import Domain.CardClient;
import Domain.Medicament;
import Domain.Tranzactie;
import Service.CardClientService;
import Service.MedicamentService;
import Service.TranzactieService;
import java.util.Iterator;
import java.util.Scanner;

public class Console {

        private MedicamentService MedicamentService;
        private CardClientService CardClientService ;
        private TranzactieService TranzactieService;

        private Scanner scanner;

        public Console(MedicamentService MedicamentService, CardClientService b, TranzactieService TranzactieService) {
            this.MedicamentService = MedicamentService;
            this.CardClientService = b;
            this.TranzactieService = TranzactieService;
            this.scanner = new Scanner(System.in);
        }

        public void run() {
            while (true) {
                showMenu();

                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        runMedicamente();
                        break;
                    case "2":
                        runCardClient();
                        break;
                    case "3":
                        runTransaction();
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("Optiune invalida!");
                        break;
                }
            }
        }

        private void runMedicamente() {
            while (true) {
                showMedicamentMenu();
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        handleAddMedicament();
                        break;
                    case "2":
                        handleUpdateMedicament();
                        break;
                    case "3":
                        handleRemoveMedicament();
                        break;
                    case "4":
                        handleShowAllMedicament();
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("Optiune invalida!");
                }
            }
        }


    private void runTransaction() {
        while (true) {
            showTranzactieMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddTransaction();
                    break;
                case "2":
                    handleUpdateTransaction();
                    break;
                case "3":
                    handleRemoveTransaction();
                    break;
                case "4":
                    handleShowAllTransactios();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }


    private void runCardClient() {
        while (true) {
            showCardClientMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddCardClient();
                    break;
                case "2":
                    handleUpdateCardClient();
                    break;
                case "3":
                    handleRemoveCardClient();
                    break;
                case "4":
                    handleShowAllCardClients();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }
        private void handleShowAllMedicament() {
            Iterator var1 = this.MedicamentService.getAll().iterator();

            while(var1.hasNext()) {
                Medicament medicament = (Medicament)var1.next();
                System.out.println(medicament);
            }
           /* for (Medicament Medicament : MedicamentService.getAll()) {
                System.out.println( "  Id Medicament: " + Medicament.getId() +
                                    "; Medicament Name:  "+ Medicament.getName()+
                                    "; Producer: "+Medicament.getProducator() +
                                    "; Price: "+ Medicament.getPrice() +
                                    "; Recept: " + Medicament.getReteta() +"\n");
            }*/
        }

    private void handleShowAllCardClients() {
        Iterator var1 = this.CardClientService.getAll().iterator();

        while(var1.hasNext()) {
            CardClient cardClient = (CardClient)var1.next();
            System.out.println(cardClient);
        }

       /* for (CardClient CardClient : CardClientService.getAll()) {
            System.out.println("Id Card Client: "+ CardClient.getId() +
                    "; Card Name: "+ CardClient.getName()+
                    "; Card First Name:  "+CardClient.getFirstname() +
                    "; CNP: "+ CardClient.getCNP() +
                    "; nDate of registration: " + CardClient.getDateOfRegistration() +
                    "; Date of birth: "+ CardClient.getDateOfBirth());
        }*/
    }


    private void handleShowAllTransactios() {
        Iterator var1 = this.TranzactieService.getAll().iterator();

        while(var1.hasNext()) {
            Tranzactie tranzactie = (Tranzactie) var1.next();
            System.out.println(tranzactie);
        }

            /* for (Tranzactie Tranzactie : TranzactieService.getAll()) {
            System.out.println( "Transaction: "+ Tranzactie.getId_tranzactie() +
                                "; ID Medicament: "+ Tranzactie.getId_medicament()+
                                "; ID Card Client:  "+Tranzactie.getId_card_client() +
                                "; Nr. Bucati:  "+ Tranzactie.getNr_bucati() +
                                "; Date: "+Tranzactie.getDate() +
                                "; Hour: "+ Tranzactie.getHour()+
                                "; Discount: "+ Tranzactie.getDiscount()+ "\n");
        }*/
    }



    private void handleRemoveCardClient() {
            try {
                System.out.print("Enter id to remove: ");
                String id = scanner.nextLine();

               CardClientService.remove(id);

                System.out.println("CardClient removed successfully!");
            } catch (RuntimeException rex) {
                System.out.println("Errors:\n" + rex.getMessage());
            }
        }


    private void handleRemoveTransaction() {
        try {
            System.out.print("Enter id to remove: ");
            String id = scanner.nextLine();

            TranzactieService.remove(id);

            System.out.println("Transaction removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }


    private void handleRemoveMedicament() {
        try {
            System.out.print("Enter id to remove: ");
            String id = scanner.nextLine();

            MedicamentService.remove(id);

            System.out.println("Medicament removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateMedicament() {
            try {
                System.out.print("Enter id to update: ");
                String id = scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new producer: ");
                String producator = scanner.nextLine();
                System.out.print("Enter new price: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter new recept: ");
                boolean reteta = Boolean.parseBoolean(scanner.nextLine());
                MedicamentService.update(id, name,producator, price,reteta);

                System.out.println("Medicament updated successfully!");
            } catch (RuntimeException rex) {
                System.out.println("Errors:\n" + rex.getMessage());
            }
        }

    private void handleUpdateTransaction() {
        try {
            System.out.print("Enter id to update transaction: ");
            String id_tranzactie = scanner.nextLine();
            System.out.print("Enter new id_medicament: ");
            String id_medicament = scanner.nextLine();
            System.out.print("Enter new id_card_client: ");
            String id_card_client = scanner.nextLine();
            System.out.print("Enter nr bucati: ");
            String nr_bucati = scanner.nextLine();
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
            System.out.print("Enter hour: ");
            String hour = scanner.nextLine();

            TranzactieService.update( id_tranzactie, id_medicament, id_card_client,  nr_bucati, date, hour);
            System.out.println("Transactions updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateCardClient() {
        try {
            System.out.print("Enter idCard to update: ");
            String idCard = scanner.nextLine();
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new FirstName: ");
            String firstname = scanner.nextLine();
            System.out.print("Enter new CNP: ");
            String CNP =scanner.nextLine();
            System.out.print("Enter new DateOfBirth: ");
            String DateOfBirth =scanner.nextLine();
            System.out.print("Enter new DateOfRegistration: ");
            String DateOfRegistration =scanner.nextLine();

            CardClientService.update(idCard, name, firstname, CNP, DateOfBirth, DateOfRegistration );

            System.out.println("CardCliet updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleAddMedicament() {
            try {
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter producator: ");
                String producator = scanner.nextLine();
                System.out.print("Enter price: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter recept: ");
                boolean reteta = Boolean.parseBoolean(scanner.nextLine());


                MedicamentService.insert(id, name, producator, price,reteta);

                System.out.println("Medicament added successfully!");
            } catch (RuntimeException rex) {
                System.out.println("Errors:\n" + rex.getMessage());
            }
        }


    private void handleAddTransaction() {
        try {
            System.out.print("Id Transaction:: ");
            String id_tranzactie =scanner.nextLine();
            System.out.print("Enter IdMedicament: ");
            String id_medicament = scanner.nextLine();
            System.out.print("Enter IdCardClient: ");
            String id_card_client = scanner.nextLine();
            System.out.print("Enter Nr_bucati: ");
            String nr_bucati = scanner.nextLine();
            System.out.print("Date: ");
            String date =scanner.nextLine();
            System.out.print("Hour: ");
            String hour =scanner.nextLine();


            TranzactieService.insert(id_tranzactie,id_medicament, id_card_client, nr_bucati, date, hour );

            System.out.println("Transaction added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }


    private void handleAddCardClient() {
        try {
            System.out.print("Enter Card id: ");
            String id = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter FirstName: ");
            String firstname = scanner.nextLine();
            System.out.print("Enter CNP: ");
            String CNP =scanner.nextLine();
            System.out.print("Enter DateOfBirth: ");
            String DateOfBirth =scanner.nextLine();
            System.out.print("Enter DateOfRegistration: ");
            String DateOfRegistration =scanner.nextLine();

            CardClientService.insert(id, name, firstname, CNP, DateOfBirth, DateOfRegistration );

            System.out.println("CardCliet added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors CardClientADD:\n" + rex.getMessage());
        }
    }


    private void showMedicamentMenu() {
            System.out.println("1. Add medicament");
            System.out.println("2. Update medicament");
            System.out.println("3. Remove medicament");
            System.out.println("4. Show all");
            System.out.println("x. Back");
        }

    private void showTranzactieMenu() {
        System.out.println("1. Add transaction");
        System.out.println("2. Update transaction");
        System.out.println("3. Remove transaction");
        System.out.println("4. Show all");
        System.out.println("x. Back");
    }


    private void showCardClientMenu() {
        System.out.println("1. Add card client");
        System.out.println("2. Update card client");
        System.out.println("3. Remove card client");
        System.out.println("4. Show all cards");
        System.out.println("x. Back");
    }

        private void showMenu() {
            System.out.println("1. CRUD Medicamente");
            System.out.println("2. CRUD Clients");
            System.out.println("3. CRUD Transactions");
            System.out.println("x. Exit");
        }
    }

