package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pets")
public class Pet extends BaseEntity {

    @Column(name ="name")
    private String name;

    @Column(name ="birthDate")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits=new HashSet<>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }
}
