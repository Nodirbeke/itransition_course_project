package itransition.intern.itransitioncollection.service.search;

import itransition.intern.itransitioncollection.dtos.item.ItemDto;
import itransition.intern.itransitioncollection.entity.item.Item;
import itransition.intern.itransitioncollection.mapper.item.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchService {

    private final EntityManager entityManager;

    private final ItemMapper mapper;


    public List<ItemDto> getItemBasedOnWord(String word){

        FullTextEntityManager fullTextEntityManager =
                Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Item.class)
                .get();


        Query query = queryBuilder.keyword()
                .onFields("name", "hashTags", "body")
                .matching(word)
                .createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager
                .createFullTextQuery(query,Item.class);
        return mapper.toDto((List<Item>) fullTextQuery.getResultList());

    }

}


