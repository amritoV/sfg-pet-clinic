package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name="vet_id"),
                        inverseJoinColumns = @JoinColumn(name="speciality_id"))
    private Set<VetSpecialty> specialties=new HashSet<>();


    public void setSpecialties(Set<VetSpecialty> specialties){
        this.specialties=specialties;
    }

    //public void addSpecialty(VetSpecialty vetSpecialty){
    //    specialties.add(vetSpecialty);
    //}

    public Set<VetSpecialty> getSpecialties(){
        return specialties;
    }


}
