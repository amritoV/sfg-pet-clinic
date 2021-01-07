package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person{

    private Set<VetSpecialty> specialties;


    public void setSpecialties(Set<VetSpecialty> specialties){
        this.specialties=specialties;
    }

    public void addSpecialty(VetSpecialty vetSpecialty){
        specialties.add(vetSpecialty);
    }

    public Set<VetSpecialty> getSpecialties(){
        return specialties;
    }


}
