package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import account.Account;

/*
 * File
Reading from file
Writing to file
 */

/*
 * PATH
 * Adalah sebuah nama alamat directory suatu file
 * Path dibagi menjadi 2, ada Absolute Path dan Dynamic Path
 * Contoh:
 * - Absolute Path:
 * D:/Game/Steam/steamapps/common/BlackDesert/BlackDesertLauncher.exe
 * 
 * - Dynamic Path:
 * ./steamapps/common/BlackDesert/BlackDesertLauncher.exe
 * 
 * Bedanya adalah kalau absolute path, misalnya pindah komputer, trus kalau file" itu tidak ditaruh di D: pasti error nantinya
 * Kalau dynamic path dia bakal ngikutin programnya ada dimana pertama kali
 * ./ itu maksudnya "di directory sekarang", jadi di asumsikan foldernya itu ada di folder Steam dari awal, jadi kalau dia mau dipindahin
 * ...ke C ke E dsb itu ga masalah
 */

/*
 * Class yang mendukung  untuk melakukan file read / file write
 * - File --> dipake dicode ini
 * - File Writer --> dipake dicode ini
 * - File Reader
 * - Scanner X File --> dipake di code ini
 * - Buffer Reader
 * - Buffer Writer
 */

public class Main {

	public Main() {
//		File currentFile = new File("latihan.txt"); //pakai yang parameternya String filename
		//otomatis nanti generate .txt nya dan munculnya di folder diluar src nanti
		//Tapi kalau hanya tulis code diatas trus di run, ga akan generate filenya, butuh method lain yaitu createNewFile()
//		File currentFile = new File("C:\\Users\\User\\eclipse-workspace\\JavaII Modul 6 VBL\\User\\latihan.txt"); //Cara absolute path
//		try {
//			currentFile.createNewFile(); //harus di try catch
//			//karena di class File itu pas createNewFile dia bakal ngelempar IOException karena takut filenya gabisa dibuat
//			//misalnya karena ga dikasih permission dll
//			System.out.println("Berhasil");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		/*
		 * Jadi di folder diluar src ada dibuat folder User untuk melihat bagaimana caranya jika ingin generate filenya ke folder itu
		 *Ada 2 cara, pakai absolute atau dynamic path
		 *- Absolute:
		 *Klik kanan folder --> properties --> copy Locationnya --> paste ke parameter File trus tambah path foldernya \\User
		 *nama filenya pake tambah \\ lagi, jadi \\latihan.txt
		 *
		 *- Dynamic:
		 *Dia bakal pakai . sebagai bantuannya
		 *Kalau tulis titik di parameternya, artinya sedang menunjuk file sekarang, yaitu folder projectnya
		 */
		//Dynamic path (sebisa mungkin pakai dynamic path biar lebih rapi dan efisien programnya bisa bekerja)
//		File currentFile = new File(".\\User\\user.txt");
//		try {
//			currentFile.createNewFile();
//			System.out.println("Berhasil");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//Mengubah nama file
//		currentFile.renameTo(new File(".\\User\\account.txt")); //isi dengan parameter file
		//dia ga secara langsung beneran rename gitu, dia lebih ke move file lamanya ke file baru ini jadi seakan-akan direname filenya
		
		//Remove file
//		File currentFile = new File("C:\\Users\\User\\eclipse-workspace\\JavaII Modul 6 VBL\\User\\latihan.txt");
//		currentFile.delete();
		
		//Read file
		//Pakai file account.txt
		//Buat file dulu yang menunjuk ke account.txt
		File currentFile = new File(".\\User\\account.txt");
		Scanner fileReader = null; //jadi bisa dipakai fileReadernya diluar try catch tapi harus diinisialisasi dulu
		try {
			//Bisa pakai Scanner
			fileReader = new Scanner(currentFile); //isi parameter dengan file yang kita buat
			//mesti try catch untuk FileNotFoundException
			//nextLine --> Baca sampai 1 line
			//next --> Baca per kata
//			String baca = fileReader.next(); //munculnya Hello
//			String baca = fileReader.nextLine(); //munculnya Hello World!
//			System.out.println(baca);
			//hasNext(); --> Sering dipakai kalau mau print file
			//Fungsinya ngecek apakah ada 1 kata lagi di selanjutnya
			//temennya hasNextLine(); --> ngecek apakah ada 1 line lagi di selanjutnya
//			while(fileReader.hasNextLine()) { //ngeprint semua di filenya
//				//bisa pakai hasNext() juga
//				String baca = fileReader.nextLine();
//				System.out.println(baca);
//			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//READ SEPARATOR
		//Misalnya format textnya yang nama#nim#role
		//kalau contoh diatas berarti pemisahnya tanda #
		//Caranya pakai split()
//		Account currentAccount = new Account();
//		String readed = fileReader.nextLine();
////		System.out.println(readed);
//		String [] Account = readed.split("#"); //parameternya itu separatornya, disini yaitu #
//		//dia returnnya adalah String []
//		//Haku#2201#Admin
//		// 0    1     2 --> indexnya di array tersebut
////		System.out.println(Account[0]);
//		currentAccount.name = Account[0];
//		currentAccount.nim = Account[1];
//		currentAccount.role = Account[2];
//		System.out.println(currentAccount.name);
		//Kalau mau nyimpan semua yang ada di file, bisa manfaatin hasNext sama Vector
		
		//READ ALL DATA AND SAVE TO VECTOR
//		Vector<Account> listAccount = new Vector<Account>();
//		while(fileReader.hasNextLine()) {
//			String readed = fileReader.nextLine();
//			String[] Account = readed.split("#");
//			Account currentAccount = new Account();
//			currentAccount.name = Account[0];
//			currentAccount.nim = Account[1];
//			currentAccount.role = Account[2];
//			listAccount.add(currentAccount);
//		}
//		for (Account account : listAccount) {
//			System.out.println(account.name);
//		}
		
		//WRITE FILE
		File canvas = new File("latihan.txt");
		//Untuk writenya pakai FileWriter
		try {
			FileWriter writer = new FileWriter(canvas); //harus di try catch
			writer.write("Hello World!"); //parameternya string yang mau di write
//			writer.write("Hello World!"); //kalau write dua kali gini, nanti hasilnya Hello World!Hello World! tanpa enter/newline
			//Disini gabisa + "\n" untuk kasih new line, caranya yaitu:
			writer.write(System.getProperty("line.separator"));
			writer.write("Hello World!");
			System.out.println("Berhasil!");
			//Beda dengan yang di read tadi, disini perlu di close soalnya ada beberapa kasus dimana nanti dia error
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//APPEND
		//Di FileWriter gabisa langsung append, harus di read dulu, ditambahin, baru append, baru di write
		//Read -> tampung ke Vector -> Append Data -> Write ulang
		//Ini bagian read -> tampung ke Vector
		Vector<Account> listAccount = new Vector<Account>();
		while(fileReader.hasNextLine()) {
			String readed = fileReader.nextLine();
			String[] Account = readed.split("#");
			Account currentAccount = new Account();
			currentAccount.name = Account[0];
			currentAccount.nim = Account[1];
			currentAccount.role = Account[2];
			listAccount.add(currentAccount);
		}
		for (Account account : listAccount) {
			System.out.println(account.name);
		}
		fileReader.close();
		//Bagian append
		Account newRegister = new Account();
		newRegister.name = "Budi";
		newRegister.nim = "22078";
		newRegister.role = "Member";
		listAccount.add(newRegister);
		//Bagian write ulang
		try {
			FileWriter fw = new FileWriter(currentFile);
			for (Account account : listAccount) {
				fw.write(account.name + "#" + account.nim + "#" + account.role);
				fw.write(System.getProperty("line.separator"));
			}
			fw.close();
			//Karena ini prosesnya bertingkat ada read dll maka readernya diatas juga sebaiknya di close ga hanya writernya
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
