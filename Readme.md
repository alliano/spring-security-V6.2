# Apa itu Spring Security
Spirng security adalah sebuah framework atau kerangka kerja yang menyediakan fitur autentikasi, autorisasi dan prlindungan dari serangan exploitasi yang menyerang applikasi kita, danjuga Spring secuirity ini adalah standar keamanan appliaksi berbasis teknologin Spring.

# Instalasi
Unutuk mengimplementasikan spring secutiry, kita haurus membuat project spirng nya terlebih dahulu [spring initializer](https://start.spring.io/) dengan setingan sebagai berukut :
[initialize](https://github.com/alliano/spring-security-V6.2/blob/master/src/main/resources/imgs/inisialize.jpg)

Untuk menggunakan Spring security ada beberapa hal yang harus dilakukan terlebih dahulu, yaitu menambahkan beberapa dependency salahsatunya dependency spring security pada project spirng kita, agar nantinya kita bisa menggunakan module-module yang kita butuhkan, berikut ini adalah dependency yang harus ditambahkan kedalam file pom.xml project kita :
[dependencies](https://github.com/alliano/spring-security-V6.2/blob/master/src/main/resources/imgs/dependencies.jpg)

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
Karna kita akan membangun Applikasi yang berbasis RestFull API maka kita membuhkan dependency web.
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