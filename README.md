# 🪼 JellyFish — Takım Görev Yönetimi

Kulüp takımları için gerçek zamanlı görev dağıtım uygulaması. Danışman takımları kurar ve tüm görevleri izler. Takım üyeleri görev oluşturur, tamamlar ve birbirine devreder (paslar).

## 👩‍🎓 Öğrenciler için: nasıl kullanırım?

Hiçbir şey indirmenize gerek yok.

1. Danışmanınızın paylaştığı bağlantıyı açın: **`https://KULLANICI-ADI.github.io/JellyFish/`**
2. **Takım Üyesi** sekmesine geçin.
3. Danışmanın verdiği **Kulüp Kodunu** yazın.
4. Adınızı, alanınızı ve takımınızı seçip **Takıma Katıl**'a basın.

> Aynı tarayıcıdan tekrar girdiğinizde oturumunuz açık kalır. Başka bir cihazdan girerken adınızı **aynı şekilde** yazın.

Telefonda: bağlantıyı açın, ardından tarayıcı menüsünden "Ana ekrana ekle"yi seçin.

## 🧑‍🏫 Danışman için: yayınlama

İlk kurulum (Firebase projesi, güvenlik kuralları, anonim giriş) için **[FIREBASE_KURULUM.md](FIREBASE_KURULUM.md)** dosyasına bakın.

GitHub Pages ile yayınlama:

1. GitHub'da `JellyFish` adında **public** bir depo oluşturun.
2. `index.html`, `database.rules.json`, `README.md`, `FIREBASE_KURULUM.md` dosyalarını yükleyin ("Add file → Upload files").
3. Depoda **Settings → Pages → Branch: `main` / `(root)` → Save**.
4. 1-2 dakika sonra uygulama `https://KULLANICI-ADI.github.io/JellyFish/` adresinde yayında olur. Bu bağlantıyı öğrencilerle paylaşın.

## 🔐 Güvenlik

- `index.html` içindeki Firebase bilgileri **gizli şifre değildir**. Google bunların web sayfasında görünmesini normal kabul eder.
- Veriyi `database.rules.json` içindeki kurallar korur:
  - Yalnızca uygulamadan giriş yapanlar veriye erişebilir (Firebase Anonim Giriş).
  - **Takım oluşturma, görev silme ve üye ekleme** yalnızca danışmana açıktır.
  - Öğrenciler görev ekleyebilir, güncelleyebilir, tamamlayabilir ve paslayabilir, ama **silemez**.
  - Danışman şifresi veritabanında açık metin olarak tutulmaz. Yalnızca SHA-256 özeti saklanır ve bu özeti kimse okuyamaz.
- Kulüp kodunu yalnızca kendi öğrencilerinizle paylaşın.

## 📁 Dosyalar

| Dosya | Açıklama |
|---|---|
| `index.html` | Uygulamanın tamamı (tek dosya) |
| `database.rules.json` | Firebase Realtime Database güvenlik kuralları |
| `FIREBASE_KURULUM.md` | Danışman için adım adım Firebase kurulumu |
