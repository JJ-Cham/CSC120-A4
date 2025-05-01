
import java.util.ArrayList;

public class Car implements CarRequirements {


    //Attributes 
    private int maxCapacity;
    private ArrayList<Passenger> passengersOnboard;


    /**
     * Constructs a Car object with the specified maximum capacity.
     * Initializes an empty passenger list.
     *
     * @param maxCapacity The maximum number of passengers the car can hold.
     */
    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<Passenger>();
    }


    /**
     * Returns the maximum capacity of the car.
     *
     * @return The max number of passengers the car can accommodate.
     */
    public int getCapacity(){
        return this.maxCapacity;
    }


    /**
     * Returns the number of seats remaining in the car.
     *
     * @return The number of seats available in the car.
     */
    public int seatsRemaining(){
        return this.maxCapacity - this.passengersOnboard.size();
    }


    /**
     * Adds a passenger to the car if space is available.
     *
     * @param p The passenger to be added.
     * @return true if the passenger was successfully added, false if the car is full.
     */
    public Boolean addPassenger(Passenger p){
        if(this.seatsRemaining() > 0){
            if (!this.passengersOnboard.contains(p)) {
                this.passengersOnboard.add(p);
                System.out.println("Passenger added");
                return true;
            } else {
                System.out.println("This passenger has already been added");
                return false; 
            }

        } else {
            System.out.println("Car is full. Passenger can't be added");
            return false;
        }
    } 

    /**
     * Removes a passenger from the car if they are onboard.
     *
     * @param p The passenger to be removed.
     * @return true if the passenger was successfully removed, false if they were not found.
     */
    public Boolean removePassenger(Passenger p){
        if(this.passengersOnboard.contains(p)){
            this.passengersOnboard.remove(p);
            return true;
        } else {
            System.out.println("Passenger not found");
            return false;
        }
    }

    /**
     * Prints a list of all passengers currently onboard.
     * If the car is empty, prints a message stating that.
     */
    public void printManifest(){
        if (this.passengersOnboard.isEmpty()) {
            System.out.println("This car is EMPTY.");
        } else {
            for(Passenger p : this.passengersOnboard){
                System.out.println(p);
            }
        }
    } 

    /**
     * Returns a string representation of the car, including the number of seats remaining.
     *
     * @return a string in the format "Car with X seats remaining", where X is the number
     *         of seats remaining in the car.
     */
    public String toString(){
        return "Car with " + this.seatsRemaining() + " seats remaining";
    }
    
    public static void main(String[] args) {
        // Creates a Car with capacity 2
        Car myCar = new Car(2);
        System.out.println(myCar); // Should print: "Car Capacity: 2, Occupied Seats: 0"
        myCar.printManifest();
    
        // Creates Passengers
        Passenger p1 = new Passenger("Alice", 30);
        Passenger p2 = new Passenger("Bob", 45);

    
        // Add Passengers
        myCar.addPassenger(p1);
        System.out.println(myCar);
        myCar.addPassenger(p2);
        System.out.println(myCar); // Should print: "Car Capacity: 2, Occupied Seats: 2"
    
    
        // Print Manifest
        myCar.printManifest();
    
        // Remove a Passenger
        myCar.removePassenger(p2);
        System.out.println("After removing Bob:");
        myCar.printManifest();
        System.out.println(myCar); // Should print: "Car Capacity: 2, Occupied Seats: 1"
    }
    
}