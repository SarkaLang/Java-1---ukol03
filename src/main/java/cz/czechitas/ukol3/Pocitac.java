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

    // snaha o 3.zadani
    public void vytvorSouborOVelikosti(long velikost) {
        if(!jeZapnuty)  {
            System.err.println("Nelze vytvořit soubor, počítač je vypnutý");
        }

        long noveMisto = pevnyDisk.getVyuziteMisto() + velikost;

        if (noveMisto > pevnyDisk.getKapacita()) {
            System.err.println("Nelze vytvořit soubor, není dostatek místa na disku.");
            return;
        } else if (noveMisto < pevnyDisk.getKapacita()) {
            long vysledek = pevnyDisk.getKapacita() - (pevnyDisk.getVyuziteMisto() + noveMisto);
            System.out.println("Na disku zbývá:");
            System.out.println(vysledek);
        }

        pevnyDisk.setVyuziteMisto(noveMisto);
    }

    public void vymazSouborOVelikosti(long velikost) {
        if(!jeZapnuty)  {
            System.err.println("Nelze vymazat soubor, počítač je vypnutý");
        }

        long vymazMisto = pevnyDisk.getVyuziteMisto() - velikost;

        if (vymazMisto > pevnyDisk.getVyuziteMisto()) {
            System.err.println("Nelze vymazat soubor, není dostatek místa na disku.");
            return;
        } else {
            long vysledek = pevnyDisk.getKapacita() - vymazMisto;
            System.out.println("Na disku zbývá:");
            System.out.println(vysledek);
        }

        pevnyDisk.setVyuziteMisto(vymazMisto);
    }
}
