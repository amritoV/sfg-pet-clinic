package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.VetSpecialty;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VetSpecialtyService;

import java.util.Set;

public class VetSpecialtyServiceMap extends AbstractMapService<VetSpecialty, Long> implements VetSpecialtyService {

    @Override
    public VetSpecialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public VetSpecialty save(VetSpecialty vetSpecialty) {
        return super.save(vetSpecialty);
    }

    @Override
    public Set<VetSpecialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(VetSpecialty vetSpecialty) {
        super.delete(vetSpecialty);
    }
}
