package com.muthohhari.myrecyclerview;

import com.muthohhari.myrecyclerview.model.Pariwisata;

import java.util.ArrayList;

public class DataPariwisata {
    private static String[][] data = new String[][]{
            {"Kaliadem","https://cdn.idntimes.com/content-images/post/20180729/7b2dda850640d4d4e75a5628534bd5d5.jpg","Kalau pernah liat posting-an temanmu berfoto dengan latar Gunung Merapi yang gagah tepat di belakangnya, itu pasti di kawasan Kaliurang. Tepatnya di Bungker Kaliadem. Selain bisa belajar banyak tentang sejarah letusan Gunung Merapi, kamu juga bisa menemukan innerpeace, karena hawanya sejuk, sepi, dan bisa banget buat melepas penat. Kalau kamu sudah bisa foto seperti di atas ini, selamat level petualanganmu baru saja naik satu tingkat!"},
            {"Wisata Kalibiru","https://cdn.idntimes.com/content-images/post/20180729/beae785c026960cfbfd1ff09d34b00d1.jpg","Lokasinya ada di bagian barat Yogyakarta. Buat kamu yang gak alergi dengan ketinggian, tempat ini jadi destinasi yang seru banget. Kamu bisa berfoto di atas ketinggian dari sebuah panggung dan pohon, dengan latar belakang jurang. Tenang saja, kamu bakal dibekali dengan alat pengaman ketika naik panggung tinggi, kok. Jadi tetap nyaman dan aman saat berfoto ria."},
            {"Embung Nglanggeran Gunung Kidul","https://cdn.idntimes.com/content-images/post/20180729/abf0887bd73f35107c848f82d8d73d85.jpg","Dari barat kita bergeser ke timur Yogyakarta, tepatnya di daerah Gunung Kidul. Embung Nglanggeran merupakan danau buatan yang dulunya diperuntukkan sebagai irigasi masyarakat sekitar. \n Namun potensi wisata yang besar, membuat danau dengan pemandangan sangat menawan ini jadi tempat pelesiran favorit di Gunung Kidul. Kamu bisa ke sini kapan saja, karena buka 24 jam. Lokasinya berada di Nglanggeran, Patuk, Yogyakarta."},
            {"Gunung Api Purba","https://cdn.idntimes.com/content-images/post/20180729/4fb32bd4409c7baaa74ee575b1b5d75b.jpg","Gak jauh dari Embung Nglanggeran, ada bukit berbatu yang namanya Gunung Api Purba. Tampak begitu eksotis dari kejauhan. Cobalah untuk mendakinya. Cuma butuh waktu 45-60 menit berjalan santai untuk tiba dipuncaknya. Yakin deh, capeknya setimpal dengan pemandangan yang bakal kamu dapat."},
            {"Gua Jomblang","https://cdn.idntimes.com/content-images/post/20180729/16ebebc96c2afbde8ad589a6f7aa2bb6.jpg","Masih di Gunung Kidul, kita bisa merasakan sensasi susur gua yang menakjubkan di Pacarejo, Semanu. Gua Jomblang ini sudah jadi destinasi atau tempat wisata kelas dunia lho!\n" +
                    "\n" +
                    "Banyak wisatawan mancanegara yang sengaja berkunjung ke sini. Salah satu alasannya adalah spot \"cahaya surga\" yang amat indah dan cuma bisa kita dapatkan di mulut gua. Oh iya karena wisata ini sangat istimewa, tiket wisata susur gua ini juga lumayan \"menantang\". Dengan harga Rp450 ribu sekali masuk, tapi pastinya kamu gak bakal kecewa."},
            {"Tebing Breksi","https://cdn.idntimes.com/content-images/post/20180729/0c6e93f35d316dbc9ed1a3936d2f159a.jpg","Bekas lokasi tambang ini berubah jadi destinasi aestetik yang tak pernah sepi pengunjung. Dari sini kita bisa menikmati pemandangan kota Yogyakarta, Candi Prambanan, dan Gunung Merapi. Lokasinya mudah dicapai dan gak jauh dari kota Yogya, yakni di kawasan Sambirejo, Prambanan. Jangan lupa bawa payung waktu berkunjung siang bolong, karena mataharinya terik sekali."},
            {"Pinus Pengger Dlingo","https://cdn.idntimes.com/content-images/post/20180729/8c3c2648360ea919e9fcff1c334a8789.jpg","Tempatnya asri, adem, dan enak buat refreshing. Spot fotonya sangat kekinian dan bagus untuk foto siang maupun malam hari. Di spot Pancawara dan Cetta Abipraya misalnya, yang cocok buat foto saat malam hari dengan latar belakang gemerlap lampu kota Yogya. Tidak perlu khawatir buat yang tidak memiliki kamera, karena disini ada jasa fotografi yang sangat membantu, apalagi saat foto di malam hari. Romantis abis!"},
            {"Gumuk Pasir","https://cdn.idntimes.com/content-images/post/20180729/a28195f4f33ecb7ac695bcf98e443935.jpg","Terakhir dari pantai selatan Yogya. Di sini kita bisa bebas berfoto ala padang pasir di Dubai. Jika kamu pecinta olahraga antimainstream, padang pasir berwarna hitam ini juga cocok untuk bermain sandboarding."},
            {"Hutan Pinus Mangunan","https://cdn.idntimes.com/content-images/post/20180729/b6bf9abaa65861a8822cb4884d06b40c.jpg","Kita bergeser lagi ke selatan. Hutan Pinus Manungan harus kamu kunjungi untuk mengumpulkan foto-foto Instagramable lainnya di Yogyakarta. Hutan Pinus ini sangat fotogenic, mau gaya gimana pun, nanti hasilnya pasti akan tetap keren. Sejauh mata memandang hanya pohon pinus yang terlihat, tapi kamu bisa melakukan banyak hal disini. Misalnya seperti bersantai di atas hammock dan menikmati udara yang sejuk. Chill abis!"}
    };

    public static ArrayList<Pariwisata> getListData() {
        Pariwisata pariwisata = null;
        ArrayList<Pariwisata> list = new ArrayList<>();
        for (String[] aData : data) {
            pariwisata = new Pariwisata();
            pariwisata.setName(aData[0]);
            pariwisata.setPhoto(aData[2]);
            pariwisata.setDescription(aData[3]);

            list.add(pariwisata);
        }

        return list;
    }
}
