package Repository;

import Domain.IValidator;
import Domain.Medicament;
import Domain.MedicamentValidator;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class InMemoryRepositoryTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(InMemoryRepository.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void findById() {
        IValidator<Medicament> medicamentValidator = new MedicamentValidator();
        IRepository<Medicament> repo = new InMemoryRepository(medicamentValidator);
        Medicament added = new Medicament("1", "medicamentTest1",
                "producerTest1", 10.0D, true);
        repo.upsert(added);
        Medicament found = (Medicament)repo.findById("1");
        Assertions.assertNotNull(found, "Returned null for existing id!");
        Assertions.assertEquals("1", found.getId(),
                String.format("Returned id %s instead of correct id=1!", found.getId()));
        Assertions.assertEquals("test", found.getName(),
                String.format("Returned name=%s instead of %s", found.getName(), added.getName()));
    }

    @Test
    public void upsert() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void getAll() {
    }
}
