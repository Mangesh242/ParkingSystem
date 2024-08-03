package org.example.models;

public class Vehicle extends BaseModel{
    private String LicencePlateNumber;
    private String ownerName;

    private VehicleType vehicleType;

    public String getLicencePlateNumber() {
        return LicencePlateNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        LicencePlateNumber = licencePlateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String onwerName) {
        this.ownerName = onwerName;
    }
}
