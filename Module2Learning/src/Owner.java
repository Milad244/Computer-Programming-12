public class Owner {
    String name;

    Owner(String name){
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Owner){
            Owner other = (Owner) obj;
            if (other.name.equals(this.name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                '}';
    }
}
