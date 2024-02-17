package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.
        System.out.println("Program spuštěn.");
        Pocitac mujPocitac = new Pocitac();
        System.out.println(mujPocitac.toString());
        mujPocitac.zapniSe();

       Procesor mujProcesor = new Procesor();
       mujProcesor.setVyrobce("Apple");
       mujProcesor.setRychlost(3_456_334_667_445_123_345L);

       Pamet mojePamet = new Pamet();
       mojePamet.setKapacita(25_345_678_123_345L);

        System.out.println(mujPocitac.toString());

       Disk mujDisk = new Disk();
       mujDisk.setKapacita(12_345_678_333L);
       mujDisk.setVyuziteMisto(0);
       mujDisk.vytvorSouborOVelikosti(11_345_678_345L);
       mujDisk.vymazSouboryOVelikosti(5_345_678_345L);

       mujPocitac.setCpu(mujProcesor);
       mujPocitac.setRam(mojePamet);
       mujPocitac.setPevnyDisk(mujDisk);

        System.out.println(mujPocitac.toString());

       mujPocitac.zapniSe();
       mujPocitac.vypniSe();
       mujPocitac.vypniSe();
    }

}
