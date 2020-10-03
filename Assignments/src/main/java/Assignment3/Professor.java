package Assignment3;

public class Professor {

    //compulsory fields
    private String firstName;
    private String lastName;
    private int id;

    //optional fields
    private String Address;
    private String email;

    private Professor(String firstName, String lastName, int id, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.Address = address;
        this.email = email;
    }

    public String toString(){
        return "Name: " + this.firstName + " " + this.lastName + " ID: " + this.id + " Email: " + this.email;
    }

    public static class Builder {

        //compulsory fields
        private String firstName;
        private String lastName;
        private int id;

        //optional fields
        private String Address;
        private String email;

        //compulsory fields in the constructor
        public Builder(String firstName, String lastName, int id){
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        //setters for optional fields
        public Builder setAddress(String address) {
            Address = address;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return  this;
        }

        public Professor build(){
            return new Professor(firstName, lastName, id, Address, email);
        }
    }
}
