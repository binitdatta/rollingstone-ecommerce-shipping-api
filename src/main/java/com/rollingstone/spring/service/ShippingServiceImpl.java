package com.rollingstone.spring.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.spring.dao.ShippingDaoRepository;
import com.rollingstone.spring.model.Shipping;

@Service
public class ShippingServiceImpl implements ShippingService {

	  final static Logger logger = LoggerFactory.getLogger(ShippingServiceImpl.class);

   @Autowired
   private ShippingDaoRepository shippingDao;  
  
   @Override
   public Shipping save(Shipping shipping) {
      return shippingDao.save(shipping);
   }

   @Override
   public Optional<Shipping> get(long id) {
      return shippingDao.findById(id);
   }

   @Override
   public Page<Shipping> getShippingsByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("shippingName").descending());
	   return shippingDao.findAll(pageable);
   }

   @Override
   public void update(long id, Shipping shipping) {
      shippingDao.save(shipping);
   }

   
   @Override
   public void delete(long id) {
      shippingDao.deleteById(id);
   }

}
