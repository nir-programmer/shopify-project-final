package org.nir.shopify.address;


import java.util.List;

import org.nir.shopify.common.entity.Address;
import org.nir.shopify.common.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface AddressRepository extends CrudRepository<Address, Integer> {

	public List<Address> findByCustomer(Customer customer);

	@Query("SELECT a FROM Address a WHERE a.id = ?1 AND a.customer.id = ?2")
	public Address findByIdAndCustomer(Integer addressId, Integer customerId);

	@Query("DELETE FROM Address a WHERE a.id = ?1 AND a.customer.id = ?2")
	@Modifying
	public void deleteByIdAndCustomer(Integer addressId, Integer customerId);	
}