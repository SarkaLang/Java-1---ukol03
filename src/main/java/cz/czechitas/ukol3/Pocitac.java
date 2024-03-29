package cz.czechitas.ukol3;

public class Pocitac {

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
        if (!jeZapnuty) {
            System.out.println(" ");
            return;
        }
        jeZapnuty = false;
        System.out.println("Počítač je vypnutý");
    }

    // snaha o 3.zadani
    public void vytvorSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("Nelze vytvořit soubor, počítač je vypnutý");
        }

        long noveMisto = pevnyDisk.getVyuziteMisto() + velikost;

        if (noveMisto > pevnyDisk.getKapacita() && noveMisto > pevnyDisk.getKapacita() + druhyDisk.getKapacita()) {
            System.err.println("Není místo na žádném z disků");
            return;
        } else {
            if (noveMisto > pevnyDisk.getKapacita()) {
                druhyDisk.setVyuziteMisto(noveMisto - pevnyDisk.getKapacita());
                noveMisto = pevnyDisk.getKapacita();
            } else if (noveMisto < pevnyDisk.getKapacita()) {
                long vysledek = pevnyDisk.getKapacita() - (pevnyDisk.getVyuziteMisto() + noveMisto);
                System.out.println("Na disku zbývá:");
                System.out.println(vysledek);
            }

        }


        pevnyDisk.setVyuziteMisto(noveMisto);
    }

    public void vymazSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("Nelze vymazat soubor, počítač je vypnutý");
        }

        if (velikost > pevnyDisk.getKapacita() + druhyDisk.getKapacita()) {
            System.err.println("Error");
            return;
        }

        long vymazMisto;

        if (druhyDisk.getVyuziteMisto() == 0) {
            vymazMisto = pevnyDisk.getVyuziteMisto() - velikost;
        } else if (velikost > druhyDisk.getVyuziteMisto()) {
            long castZDruhehoDisku = velikost - druhyDisk.getVyuziteMisto();
            druhyDisk.setVyuziteMisto(0);
            vymazMisto = pevnyDisk.getVyuziteMisto() - castZDruhehoDisku;
        } else {
            // nechat pevny disk na maximalnich využitych kapacitach a odečítat z prvniho
            druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() - velikost);
            vymazMisto = pevnyDisk.getVyuziteMisto();
        }

      pevnyDisk.setVyuziteMisto(vymazMisto);
        }

}


