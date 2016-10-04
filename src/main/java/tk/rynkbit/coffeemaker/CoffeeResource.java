package tk.rynkbit.coffeemaker;

import com.pi4j.io.gpio.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by michael on 04.10.16.
 */
@Path("/coffee")
public class CoffeeResource {
    @GET
    @Produces(value = "text/plain")
    @Path("/{id}")
    public String makeCoffee(@PathParam("id") int id){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Get GPIOController instance");
                final GpioController gpio = GpioFactory.getInstance();

                System.out.println("Setup pin for output");
                final GpioPinDigitalOutput pin = gpio
                        .provisionDigitalOutputPin(
                                RaspiBcmPin.GPIO_04,
                                "Coffee",
                                PinState.HIGH
                        );

                pin.setShutdownOptions(true, PinState.LOW);

                System.out.println("Sleep for 10 seconds");
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(id == 1){
                    System.out.println("Shutting down pin");
                    pin.low();
                }else{
                    System.out.println("Sleep for another 10 seconds");
                    try {
                        Thread.sleep(10 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Shutting down pin");
                    pin.low();
                }

                System.out.println("Shutting down controller");
                gpio.shutdown();
            }
        });
        t.start();
        return "Success";
    }

}
