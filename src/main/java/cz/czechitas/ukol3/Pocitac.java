package cz.czechitas.ukol3;

public class Pocitac{

    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    private Disk druhyDisk;

    public void setJeZapnuty(boolean jeZapnuty) {
        this.jeZapnuty = jeZapnuty;
    }

    public Disk getDruhyDisk() {
        return druhyDisk;
    }

    public void setDruhyDisk(Disk druhyDisk) {
        this.druhyDisk = druhyDisk;
    }

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
                ", druhyDisk=" + druhyDisk +
                '}';
    }

    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public void zapniSe() {
        if (jeZapnuty) {
            System.out.println("Počítač už je zapnutý");
            return;
        }

        if (cpu == null || ram == null || pevnyDisk == null) {
            System.err.println("Počítač nemá všechny povinné součásti");
        }

        jeZapnuty = true;
        System.out.println("Počítač je zapnutý");

    }

    public void vypniSe() {
        if(!jeZapnuty) {
            System.out.println(" ");
            return;
        }
        jeZapnuty = false;
        System.out.println("Počítač je vypnutý");
    }

    public void vytvorSouborOVelikosti(long velikost) {
       if(!jeZapnuty)  {
           System.err.println("Nelze vytvořit soubor, počítač je vypnutý");
           return;
       }

       if (pevnyDisk.getKapacita() - pevnyDisk.getVyuziteMisto() <= velikost) {
           pevnyDisk.vytvorSouborOVelikosti(velikost);
       } else if(pevnyDisk.getKapacita() - pevnyDisk.getVyuziteMisto() >= velikost) {
           druhyDisk.vytvorSouborOVelikosti(velikost);
       } else {
           System.err.println("Na disku už není místo");
       }
    }
}
