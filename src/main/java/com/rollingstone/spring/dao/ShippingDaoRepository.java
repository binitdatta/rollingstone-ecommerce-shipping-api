package com.rollingstone.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.spring.model.Shipping;

public interface ShippingDaoRepository extends PagingAndSortingRepository<Shipping, Long> {

	Page<Shipping> findAll(Pageable pageable);
}
