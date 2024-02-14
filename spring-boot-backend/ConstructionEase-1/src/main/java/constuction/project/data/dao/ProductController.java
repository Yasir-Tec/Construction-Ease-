package constuction.project.data.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import constuction.project.data.beans.Products;
import constuction.project.data.services.ProductRepository;
import constuction.project.data.beans.contractor;
import constuction.project.data.exception.ResourceNotFoundException;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/services/")
public class ProductController {

    @Autowired
    private ProductRepository productService;

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestParam("file") MultipartFile file,
            @RequestParam("category") String category,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("contractorId") Long contractorId) {
    	
    	
			try 
			{
		
				Products product = new Products();
				product.setCategory(category);
				product.setName(name);
				product.setDescription(description);
				product.setPrice(price);
				product.setContractorId(contractorId);
			
			// Save image file and set image path
			if (!file.isEmpty()) {
			// Save the file to the specified directory
			String uploadDir = "F:/ConstructionEase/React-frontend/construction-ease/public/assets/img/products/";
			String imagePath = "/assets/img/products/" + file.getOriginalFilename();
			File uploadedFile = new File(uploadDir + file.getOriginalFilename());
			FileOutputStream outputStream = new FileOutputStream(uploadedFile);
			outputStream.write(file.getBytes());
			outputStream.close();
			// Set image path in the product
			product.setImagePath(imagePath);
			}
			
			// Save the product
			productService.save(product);
			
			return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
			} catch (Exception e) {
			return new ResponseEntity<>("Failed to create product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
			}
    
    @GetMapping("/products/{contractorId}")
    public ResponseEntity<List<Products>> getProductsByContractorId(@PathVariable Long contractorId) {
    	System.out.println("id :"+contractorId);
        List<Products> products = productService.findByContractorId(contractorId);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found for contractor with id: " + contractorId);
        }
        return ResponseEntity.ok(products);
    }
			    
}
