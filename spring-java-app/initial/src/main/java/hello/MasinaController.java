package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class MasinaController {
  private List<Masina> masini = new ArrayList<Masina>();

  MasinaController() {
    Masina p1 = new Masina(1, "Dacia",2.0);
    Masina p2 = new Masina(2, "Citroen",1.9);
    Masina p3 = new Masina(3, "Honda",1.6);

    masini.add(p1);
    masini.add(p2);
    masini.add(p3);
  }

  @RequestMapping(value="/Masina", method = RequestMethod.GET)
  public List<Masina> index() {
    return this.masini;
  }

  @RequestMapping(value="/Masina/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Masina p : this.masini) {
      if(p.getId() == id) {
        return new ResponseEntity<Masina>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


  @RequestMapping(value="/Masina/{name}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Masina p : this.masini) {
      if(p.getName() == name) {
        return new ResponseEntity<Masina>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Masina/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Masina p : this.masini) {
      if(p.getId() == id) {
        this.masini.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Masina/{id}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("id") int id) {
    for(Masina p : this.masini) {
      if(p.getId() == id) {
        p.setId(4);
        p.setName("BMW");
        return new ResponseEntity<Masina>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



  @RequestMapping(value="/Masina/{id}/{nume}/{motor}", method = RequestMethod.POST)
   public ResponseEntity post(@PathVariable("id") int id, @PathVariable("nume") String nume, @PathVariable("motor") float motor) {
    Masina p = new Masina(id, nume, motor);
    masini.add(p);
    return new ResponseEntity<Masina>(p, new HttpHeaders(), HttpStatus.OK);
  }
}
