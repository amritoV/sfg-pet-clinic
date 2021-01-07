package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.Date;

public class Visit extends BaseEntity {

    private LocalDate visitDate;

    private Pet pet;

    //private Vet vet;

    private String description;

    public void setVisitDate(LocalDate visitDate){
        this.visitDate=visitDate;
    }

    public LocalDate getVisitDate(){
        return visitDate;
    }

    public void setPet(Pet pet){
        this.pet=pet;
    }

    public Pet getPet(){
        return pet;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }




}
