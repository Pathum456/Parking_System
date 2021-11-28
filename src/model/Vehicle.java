package model;

public class Vehicle {
    String  VNum;
    String VType;
    int VMaximumWeight;
    int VNumOfPassengers;

    public Vehicle() {
    }

    public Vehicle(String VNum, String VType, int VMaximumWeight, int VNumOfPassengers) {
        this.VNum = VNum;
        this.VType = VType;
        this.VMaximumWeight = VMaximumWeight;
        this.VNumOfPassengers = VNumOfPassengers;
    }

    public String getVNum() {
        return VNum;
    }

    public void setVNum(String VNum) {
        this.VNum = VNum;
    }


    public String getVType() {
        return VType;
    }

    public void setVType(String VType) {
        this.VType = VType;
    }

    public int getVMaximumWeight() {
        return VMaximumWeight;
    }

    public void setVMaximumWeight(int VMaximumWeight) {
        this.VMaximumWeight = VMaximumWeight;
    }

    public int getVNumOfPassengers() {
        return VNumOfPassengers;
    }

    public void setVNumOfPassengers(int VNumOfPassengers) {
        this.VNumOfPassengers = VNumOfPassengers;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VNum='" + VNum + '\'' +
                ", VType='" + VType + '\'' +
                ", VMaximumWeight=" + VMaximumWeight +
                ", VNumOfPassengers=" + VNumOfPassengers +
                '}';
    }
}
