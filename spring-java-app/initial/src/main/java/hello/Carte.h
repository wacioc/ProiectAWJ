package hello;

import java.util.List;
import java.util.ArrayList;

public class Carte {

  private String titlu;
  private String autor;
  private int pagini;

  public Carte() {}

  public Carte(String titlu, String autor, int pagini) {
      this.titlu = name;
      this.autor = autor;
  }

  public String getTitlu() {
      return this.titlu;
  }

  public String getAutor() {
    return this.autor;
  }

  public int getPagini(){
    return this.pagini;
  }

  public void setTitlu(String name){
	  this.name = name;
  }

  public void setAutor(String autor){
	  this.autor = autor;
  }

  public void setPagini(int pagini){
      this.pagini=pagini;
  }
}
