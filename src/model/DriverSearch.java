package model;

public class DriverSearch {
    String vehicleNumber;
    String driverName;

    public DriverSearch(Object selectedItem, Object item) {
    }

    public DriverSearch(String vehicleNumber, String driverName) {
        this.vehicleNumber = vehicleNumber;
        this.driverName = driverName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;

    }

    @Override
    public String toString() {
        return "DriverSearch{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", driverName='" + driverName + '\'' +
                '}';
    }
}
