

//Penggunaan Enkapsulasi
class Mahasiswa {
  public String Nama,NIM, Name = "Budi";
  private int Nilaiku;
  protected int Semesterku;

  // Setter
  public void setNilai(int Nilaiku) {
      this.Nilaiku = Nilaiku;
  }

  // Getter
  public int getNilai() {
      return Nilaiku;
  }

    // Penggunaan Polimorphism
  public String Ketuntasan(){
    return "Setiap Matkul Memiliki Nilai Ketuntasan Masing-masing";
  }
}

// Penggunaan Inheritance
class Matkul extends Mahasiswa{
  // Setter
  String Name = "Bahasa Jawa";

  public void setSemester(int Semester) {
    Semesterku = Semester;
  }

  // Getter
  public int getSemester(){
    return Semesterku;
  }

  // Penggunaan Polimorphism (Overriding)
  public String Ketuntasan(){
    return "Absensi juga berpengaruh terhadap ketuntasan";
  }

  // Penggunaan super
  public void Cetak(){
    // Penggunaan super
    System.out.println("Nama Mahasiswa = " + super.Name);
    // Penggunaan this
    System.out.println("Mata Kuliah Favorit = " + this.Name);
  }
}

// superclass abstract (Abstract Class)
abstract class Penilaian{
  int Kehadiran, UjianAkhir;
  // Abstract Method
  abstract double Hitung();
}

//subclass dari superclass abstract
class PBO extends Penilaian {

  //PBO adalah constructor
  public PBO (int Kehadiran, int UjianAkhir) {
    this.Kehadiran = Kehadiran;
    this.UjianAkhir = UjianAkhir;
  }

  double Hitung() {
    return ((0.1*Kehadiran)+(1*UjianAkhir));
  }
}

//subclass dari superclass abstract
class DDP extends Penilaian {

  //DDP adalah  constructor
  public DDP (int Kehadiran, int UjianAkhir) {
    this.Kehadiran = Kehadiran;
    this.UjianAkhir = UjianAkhir;
  }
  
  double Hitung() {
    return ((0.1*Kehadiran)+(1*UjianAkhir));
  }
}

// Penerapan Interface
interface Praktikum {
  public float cekNilaiAkhir(int Posttest, int Activity, int Pretest);
  public String cekKelulusan(int NilaiAkhir);
}

class Praktikan {
  private Praktikum lep;

  public Praktikan(Praktikum lep) {
    this.lep = lep;
  }

  void prosesCekNilaiAkhir(int Posttest, int Activity, int Pretest){
    // Menampilkan hasil akhir ujian Praktikum
    System.out.println("Nilai akhir ujian Praktikum anda = "+ this.lep.cekNilaiAkhir(Posttest, Activity, Pretest));
  }

  void prosesCekKelulusan(int NilaiAkhir){
    System.out.println("Status Kelulusan Praktikum = "+this.lep.cekKelulusan(NilaiAkhir));
  }
}

class Proses implements Praktikum {
  float NilaiAkhir;
  String StatusKelulusan;

  public float cekNilaiAkhir(int Posttest, int Activity, int Pretest){
    return (Posttest + Activity + Pretest)/3;
  }
  
  public String cekKelulusan(int NilaiAkhir) {
    if (NilaiAkhir <= 80) {
      return "Anda Tidak Lulus";
    } else {
      return "Anda Lulus";
    }
  } 
}

// Penggunaan Overloading
class UKM {
  public final void namaUKM() {
    String ukm = "Himpunan Mahasiswa";
    System.out.println("Organisasi yang diikuti = " + ukm);
  }

  public final void namaUKM(String ukm) {
    System.out.println("UKM yang diikuti = " + ukm);
  }
}

// //Pembuktian method final
// class UKMExt extends UKM {
//    public void namaUKM() {
//     String ukm = "SepakBola";
//     System.out.println("Nama UKM dari Method pertama di class UKM = " + ukm);
//   }
// }

class Main {
  public static void main(String[] args) {
    System.out.println("=================================");
    System.out.println("      NILAI AKHIR DDP DAN PBO");
    System.out.println("=================================");
    Mahasiswa Biodata = new Mahasiswa();
    Matkul M1 = new Matkul();
    
    // Hasil dari Enkapsulasi, Inheritance,
    Biodata.Nama = "Budi";
    Biodata.NIM = "2100019999";
    Biodata.setNilai(91);
    M1.setSemester(3);
    
    System.out.println(" ");
    System.out.println("Nama     = " + Biodata.Nama);
    System.out.println("NIM      = " + Biodata.NIM);
    System.out.println("Nilai Rata Rata Akhir  = " + Biodata.getNilai());
    System.out.println("Semester = " + M1.getSemester());
    System.out.println(" ");

    // Hasil dari super
    M1.Cetak();
    System.out.println(" ");

    // Hasil dari Polymorphism, Overriding Method
    // Class Mahasiswa
    System.out.println("Catatan 1 = " + Biodata.Ketuntasan());
    // Class Matkul
    System.out.println("Catatan 2 = " + M1.Ketuntasan());

    System.out.println(" ");
    // Hasil dari Abstract Class, Abstract Method, dan Constructor
    Penilaian PBOB = new PBO(14,90);
    Penilaian DDPO = new DDP(10,90);

    System.out.println("Nilai Mata Kuliah PBO = " + PBOB.Hitung());
    System.out.println("Nilai Mata Kuliah DDP = " + DDPO.Hitung());

    // // Hasil dari Interface
    System.out.println(" ");
    Praktikum Periksa = new Proses();
    Praktikan Siswa = new Praktikan(Periksa);
    Siswa.prosesCekNilaiAkhir(90,90,100);
    Siswa.prosesCekKelulusan(95);

    // // Hasil dari Overloading
    System.out.println(" ");
    UKM UAD = new UKM();
    UAD.namaUKM();
    UAD.namaUKM("Sepak Bola");

  }
}
