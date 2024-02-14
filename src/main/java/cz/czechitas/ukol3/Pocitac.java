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
        return jeZapnuty;

    }

    public void zapniSe() {
        if (jeZapnuty) {
            System.out.println("Počítač je zapnutý");
        } else {
            jeZapnuty = true;
            System.err.println("Počítač už je zapnutý");
        }
    }

    public void vypniSe() {
     if (jeZapnuty = false) {
         System.out.println("Počítač je vypnutý");
     } else {
         System.out.println();
     }

    }

}
