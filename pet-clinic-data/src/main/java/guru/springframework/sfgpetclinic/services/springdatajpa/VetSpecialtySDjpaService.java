package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.VetSpecialty;
import guru.springframework.sfgpetclinic.repositories.VetSpecialtyRepository;
import guru.springframework.sfgpetclinic.services.VetSpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservice")
public class VetSpecialtySDjpaService  implements VetSpecialtyService {

    private final VetSpecialtyRepository vetSpecialtyRepository;

    public VetSpecialtySDjpaService(VetSpecialtyRepository vetSpecialtyRepository) {
        this.vetSpecialtyRepository = vetSpecialtyRepository;
    }

    @Override
    public VetSpecialty findById(Long aLong) {
        return vetSpecialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public VetSpecialty save(VetSpecialty object) {
        return vetSpecialtyRepository.save(object);
    }

    @Override
    public Set<VetSpecialty> findAll() {
        Set<VetSpecialty> vetSpecialties=new HashSet<>();
        vetSpecialtyRepository.findAll().forEach(vetSpecialties::add);
        return vetSpecialties;
    }

    @Override
    public void delete(VetSpecialty object) {
        vetSpecialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetSpecialtyRepository.deleteById(aLong);
    }
}
