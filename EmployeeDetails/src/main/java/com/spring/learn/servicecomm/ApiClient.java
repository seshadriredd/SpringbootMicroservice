package com.spring.learn.servicecomm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.spring.learn.dao.EmpDomaindtlsDto;

//@FeignClient(url="http://localhost:8081",value="Domain-Service")
/*Above property we can give when we have only one instance
 *  if incase many instances are available?
 *  discovery/Registry/Eureka service all are refers to same service
 *  ------------------------------------------------------------
 *  Use below property it will provide the load balancing by discovery service
 *  value defines the name of the service registered with discovery service
 */
@FeignClient(value="DomainDetails")
public interface ApiClient {
	@GetMapping("api/domain/{name}")
	public EmpDomaindtlsDto getByDomain(@PathVariable String name);

	//public List<EmpDomaindtlsDto> getByDomain(String domain);
	
}
