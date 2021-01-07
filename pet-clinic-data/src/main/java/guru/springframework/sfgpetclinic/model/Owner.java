package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person{

    private String adress;
    private String city;
    private String telephone;

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
