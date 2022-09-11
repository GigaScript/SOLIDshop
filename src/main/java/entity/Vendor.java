package entity;

public class Vendor {
    final String id;
    String name;
    String description;

    private Vendor(final String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        String id;
        String name;
        String description;


        public Builder() {
        }

        public Vendor.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Vendor.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Vendor.Builder setDescription(String description) {
            this.description = description;
            return this;
        }


        public Vendor build() {
            return new Vendor(id, name, description);
        }
    }


}
