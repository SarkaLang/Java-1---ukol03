package cz.czechitas.ukol3;

public class Disk {

    private long kapacita;

    private long vyuziteMisto;

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        this.vyuziteMisto = vyuziteMisto;
    }

    public long getKapacita() {
        return kapacita;
    }

    public void setKapacita(long kapacita) {
        this.kapacita = kapacita;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "kapacita=" + kapacita +
                ", vyuziteMisto=" + vyuziteMisto +
                ", zbyva=" + (kapacita - vyuziteMisto) +
                '}';
    }

    public void vytvorSouborOVelikosti(long velikost) {
        vyuziteMisto = vyuziteMisto + velikost;

        if(vyuziteMisto > kapacita) {
         System.err.println("Na disku už není místo");

     } else {
            long vysledek = (kapacita - vyuziteMisto);
            System.out.println("Na disku zbývá:");
            System.out.println(vysledek);
        }

    }

    public void vymazSouboryOVelikosti(long velikost) {
     vyuziteMisto = vyuziteMisto - velikost;

     if (vyuziteMisto == 0) {
         System.err.println("Na disku už není místo");
     }  else {
         long vysledek = (kapacita - vyuziteMisto);
         System.out.println("Na disku zbývá:");
         System.out.println(vysledek);
     }
    }

}
