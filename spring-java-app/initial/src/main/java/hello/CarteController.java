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
public class CarteController {
  private List<Carte> carti = new ArrayList<Carte>();

  CarteController() {
    Carte p1 = new Carte("Alba ca zapada", "Fratii Grimm",75);
    Carte p2 = new Carte("Ursul pacalit de vulpe", "Ion Creanga",41);
    Carte p3 = new Carte("Harry Potter si Piatra Filozofala", "J.K.Rowling",341);

    carti.add(p1);
    carti.add(p2);
    carti.add(p3);
  }

  @RequestMapping(value="/Carte", method = RequestMethod.GET)
  public List<Carte> index() {
    return this.carti;
  }

  @RequestMapping(value="/Carte/{titlu}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("titlu") int titlu) {
    for(Carte p : this.carti) {
      if(p.getTitlu() == titlu) {
        return new ResponseEntity<Carte>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


  @RequestMapping(value="/Carte/{name}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("titlu") int titlu) {
    for(Carte p : this.carti) {
      if(p.getName() == name) {
        return new ResponseEntity<Carte>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Carte/{titlu}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("titlu") int titlu) {
    for(Carte p : this.carti) {
      if(p.getTitlu() == titlu) {
        this.carti.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Carte/{titlu}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("titlu") int titlu) {
    for(Carte p : this.carti) {
      if(p.getTitlu() == titlu) {
        p.setTitlu("Cenusareasa");
        p.setAutor("Fratii Grim");
        p.setPagini(66);
        return new ResponseEntity<Carte>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



  @RequestMapping(value="/Carte/{titlu}/{autor}/{pagini}", method = RequestMethod.POST)
   public ResponseEntity post(@PathVariable("titlu") int titlu, @PathVariable("autor") String autor, @PathVariable("pagini") int pagini) {
    Carte p = new Carte(titlu, autor, pagini);
    carti.add(p);
    return new ResponseEntity<Carte>(p, new HttpHeaders(), HttpStatus.OK);
  }
}
