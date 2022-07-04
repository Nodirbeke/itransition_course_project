package itransition.intern.itransitioncollection.service.search;

import lombok.RequiredArgsConstructor;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class IndexingService {

    private final EntityManager entityManager;

    @Transactional
    public void initiateIndexing() throws InterruptedException {

        FullTextEntityManager fullTextEntityManager =
                Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer().startAndWait();

    }

}
