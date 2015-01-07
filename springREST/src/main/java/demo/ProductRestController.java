package demo;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

	private ProductRepository ProdRepo;
	
	@Autowired
	public ProductRestController(ProductRepository ProdRepo) {
		this.ProdRepo = ProdRepo;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Product create(@RequestBody @Valid Product product) {
		return this.ProdRepo.save(product);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Product> list() {
		return this.ProdRepo.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Product get(@PathVariable("id") Long id) {
		return this.ProdRepo.findOne(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Product update(@PathVariable("id") Long id, @RequestBody @Valid Product product) {
		return ProdRepo.save(product);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		this.ProdRepo.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
}
