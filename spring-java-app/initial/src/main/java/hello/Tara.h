package hello;

import java.util.List;
import java.util.ArrayList;

public class Tara {

  private String name;
  private int id;
  private int populatie;

  public Tara() {}

  public Tara(int id, String name, int populatie) {
      this.name = name;
      this.id = id;
      this.populatie=populatie;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }

  public float getMotor(){
    return this.motor;
  }

  public void setName(String name){
	  this.name = name;
  }

  public void setId(int ID){
	  this.id = ID;
  }

  public void setMotor(float motor){
      this.motor=motor;
  }
}
