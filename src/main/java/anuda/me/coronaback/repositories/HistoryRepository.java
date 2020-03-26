package anuda.me.coronaback.repositories;

import anuda.me.coronaback.entities.History;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface HistoryRepository  extends CrudRepository<History, Long> {

    List<History> findAll();
    History findByDateText(String dateText);

}
