package com.revature.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.revature.exceptions.ItemNotFoundException;
import com.revature.model.Item;
import com.revature.repository.ItemRepo;

@Service("itemService")
@Primary
public class ItemService {

	@Autowired
	ItemRepo itemRepository;

	public List<Item> getAll() {
		return itemRepository.findAll();
	}

	public Item getById(Integer id) throws ItemNotFoundException {
		Optional<Item> item = itemRepository.findById(id);
		if (item.isPresent()) {
			return item.get();
		} else {
			throw new ItemNotFoundException();
		}
	}

	public List<Item> getByCategoryId(Integer catId) {
		return itemRepository.findByCategoryId(catId);
	}

	public List<Item> getBySearchParam(String param) {
		return itemRepository.findBySearchParam(param);
	}

	  public Item addProduct (Item item) {
	        return itemRepository.save(item);
	    }

}
