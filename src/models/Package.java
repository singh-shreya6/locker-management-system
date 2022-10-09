package models;

public class Package {

    String id;
    PackageType packageType;
    User user;

    public Package(String id, PackageType packageType, User user) {
        this.id = id;
        this.packageType = packageType;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
