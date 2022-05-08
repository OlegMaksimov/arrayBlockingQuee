import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author www.epam.com
 */
public class Parking {
    private ArrayBlockingQueue<Car> parkingSpace = new ArrayBlockingQueue<>(2);

    public boolean parking(Car car) throws InterruptedException {
        return parkingSpace.offer(car, 3, TimeUnit.SECONDS);
    }

    public Car unParking() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        Car car = parkingSpace.poll(1, TimeUnit.SECONDS);
        System.out.println("unparking " +car);
        return car;
    }

    public Car getParkingSize() {
        return parkingSpace.element();
    }
}
