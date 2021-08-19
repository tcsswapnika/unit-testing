package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

	@Mock
	ItemRepository repository;
	@InjectMocks
	ItemBusinessService business;

	@Test
	void testRetreiveHardcodedItem() {
		ItemBusinessService businessService = new ItemBusinessService();
		Item item = businessService.retreiveHardcodedItem();
		assertNotNull(item);
		// assertEquals(new Item(1, "Ball", 10, 100), item);
	}

	@Test
	void testSaveItem() {
		Item item = new Item(2, "Item2", 20, 20);
		when(repository.save(item)).thenReturn(item);
		business.saveItem(item);
		assertEquals("Item2", item.getName());
	}
	
//	@Test
//	void testNullName() {
//		Item item = new Item(3,null, 20, 20);
//		try {
//			item.getName();
//		} catch (Exception e) {
//			assertNotNull(e);
//			
//		}
//	}

	@Test
	void testRetrieveAllItems() {
		when(repository.findAll())
				.thenReturn(Arrays.asList(new Item(2, "Item2", 20, 20), new Item(3, "Item3", 20, 20)));
		business.retrieveAllItems();
	}

	@Test
	void testRetrieveAllItemsWithZeroItems() {
		when(repository.findAll()).thenReturn(Arrays.asList());
		business.retrieveAllItems();
	}

}
