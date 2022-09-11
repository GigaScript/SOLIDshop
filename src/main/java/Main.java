import interfaces.*;
import repositorys.ProductCategoryRepositoryInMemory;
import repositorys.ProductRepositoryInMemory;
import repositorys.UserRepositoryInMemory;
import repositorys.VendorRepositoryInMemory;
import usecase.AnyIdGenerator;
import usecase.Sha256PasswordEncoder;
import usecase.configurations.ProductCategoryConfigDefault;
import usecase.configurations.ProductConfigDefault;
import usecase.configurations.UserConfigDefault;
import usecase.configurations.VendorConfigDefault;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepositoryInMemory();
        ProductCategoryRepository productCategoryRepository = new ProductCategoryRepositoryInMemory();
        UserRepository userRepository = new UserRepositoryInMemory();
        VendorRepository vendorRepository = new VendorRepositoryInMemory();
        PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();
        IdGenerator idGenerator = new AnyIdGenerator();

        UserConfig userConfig = new UserConfigDefault(userRepository, passwordEncoder);
        VendorConfig vendorConfig = new VendorConfigDefault(vendorRepository, idGenerator);
        ProductCategoryConfig productCategoryConfig = new ProductCategoryConfigDefault(productCategoryRepository, idGenerator);
        ProductConfig productConfig = new ProductConfigDefault(productRepository, idGenerator);
    }
}
