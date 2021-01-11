package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.VetSpecialty;
import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VetSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final VetSpecialtyService vetSpecialtyService;

    @Autowired
    public VetServiceMap(VetSpecialtyService vetSpecialtyService){
        this.vetSpecialtyService=vetSpecialtyService;
    }




    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        //Questo controllo ci permette di verificare che ogni VetSpecialty associata ad un Vet
        //sia memorizzata prima nel VetSpecialtyServiceMap, se esiste una VetSpecialty associata ad un vet e tale
        //che la VetSpecialty non sia memorizzata nel VetSpecialtyServiceMap: verrà memorizzata nel
        //vetSpecialtyServiceMap e poi associeremo lo stesso id alla Specialty del Vet.
        if(vet!=null) {
            vet.getSpecialties().forEach(specialty->{
                if(specialty.getId()==null){
                    VetSpecialty savedSpecialty=vetSpecialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
            return super.save(vet);
        }
        else return null;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }
}
