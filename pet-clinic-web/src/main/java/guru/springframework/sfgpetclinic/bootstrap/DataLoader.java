package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        Owner owner1=new Owner();
        //owner1.setId(1L); //L'id dovra essere generato in automatico
        owner1.setFirstName("amrito");
        owner1.setLastName("verrelli");

        ownerService.save(owner1);

        Owner owner2=new Owner();
       // owner2.setId(2L); //dovrà essere generato in automatico
        owner2.setFirstName("carlo");
        owner2.setLastName("verrelli");

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

        PetType petType1=new PetType();
        petType1.setName("DOG-golden retriever");

        petTypeService.save(petType1);

        PetType petType2=new PetType();
        petType2.setName("Gatto-trovatello");

        petTypeService.save(petType2);

        System.out.println("owner loaded");
        System.out.println("Vet loaded");
        System.out.println("loaded pet Types");
    }
}
