package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService) {
        this.ownerService =ownerService;//fare una DI
        this.vetService=vetService;// lasciare a Spring il controllo, così da poter cambiare
        //così da passare da un mapService ad un DBService ecc...
        this.petTypeService=petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog=new PetType();
        dog.setName("DOG");

        PetType savedDog=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Gatto");

        PetType savedCat=petTypeService.save(cat);

        Owner owner1=new Owner();
        //owner1.setId(1L); //L'id dovra essere generato in automatico
        owner1.setFirstName("amrito");
        owner1.setLastName("verrelli");
        owner1.setAdress("123 pignattara");
        owner1.setCity("Roma");
        owner1.setTelephone("380899882");
        Pet dogAmrito=new Pet();
        dogAmrito.setPetType(savedDog);
        dogAmrito.setName("ketty");
        dogAmrito.setBirthDate(LocalDate.now());
        dogAmrito.setOwner(owner1);
        owner1.addPets(dogAmrito);
        ownerService.save(owner1);

        Owner owner2=new Owner();
       // owner2.setId(2L); //dovrà essere generato in automatico
        owner2.setFirstName("carlo");
        owner2.setLastName("verrelli");
        owner2.setAdress("999 c. botte");
        owner2.setCity("Frosinone");
        owner2.setTelephone("999989891");
        Pet catCarlo=new Pet();
        catCarlo.setPetType(savedCat);
        catCarlo.setBirthDate(LocalDate.of(2010,03,10));
        catCarlo.setName("Pallina");
        catCarlo.setOwner(owner2);
        owner2.getPets().add(catCarlo);

        ownerService.save(owner2);

        Vet vet1=new Vet();
      //  vet1.setId(1L); //L'id dovrà essere generato in automatico
        vet1.setFirstName("gianluca");
        vet1.setLastName("cestra");

        vetService.save(vet1);

        Vet vet2=new Vet();
       // vet2.setId(2L); //L'id dovrà essere generato in automatico
        vet2.setFirstName("pippo");
        vet2.setLastName("dinsey");

        vetService.save(vet2);



        System.out.println("owner loaded");
        System.out.println("Vet loaded");
        System.out.println("loaded pet Types");
        System.out.println("Loaded pets into owner");
    }
}
