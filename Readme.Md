# TUTORIAL ADPRO
### William - 2206083432
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sunsetheus_tutorial-1&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=sunsetheus_tutorial-1)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=sunsetheus_tutorial-1&metric=coverage)](https://sonarcloud.io/summary/new_code?id=sunsetheus_tutorial-1)

[Link website hasil deploy](https://eshop-sunsetheus-eshop.koyeb.app/)
## Reflection 1
<br>
You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.

Setelah mengimplementasi
Setelah mengimplementasi dua fitur dengan menggunakan Spring Boot, saya belajar mengimplementasikan prinsip-prinsip clean code, di antaranya:
1. `Meaningful Names`, nama variabel yang saya gunakan memiliki 
arti yang self descriptive sehingga tidak perlu adanya penjelasan tambahan untuk mendeskripsikan apa yang disimpan variabel tersebut. Selain itu, nama fungsi, kelas, dan bahkan id juga self descriptive sehingga ketika saya melakukan skimming, saya langsung mendapatkan gambaran secara keseluruhan guna code tersebut.
2. `Function`, saya telah mengimplementasikan fungsi yang sederhana (chunks by chuncks) dan melakukan satu hal saja sesuai namanya, seperti create untuk membuat produk, get untuk mendapatkan produk, delete untuk menghapus produk, dan edit untuk mengedit produk.
3. `Comments`, sebenarnya saya tidak sangat sedikit menggunakan comments pada modul ini atau bahkan tidak ada karena objektif pada modul ini masih "cukup straight forward" dan belum kostumisasi fitur dengan logic tertentu. Maka dari itu, saya merasa saya telah mengimplementasikan clean code dari perspektif comments karena tidak menggunakan comments pada code yang self described.

Di sisi lain, saya juga telah mengimplementasikan prinsip-prinsip secure code, di antaranya:
1. Input data validation, saya telah menyempitkan jenis data yang bisa di-input user ketika melakukan create maupun edit product melalui penambahan required (menghindari input kosong), mengubah tipe input pada productQuantity dari text menjadi number (menghindari input di luar angka), serta menambahkan min="1" di atribut input pada productQuantity (menghindari angka nol dan negatif)

Menurut saya, kode saya masih bisa lebih clean, seperti pemisahan <srcipt> menjadi file js eksternal sehingga file html terlihat lebih rapi (lebih baik untuk jangka panjang jika kode html yang dibuat semakin rumit). Di sisi lain, saya juga menemukan cara tanpa menggunakan fungsi javascript buatan, yaitu dengan menggunakan `spring.mvc.hiddenmethod.filter.enabled=true`, tetapi belum diimplementasikan karena takut bukan best practice (layaknya kasus penggunaan any terlalu banyak typescript, tetap berfungsi tetapi kesannya "jalan cepat" dan kurang). Selain itu, implementasi functional test yang "ramah jangka panjang" juga seharusnya lebih dipertimbangkan pada awal pembuatan code sehingga memudahkan maintain kode di masa mendatang

## Reflection 2
After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?
Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!
Setelah saya membuat unit test, saya merasa lebih percaya diri dengan code saya dan realize bahwa tanpa unit testing, saya bisa saja lupa beberapa "negative input" yang membuat website saya menjadi error.
<br>
<br>
Code coverage hanya merukapan tolak ukur sebarapa full kode kita diuji (setidaknya diexecute satu kali) sehingga kita dapat mengukur kualitas kode kita, semakin rendah code coverage, maka kualitas code yang dibuat masih menjadi tanda tanya. Meskipun code coverage dapat membantu meningkatkan kualitas code yang dibuat, angka 100% pada code coverage tidak serta-merta menjadikannya aman dari error dan bugs, untuk memastikan hal tersebut perlu beragam kasus yang berbeda dalam pengetesan, sedangkan code coverage hanya mengindikasikan setidaknya satu kali eksekusi.

Penambahan tes fungsional baru dapat menurunkan kualitas dari kode tersebut dan berakibat pada munculnya masalah-masalah berikut, di antaranya:
1. `Redundan`, jika prosedur dan variabel yang dingunakan masih sama, maka penambahan tes fungsional ini hanya mengulang kode yang dibuat sebelumnya (disertai penambahan tes), kode-kode yang telah dibuat sebelumnya akan terlihat repetitif dan membuat baris-baris kode tersebut tidak terlalu berarti (sangat umum dan mengurangi readability)
2. `Ketergantungan atar tes`, jika terdapat kertengantungan antar tes, maka perubahan pada tes lain dapat menimbulkan penyesuaian pada tes lain. Hal ini mengakibatkan kode menjadi lebih kurang maintainable.

Solusi untuk mengatas hal tersebut antara lain, penggunaan setUp bersama sehingga kode-kode yang repetitif dapat teratasi lebih baik. Selain itu, perlu juga adanya pemisahan ketergantungan sehingga perubahan atau penambahan kode tidak membuat kode lama harus di-maintain secara menyeluruh, seperti penggunaan class yang tepisah pada code yang tidak bergantung.


# WEEK 2
## Refelection 4.2
List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
Code quality issue yang saya perbaiki selama mengerjakan modul, di antaranya:
- Import yang tidak diperlukan, strategi saya dalam memperbaikinya hanya dengan menghapusnya karena memang tidak digunakan. Terjadi auto import ketika saya mencoba beberapa metode dan ternyata tidak jadi saya gunakan, namun tidak saya hapus.
- Variabel yang tidak digunakan, alasannya sama dengan masalah import. Strateginya adalah dengan menghapusnya saja.
- Penggunaan public modifier, saya sempat membaca "why is this an issue?" pada sonarcloud dan ternyata JUnit5 memang lebih toleran terhadap visibility sehingga lebih aman jika dibuat tidak public (hapus visibility publicnya)
- No assertion in a test, sesuai dengan namanya, solusinya adalah memastikan setiao test ada assertionnya sehingga test yang dijalankan lebih berarti
  dan sebagainya.

Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!
<br>
<br>
Menurut saya, implementasi yang saya lakukan terkait CI/CD sudah cukup sesuai dan memnuhi definisinya CI/CD. Implementasi CI telah membuat project saya lebih terjaga integrasinya sehingga tidak rawan rusak ketima melakukan merge/pull. Selain itu terdapat pengecekan code quality issues dengan bantuan sonarcloud sehingga menjaga maintainability. Imolementasi CD, saya menggunakan Koyeb sebagai PaaS saya dan sudah diset hanya melakukan redeployment ketika terjadi perubahan pada main. Maka dari itu CI/CD skala project kecil sudah diterapkan pada project ini dan telah mengurangi waktu maintain.


# WEEK 3
Prinsip SOLID yang saya terapkan pada proyek saya meliputi
1. SRP (Single Responsibility Principle), dengan memisahkan ProductController dengan CarController karena keduanya melakukan kontrol yang berbeda. Class ProductController melakukan mapping pada Product, sedangkan Class CarController melakukan mapping pada Car.

2. OCP (Open Close Principle), dengan memastikan class yang dibuat (contoh Model) dapat dilakukan ekstensi (penambahan method yang tidak dimiliki parent-nya), tetapi tertutup pada modifikasi (mengubah yang sudah ditentukan oleh parent).

3. ISP (Interface Segregation Principle), dengan membuat interface seminimal (seumum) mungkin sehingga ketika mengimplementasi interface tersebut, developer tidak perlu mengimplementasi behave yang tidak relevant. Saya menerapkannya pada interface service yang hanya melakukan yang sudah menjadi "minimal" dalam implementasi katalog.

4. DIP (Depedency Inversion Principle), dengan mengubah depedensi pada class CarController yang awalnya menggunakan CarServiceImpl (bentuk konkrit) menjadi CarService (bentuk interface).

Keuntungan pengaplikasian prinsip SOLID
1. Kemudahan dalam pemeliharaan code (maintain). Ketika kita sudah melakukan minimalisasi code untuk setiap class (hanya melakukan 1 pekerjaan), kita akan lebih mudah melakukan pemeliharaannya. Contoh nyatanya adalah ketika terjadi bug pada fitur X, akan lebih mudah ketika kita sebelumnya sudah memisahkan implementasi fitur X, Y, Z sehingga kita tahu bahwa yang perlu di-fix adalah code di fitur Y. Akan tetapi, jika kita menggabungkan semuanya menjadi 1 folder, akan jauh lebih susah melakukan tracking code, apalagi jika sudah project skala besar yang tentunya sudah ada ratusan fungsi yang melakukan hal yang berbeda. (contohnya pemisahan controller milik product dan car)

2. Lebih mudah dipahami oleh orang lain karena code tidak menumpuk di satu bagian dengan fungsionalitasnya masing-masing. Dengan adanya pemisahan yang sepsifik, pembaca akan lebih mudah tahu bagian mana melakukan apa, terluhat lebih terstruktur, dan cepat dalam memahami keseluruhan code. (contohnya pemisahan controller product dan car, saya jadih lebih cepat mencari controller car karena sudah independen dan terpisah, jadi tidak perlu track dari file yang seharusnya tidak perlu saya buka).

3. Dengan membuat interface seminimal mungkin, saya hanya perlu memgimpelemntasikan fungsi yang saya benar-benar pasti gunakan. Jika saya membuat interface service car yang sangat spesifik (seperti ada fungsi mendapatkan mobil warna kuning, fungsi mencari nama mobil berawalan huruf W, fungsi melakukan penghapusan semua mobil, dsb yang sebenarnya belum tentu akan selalu saya gunakan untuk setiap implementasi service car. Maka akan lebih sulit dalam mengimpleemntasikan interface tersebut karena saya harus override suatu hal yang saya tidak gunakan, dengan memastikan interface seminimal mungkin, lebih mudah impleemntasi interfacenya.



Kerugian tidak mengimplementasikan SOLID
1. Sulit melakukan maintain. Ketika kita tidak melakukan minimalisasi code untuk setiap class (tidak melakukan 1 pekerjaan), kita akan lebih sulit melakukan pemeliharaannya. Contoh nyatanya adalah ketika terjadi bug pada fitur X, akan lebih sulit ketika kita harus mencari pada suatu file yang berisi fitur A, B, C, ..., Z, hal tersebut juga berpotensi terjadinya proses fix yang salah (implementasi yang tertukar dan sebagainya). Dengan menggabungkan semuanya menjadi 1 folder, akan jauh lebih susah melakukan tracking code, apalagi jika sudah project skala besar yang tentunya sudah ada ratusan fungsi yang melakukan hal yang berbeda.


2. Sulit dipahami oleh orang lain karena code menumpuk di satu bagian dengan fungsionalitasnya masing-masing. Dengan tidak adanya pemisahan yang sepsifik, pembaca akan lebih sulit tahu bagian mana melakukan apa, terlihat lebih berantakan, dan lebih lama dalam memahami keseluruhan code.

3. Dengan tidak membuat interface seminimal mungkin, saya harus memgimpelemntasikan fungsi yang tidak benar-benar saya gunakan. Jika saya membuat interface service car yang sangat spesifik (seperti ada fungsi mendapatkan mobil warna kuning, fungsi mencari nama mobil berawalan huruf W, fungsi melakukan penghapusan semua mobil, dsb yang sebenarnya belum tentu akan selalu saya gunakan untuk setiap implementasi service car. Maka akan lebih sulit dalam mengimpleemntasikan interface tersebut karena saya harus override suatu hal yang saya tidak gunakan.