package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person{

    @Column(name= "adress")
    private String adress;

    @Column(name= "city")
    private String city;

    @Column(name= "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets=new HashSet<>();

    public void setAdress(String adress){
        this.adress=adress;
    }

    public String getAdress(){
        return adress;
    }

    public void setCity(String city){
        this.city=city;
    }

    public String getCity(){
        return city;
    }

    public void setTelephone(String telephone){
        this.telephone=telephone;
    }

    public void setPets(Set<Pet> pets){
        this.pets=pets;
    }

    public void addPets(Pet pet){
        pets.add(pet);
    }

    public Set<Pet> getPets(){
        return pets;
    }



}
