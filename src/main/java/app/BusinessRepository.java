package app;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author vimalendu
 * @date 08/11/2016
 *
 */
@RepositoryRestResource(collectionResourceRel = "business", path = "business")
public interface BusinessRepository extends PagingAndSortingRepository<Business, String> {

	List<Business> findById(@Param("id") String id);

}
