package entity;

public class ProductCategory {
    final String id;
    String name;
    String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public ProductCategory(final String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static ProductCategory.Builder builder() {
        return new ProductCategory.Builder();
    }


    public static class Builder {
        String id;
        String name;
        String description;


        public Builder() {
        }

        public ProductCategory.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public ProductCategory.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductCategory.Builder setDescription(String description) {
            this.description = description;
            return this;
        }


        public ProductCategory build() {
            return new ProductCategory(id, name, description);
        }
    }
}