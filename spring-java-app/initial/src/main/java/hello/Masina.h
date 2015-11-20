package hello;

import java.util.List;
import java.util.ArrayList;

public class Masina {
  private String name;
  private int id;
  private float motor;

  public Masina() {}

  public Masina(int id, String name, float motor) {
      this.name = name;
      this.id = id;
      this.motor=motor;
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
