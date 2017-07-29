package prototype.search.dao;

import java.util.List;

import org.springframework.data.solr.core.geo.Point;
import org.springframework.data.solr.repository.SolrCrudRepository;

import prototype.search.model.FoodShop;

public interface FoodShopDao extends SolrCrudRepository<FoodShop, String> {

	List<FoodShop> findByName(String name);
	List<FoodShop> findByType(String type);
	List<FoodShop> findByMenu(List<String> menu);
	List<FoodShop> findByLocation(Point location);
	
}
