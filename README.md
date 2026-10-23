# 🪼 JellyFish — Takım Görev Yönetimi

Kulüp takımları için gerçek zamanlı görev dağıtım ve rapor toplama uygulaması. Danışman takımları kurar, tüm görevleri izler ve öğrenci raporlarını değerlendirir. Takım üyeleri kendi takımlarında görev oluşturur, birden fazla kişiye atar, durumunu günceller, belge ekler, birbirine devreder (paslar) ve danışmana rapor gönderir. Her takım yalnızca kendi görevlerini görür.


## 👩‍🎓 Öğrenciler için: nasıl kullanırım?

Hiçbir şey indirmenize gerek yok.

1. Danışmanınızın paylaştığı bağlantıyı açın: **`https://seyitalikara.github.io/jellyfish/`**
2. **Takım Üyesi** sekmesine geçin.
3. Danışmanın verdiği **Kulüp Kodunu** yazın.
4. Adınızı, **kişisel şifrenizi** (en az 4 karakter), alanınızı ve takımınızı seçip **Takıma Katıl**'a basın.

> **Kişisel şifre:** İlk girişte yazdığınız şifre hesabınıza kilitlenir. Başka bir cihazdan girerken adınızı **aynı şekilde** ve **aynı şifreyle** yazın. Şifrenizi unutursanız danışmanınız sıfırlayabilir.

### ✅ Görevler

- **Görev Ekle** ile yeni görev açın. **Atanan Kişiler** listesinden bir veya birden fazla kişiyi işaretleyin.
- Göreve tıklayınca detay açılır. **Durumu değiştir** düğmeleriyle Yapılacak / Devam Ediyor / Beklemede / Tamamlandı arasında geçiş yapın. Bilgisayarda kartı sütunlar arasında sürükleyip bırakabilirsiniz.
- **Belgeler → Belge yükle** ile göreve dosya ekleyin (PDF, Word, Excel, PowerPoint, resim, CAD, ZIP…, en fazla 10 MB). Takım arkadaşlarınız indirebilir.
- Kendi oluşturduğunuz görevi detaydaki **Sil** ile silebilirsiniz.
- **Bu görev bitince bildirim gönder** bölümünden başka bir takım seçerseniz, görev tamamlandığında o takıma haber gider.

### 📄 Rapor gönderme

1. Sol menüden **Raporlarım**'a tıklayın.
2. Rapor başlığını yazın, isterseniz kısa bir not ekleyin.
3. **PDF veya Word** (.pdf, .doc, .docx, en fazla 10 MB) dosyanızı sürükleyip bırakın ya da tıklayıp seçin.
4. **Raporu Gönder**'e basın.

- Raporunuzu yalnızca **siz ve danışmanınız** görebilir; takım arkadaşlarınız göremez.
- Danışman değerlendirene kadar raporu silip yeniden gönderebilirsiniz.
- Geri bildirim gelince bildirim alırsınız. Danışmanın yorumu ve varsa yorumlu dosyası raporun altında görünür.
- **Revizyon istendi** ise **Revize sürüm yükle** düğmesiyle düzeltilmiş sürümü gönderin.

Telefonda: bağlantıyı açın, ardından tarayıcı menüsünden "Ana ekrana ekle"yi seçin.

## 🧑‍🏫 Danışman için

### Raporları değerlendirme

1. Sol menüden **Raporlar**'a tıklayın. Değerlendirilmeyi bekleyen rapor sayısı menüde turuncu rozetle görünür.
2. Raporları takıma, duruma veya öğrenci adına göre süzebilirsiniz.
3. **İndir** dosyayı `ÖğrenciAdı_dosya.pdf` adıyla indirir. PDF'ler için **Görüntüle** yeni sekmede açar.
4. **Değerlendir** → karar (**Onaylandı** / **Revizyon istendi**), geri bildirim metni ve isteğe bağlı olarak yorum eklediğiniz PDF/Word dosyası → **Geri Bildirimi Gönder**. Öğrenciye bildirim gider.
5. Verdiğiniz geri bildirimi daha sonra **Düzenle** ile değiştirebilirsiniz.

### Öğrenci şifresi sıfırlama

Takım ekranında **Üyeler** → öğrencinin yanındaki **Şifre sıfırla**. Öğrenci bir sonraki girişinde yeni şifre belirler.

### İlk kurulum ve yayınlama

İlk kurulum (Firebase projesi, güvenlik kuralları, anonim giriş) için **[FIREBASE_KURULUM.md](FIREBASE_KURULUM.md)** dosyasına bakın.

GitHub Pages ile yayınlama:

1. GitHub'da `JellyFish` adında **public** bir depo oluşturun.
2. `index.html`, `database.rules.json`, `README.md`, `FIREBASE_KURULUM.md` dosyalarını yükleyin ("Add file → Upload files").
3. Depoda **Settings → Pages → Branch: `main` / `(root)` → Save**.
4. 1-2 dakika sonra uygulama `https://KULLANICI-ADI.github.io/JellyFish/` adresinde yayında olur. Bu bağlantıyı öğrencilerle paylaşın.

> ⚠️ **Sürüm güncellerken:** `database.rules.json` değiştiyse içeriğini Firebase Console → Realtime Database → **Rules** sekmesine yapıştırıp **Publish** demeyi unutmayın. GitHub'a yüklemek kuralları Firebase'e aktarmaz.

## 🔐 Güvenlik

- `index.html` içindeki Firebase bilgileri **gizli şifre değildir**. Google bunların web sayfasında görünmesini normal kabul eder.
- Veriyi `database.rules.json` içindeki kurallar korur:
  - Yalnızca uygulamadan giriş yapanlar veriye erişebilir (Firebase Anonim Giriş).
  - **Takım oluşturma ve üye ekleme** yalnızca danışmana açıktır.
  - Öğrenciler **yalnızca kendi takımlarının** görevlerini ve belgelerini görebilir, ekleyebilir ve güncelleyebilir. Başka takıma görev atanamaz.
  - Öğrenci yalnızca **kendi oluşturduğu görevi** ve **kendi yüklediği belgeyi** silebilir. Danışman hepsini silebilir.
  - **Raporlar ve dosyaları** yalnızca raporu gönderen öğrenci ve danışman tarafından okunabilir. Geri bildirimi yalnızca danışman yazabilir.
  - Danışman ve öğrenci şifreleri veritabanında açık metin olarak tutulmaz. Yalnızca SHA-256 özeti saklanır ve bu özeti kimse okuyamaz.
- Kulüp kodunu yalnızca kendi öğrencilerinizle paylaşın.

## 📁 Dosyalar

| Dosya | Açıklama |
|---|---|
| `index.html` | Uygulamanın tamamı (tek dosya) |
| `database.rules.json` | Firebase Realtime Database güvenlik kuralları |
| `FIREBASE_KURULUM.md` | Danışman için adım adım Firebase kurulumu |
