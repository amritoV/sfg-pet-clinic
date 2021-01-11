package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService){
        this.petTypeService=petTypeService;
        this.petService=petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner!=null) {
            owner.getPets().forEach(pet->{
                    if(pet.getPetType()!=null){
                        if(pet.getId()==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else throw new RuntimeException("Pet Type is required of pet: "+pet.getName());

                    //ridondante forse
                    if(pet.getId()==null){
                        Pet savedPet=petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

            });
            System.out.println(petTypeService+"from ownerServiceMap");
            return super.save(owner);
        }
        else return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return super.map.entrySet().stream()
                                .filter(x-> x.getValue().getLastName().equals(lastName))
                                .map(x->x.getValue())
                                .findFirst()
                                .get();
    }
}
