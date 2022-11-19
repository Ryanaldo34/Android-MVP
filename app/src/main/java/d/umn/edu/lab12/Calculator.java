package d.umn.edu.lab12;

public class Calculator implements Contract.Model {
    private int greatestMPG;
    private int leastMPG;
    private int calculated;

    Calculator() {
        this.greatestMPG = 0;
        this.leastMPG = 0;
        this.calculated = 0;
    }

    @Override
    public int calculateMPG(int firstReading, int lastReading, int gallons) {

        this.calculated = (lastReading - firstReading) / 2;
        return this.calculated;
    }

    @Override
    public void saveMPG() {
        if (this.calculated > greatestMPG) this.greatestMPG = this.calculated;
        if (this.calculated < leastMPG) this.leastMPG = this.calculated;
    }

    @Override
    public int getGreatestMPG() {
        return this.greatestMPG;
    }

    @Override
    public int getLeastMPG() {
        return this.leastMPG;
    }
}
