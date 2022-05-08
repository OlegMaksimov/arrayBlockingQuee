/**
 * @author www.epam.com
 */
public class Car {
    final private Parking parking;

    public Car(Parking parking) {
        this.parking = parking;
    }
    
    public Boolean parking() {
        try {
            boolean isParking = this.parking.parking(this);
            if (isParking) {
                System.out.println("car parking -> " + this );
            }
            else {
                System.out.println("Уехал на другую станку." + this);
            }
            return isParking;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
