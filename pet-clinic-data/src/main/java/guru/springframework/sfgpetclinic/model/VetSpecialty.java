package guru.springframework.sfgpetclinic.model;


public class VetSpecialty extends BaseEntity{

    private String description;


    public void setSpecialty(String specialty){
        this.description=specialty;
    }


    public String getSpecialty(){
        return description;
    }



}
