# Apa itu Spring Security
Spirng security adalah sebuah framework atau kerangka kerja yang menyediakan fitur autentikasi, autorisasi dan prlindungan dari serangan exploitasi yang menyerang applikasi kita, danjuga Spring secuirity ini adalah standar keamanan appliaksi berbasis teknologin Spring.

# Instalasi
Unutuk mengimplementasikan spring secutiry, kita haurus membuat project spirng nya terlebih dahulu [spring initializer](https://start.spring.io/) :
![initialize](https://github.com/alliano/spring-security-V6.2/blob/master/src/main/resources/imgs/inisialize.jpg)

Untuk menggunakan Spring security ada beberapa hal yang harus dilakukan terlebih dahulu, yaitu menambahkan beberapa dependency salahsatunya dependency spring security pada project spirng kita, agar nantinya kita bisa menggunakan module-module yang kita butuhkan, berikut ini adalah dependency yang harus ditambahkan kedalam file pom.xml project kita :
![dependencies](https://github.com/alliano/spring-security-V6.2/blob/master/src/main/resources/imgs/dependencies.jpg)

dependency ini kita gunakan untuk otomatis mereload project spring jikalau ada perubahan pada sourcede applikasi kita.
``` xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
	<optional>true</optional>
</dependency>
```
karna kita akan menggunakan database postgreSql maka kita juga membutuhkan driver unuk kebutuhan koneksi ke postgreSql nya, berikut ini adalah dependdency untuk postgreSql.
``` xml
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
```
kita juga membutuhkan dependency Lombok untuk mengurangi kode boilerplate(kode yaang ditulus berulang-ulang kali)
``` xml
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<optional>true</optional>
</dependency>
```
Dan dependency selanutnya adalah bean validation untuk melakukan validasi yang tersetandarisasi dalam pemograman java.
``` xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
Karna kita akan membangun Applikasi yang berbasis RestFull API maka kita membutuhkan dependency web.
``` xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
dan yang terakhir adalah depencency untuk spring security 
``` xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
Setelah menambahkan dependency tersebut, selanjutnya adalah menjalankan perintah
``` bash
mvn clean install
```
untuk mendownload semua dependency spring securitynya.

# Default Config spring security
Secara defaut spring security akan menggunakan konfigurasi defaut jika kita tida meng konfigurasi spring security nya. Semua endpoin akan di proteksi oleh spring security dan spring security akan mengenerate password pada logger applikasinya untuk kebutuhan autentikasi.
Cara tersebut bukanlah best practice karna pada real case nya nanti password akan dibuat oleh user sendiri dan di hash.

# Mekanisme Spring Security
![mekanisme spring](https://github.com/alliano/spring-security-V6.2/blob/master/src/main/resources/imgs/diagramSecurity.jpg)   
saat requst pertama kali masuk, requst akan masuk pada komponen yang bernama Autehntication Filter kemudian Authentication Filter akan mendelegasikan requst tersebut kepada komponen yang bernama Authentication Manager, kemudian Authentication Manager akan menggunakan komponen Authentication Provider unutuk kebutuhan authentikasi. Pada Authentication Provider ini lah logic dari authentikasi dilakukan. Pada componen Authentication Provider ini biasanya banyak komponen yang akan terlibat untuk melakukan autentikasi, misalnya adalah kompnen UserDetails komponen ini akan digunakan unutuk mendapatkan data user detail yang ada di dalam database dan data tersebut akan di cocokan  dengan data dari requst user dengan bantuan komponen PasswordEncoder, jika data tersebut mathc/valid dengan data yang ada di database maka kompnen Authentication Provider akan mengirimkan kembali data UserDetail yang valid tersebut ke komponen Authentication Filter dan akan di simpan pada component Security Context Holder.