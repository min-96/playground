package org.hdcd.service;

import lombok.RequiredArgsConstructor;
import org.hdcd.domain.Item;
import org.hdcd.repository.ItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService{

    private final ItemRepository repository;

    @Override
    @Transactional
    public void regist(Item item) {
        repository.save(item);

    }

    @Override
    @Transactional
    public Item read(Long itemId) {
        return repository.getById(itemId);
    }

    @Override
    public List<Item> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"itemId"));
    }

    @Override
    @Transactional
    public void modify(Item item) {
        Item itemEntity = repository.getOne(item.getItemId());

        itemEntity.setItemName(item.getItemName());
        itemEntity.setPrice(item.getPrice());
        itemEntity.setDescription(item.getDescription());
        itemEntity.setPictureUrl(item.getPictureUrl());

    }

    @Override
    @Transactional
    public void remove(Long itemId) {
        repository.getById(itemId);

    }

    @Override
    public String getPicture(Long itemId) {
        Item item = repository.getOne(itemId);
        return item.getPictureUrl();
    }
}
