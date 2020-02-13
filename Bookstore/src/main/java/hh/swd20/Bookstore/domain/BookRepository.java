package hh.swd20.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

//tietokantakäsittelyn rajapinta
public interface BookRepository extends CrudRepository <Book, Long> {
// CrudRepon parametrisoinnissa annetaan entityn nimi: Tässä car.
// ja toisena parametrina pääavainasarakkeen tyyppi.

}
