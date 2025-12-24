# RentTrack 🚗

RentTrack, araç kiralama süreçlerini takip etmek ve yönetmek için geliştirilmiş bir Android uygulamasıdır. Uygulama; araç ekleme, araç listeleme, müşteri bilgileri, kiralama oluşturma ve kiralama detaylarını görüntüleme gibi temel fonksiyonları içerir.

📱 Özellikler

* 🚘 Araç ekleme ve araç listesi görüntüleme
* 👤 Müşteri bilgileri yönetimi
* 📄 Araç kiralama oluşturma
* 🧾 Kiralama detaylarını görüntüleme
* 🗄️ Room Database ile yerel veri saklama

 🛠️ Kullanılan Teknolojiler

Dil: Java
Platform: Android
Veritabanı: Room (SQLite)
Mimari: Repository Pattern
Build System: Gradle (Kotlin DSL)

 📂 Proje Yapısı

```
RentTrack/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/renttrack/
│   │   │   │   ├── database/        # Room Database, DAO, Entity ve Repository
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── AracEkleActivity.java
│   │   │   │   ├── MyCarsActivity.java
│   │   │   │   ├── RentalCreateActivity.java
│   │   │   │   └── RentalDetailsActivity.java
│   │   │   └── AndroidManifest.xml
│   └── build.gradle.kts
└── README.md
```

 🚀 Kurulum

1. Bu repoyu klonlayın:

   ```bash
   git clone https://github.com/kullaniciadi/RentTrack.git
   ```
2. Android Studio ile projeyi açın.
3. Gerekli Gradle bağımlılıklarının yüklenmesini bekleyin.
4. Uygulamayı bir emülatör veya fiziksel cihazda çalıştırın.

 🧩 Veritabanı Yapısı

Uygulama, Room Database kullanır.

* `Arac` Entity: Araç bilgilerini tutar
* `AracDao`: Araçlar için CRUD işlemleri
* `AppDatabase`: Room veritabanı yapılandırması
* `AracRepository`: Veri erişim katmanı

 ✨ Geliştirme Fikirleri

* 🔐 Kullanıcı girişi (Auth)
* ☁️ Firebase / Cloud senkronizasyonu
* 📊 Kiralama istatistikleri ve raporlar
* 🎨 UI/UX iyileştirmeleri

 📄 Lisans

Bu proje eğitim ve kişisel kullanım amaçlıdır.

---

Her türlü geri bildirim ve katkıya açıktır 🙂
