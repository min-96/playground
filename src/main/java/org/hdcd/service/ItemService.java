package org.hdcd.service;

import lombok.RequiredArgsConstructor;
import org.hdcd.domain.Item;
import org.hdcd.repository.ItemRepository;

import java.util.List;


public interface ItemService {


    public void register(Item item);


    public Item read(Long itemId);

    public List<Item> list();

    public void modify(Item item);

    public void remove(Long itemId);

    public String getPicture(Long itemId);
}
