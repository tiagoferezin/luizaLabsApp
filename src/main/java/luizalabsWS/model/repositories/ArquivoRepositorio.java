/**
 * 
 */
package luizalabsWS.model.repositories;

import luizalabsWS.model.entity.Arquivo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tiago Ferezin Data: 08/09/2018
 */
@Repository
public interface ArquivoRepositorio extends CrudRepository<Arquivo, Long> {

}
