import java.util.Random;

class Device {
    private String type;
    private double price;
    private double weight;

    public Device(String type, double price, double weight) {
        this.type = type;
        this.price = price;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Smartphone extends Device {
    private double screenSize;
    private int cameraResolution;

    public Smartphone(String type, double price, double weight, double screenSize, int cameraResolution) {
        super(type, price, weight);
        this.screenSize = screenSize;
        this.cameraResolution = cameraResolution;
    }
    public double getScreenSize() {
        return screenSize;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }
}

class Laptop extends Device {
    private String processor;
    private int ramSize;

    public Laptop(String type, double price, double weight, String processor, int ramSize) {
        super(type, price, weight);
        this.processor = processor;
        this.ramSize = ramSize;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRamSize() {
        return ramSize;
    }
}

class Tablet extends Device {
    private boolean hasKeyboard;

    public Tablet(String type, double price, double weight, boolean hasKeyboard) {
        super(type, price, weight);
        this.hasKeyboard = hasKeyboard;
    }
    public boolean hasKeyboard() {
        return hasKeyboard;
    }
}

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        // Ask the user for the number of devices to create (between 1 and 20)
        int numDevices = 5;

        Device[] devices = new Device[numDevices];

        for (int i = 0; i < numDevices; i++) {
            String[] types = {"Smartphone", "Laptop", "Tablet"};
            String randomType = types[rand.nextInt(types.length)];
            double randomPrice = rand.nextDouble() * 1000;
            double randomWeight = rand.nextDouble() * 2000;

            if (randomType.equals("Smartphone")) {
                double randomScreenSize = rand.nextDouble() * 6.0;
                int randomCameraResolution = rand.nextInt(16) + 5;
                devices[i] = new Smartphone(randomType, randomPrice, randomWeight, randomScreenSize, randomCameraResolution);
            } else if (randomType.equals("Laptop")) {
                String[] processors = {"Intel Core i5", "Intel Core i7", "AMD Ryzen 5"};
                String randomProcessor = processors[rand.nextInt(processors.length)];
                int randomRamSize = rand.nextInt(16) + 4;
                devices[i] = new Laptop(randomType, randomPrice, randomWeight, randomProcessor, randomRamSize);
            } else if (randomType.equals("Tablet")) {
                boolean randomHasKeyboard = rand.nextBoolean();
                devices[i] = new Tablet(randomType, randomPrice, randomWeight, randomHasKeyboard);
            }
        }

        double totalPrice = 0;
        double totalWeight = 0;
        int distinctTypes = 0;

        for (Device device : devices) {
            totalPrice += device.getPrice();
            totalWeight += device.getWeight();
            distinctTypes++;
        }

        System.out.println("Number of device: " + distinctTypes);
        System.out.println("Price of all devices: $" + totalPrice);
        System.out.println("Weight of all devices: " + totalWeight + " grams");
    }
}
