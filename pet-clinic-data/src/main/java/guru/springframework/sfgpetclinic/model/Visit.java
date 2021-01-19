package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = " pet_id")
    private Pet pet;

    //private Vet vet;

    @Column(name = "description")
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
