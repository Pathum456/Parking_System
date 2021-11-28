package model;

public class SlotSeen {
    String VehicleNumber;
    String SlotNumber;

    public SlotSeen() {
    }

    public SlotSeen(String vehicleNumber, String slotNumber) {
        VehicleNumber = vehicleNumber;
        SlotNumber = slotNumber;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getSlotNumber() {
        return SlotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        SlotNumber = slotNumber;
    }

    @Override
    public String toString() {
        return "SlotSeen{" +
                "VehicleNumber='" + VehicleNumber + '\'' +
                ", SlotNumber='" + SlotNumber + '\'' +
                '}';
    }
}
