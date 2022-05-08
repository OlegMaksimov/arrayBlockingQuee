import java.util.Objects;
import java.util.Random;

/**
 * @author www.epam.com
 */
public class Main {

    public static void main(String[] args) {
        Parking parking = new Parking();
        for (int i =0; i<10; i++) {
            new Thread(() -> { try {
                Thread.sleep(new Random().nextInt(1000));
                Car car = new Car(parking);
                System.out.println(Thread.currentThread().getName() + car);
                car.parking();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
               ).start();
        }

        for (int i = 0; i<10; i++) {
            new Thread(()-> {
                try {
                    Thread.sleep(3000);
                    if (Objects.nonNull(parking.getParkingSize())) {
                        parking.unParking();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }


}


