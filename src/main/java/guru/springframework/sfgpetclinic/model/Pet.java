package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.Date;

public class Pet {

    private LocalDate birthDate;
    private Owner owner;
    private PetType petType;

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
