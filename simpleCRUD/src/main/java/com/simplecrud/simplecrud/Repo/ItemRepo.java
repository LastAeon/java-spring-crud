package com.simplecrud.simplecrud.Repo;

import com.simplecrud.simplecrud.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
}
