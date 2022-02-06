package com.revature.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.revature.model.Item;

@Repository("itemRepo")
public interface ItemRepo extends JpaRepository<Item, Integer> {
	Item findByItemId(Integer itemId);

	List<Item> findByCategoryId(Integer catId);

	@Query("select i from Item i where i.itemName like %:param% order by i.categoryId")
	List<Item> findBySearchParam(String param);

}
