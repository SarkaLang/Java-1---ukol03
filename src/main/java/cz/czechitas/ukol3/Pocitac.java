package cz.czechitas.ukol3;

public class Pocitac {

    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    @Override
    public String toString() {
        return "Pocitac{" +
                "jeZapnuty=" + jeZapnuty +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", pevnyDisk=" + pevnyDisk +
                '}';
    }

    public boolean jeZapnuty() {
        return jeZapnuty = false;
    }

    public void zapniSe() {
        jeZapnuty = true;
        System.out.println("Počítač je zapnutý");

        if (jeZapnuty) {
            System.out.println("Počítač už je zapnutý");
            return;
        }

        if (cpu == null || ram == null || pevnyDisk == null) {
            System.err.println("Počítač nemá všechny povinné součásti");
        }
    }

    public void vypniSe() {
        jeZapnuty = false;
        System.out.println("Počítač je vypnutý");

        if(jeZapnuty) {
            System.out.println(" ");
        }
    }

}
