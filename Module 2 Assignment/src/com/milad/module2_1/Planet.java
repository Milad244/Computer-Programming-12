package com.milad.module2_1;

public class Planet {
    private String designation;
    private double massKg;
    private double orbitEarthYears;
    private PlanetType type;

    /**
     *
     * Planet constructor with only designation and the planet type
     * @param designation The unique identifier of the planet
     * @param type The general type of the planet
     */
    public Planet(String designation, PlanetType type){
        this.designation = designation;
        this.type = type;
    }

    /**
     * Planet constructor with designation, mass, years of orbiting Earth, and planet type
     * @param designation The unique identifier of the planet
     * @param massKg The mass of the planet in kg
     * @param orbitEarthYears The length of years the planet has orbited Earth
     * @param type The general type of the planet
     */
    public Planet(String designation, double massKg, double orbitEarthYears, PlanetType type) {
        this.designation = designation;
        this.massKg = massKg;
        this.orbitEarthYears = orbitEarthYears;
        this.type = type;
    }

    /**
     * Override of equals method from Object to compare a given Planet with another using its designation field
     * @param obj The other Planet you are comparing with
     * @return True if both planets have the same designation, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Planet){
            Planet other = (Planet) obj;
            if (this.designation.equals(other.designation)){
                return true;
            }
        }
        return false;
    }

    /**
     * Override of hashCode method from Object to get the hashcode of the Planet from the designation field
     * @return hashcode of the Planet from its designation field
     */
    @Override
    public int hashCode() {
        return designation.hashCode();
    }

    @Override
    public String toString() {
        return "Planet. Designation: " + designation + "\tType: " + type;
    }
}
