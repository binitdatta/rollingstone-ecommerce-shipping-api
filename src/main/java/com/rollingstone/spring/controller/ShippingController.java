package com.rollingstone.spring.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.events.ShippingEvent;
import com.rollingstone.spring.model.Shipping;
import com.rollingstone.spring.service.ShippingService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account")
public class ShippingController extends AbstractController {

  
   private ShippingService  shippingService;
   
   public ShippingController(ShippingService shippingService) {
	   this.shippingService = shippingService;
   }

   /*---Add new Shipping---*/
   @PostMapping("/shipping")
   public ResponseEntity<?> createShipping(@RequestBody Shipping shipping) {
      Shipping savedShipping = shippingService.save(shipping);
      ShippingEvent ShippingCreatedEvent = new ShippingEvent(this, "ShippingCreatedEvent", savedShipping);
      eventPublisher.publishEvent(ShippingCreatedEvent);
      return ResponseEntity.ok().body("New Shipping has been saved with ID:" + savedShipping.getId());
   }

   /*---Get a Shipping by id---*/
   @GetMapping("/shipping/{id}")
   @ResponseBody
   public Shipping getShipping(@PathVariable("id") long id) {
	  Optional<Shipping> returnedShipping = shippingService.get(id);
	  Shipping Shipping  = returnedShipping.get(); 
	  
	  ShippingEvent ShippingCreatedEvent = new ShippingEvent(this, "ShippingRetrievedEvent", Shipping);
      eventPublisher.publishEvent(ShippingCreatedEvent);
      return Shipping;
   }
   
 

   /*---get all Shipping---*/
   @GetMapping("/shipping")
   public @ResponseBody Page<Shipping> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<Shipping> pagedShippings = shippingService.getShippingsByPage(pageNumber, pageSize);
      return pagedShippings;
   }

   /*---Update a Shipping by id---*/
   @PutMapping("/shipping/{id}")
   public ResponseEntity<?> updateShipping(@PathVariable("id") long id, @RequestBody Shipping shipping) {
	  checkResourceFound(this.shippingService.get(id));
	  shippingService.update(id, shipping);
      return ResponseEntity.ok().body("Shipping has been updated successfully.");
   }

   /*---Delete a Shipping by id---*/
   @DeleteMapping("/shipping/{id}")
   public ResponseEntity<?> deleteShipping(@PathVariable("id") long id) {
	  checkResourceFound(this.shippingService.get(id));
	  shippingService.delete(id);
      return ResponseEntity.ok().body("Shipping has been deleted successfully.");
   }
}