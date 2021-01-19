package guru.springframework.sfgpetclinic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="specialities")
public class VetSpecialty extends BaseEntity{

    @Column(name="description")
    private String description;


    public void setSpecialty(String specialty){
        this.description=specialty;
    }


    public String getSpecialty(){
        return description;
    }



}
