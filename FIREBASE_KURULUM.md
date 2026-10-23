# 🪼 JellyFish — Firebase Kurulum Kılavuzu (Danışman)

Bu kurulum **bir kez** yapılır. Öğrencilerin hiçbir ayar yapmasına gerek kalmaz.

> **Firebase projeniz zaten varsa** 1. ve 3. adımları atlayın. 2, 4, 5 ve 6. adımları mutlaka yapın.
>
> **v1.2'den v1.3'e geçiyorsanız:** **5. adımı** (kuralları yeniden yükleme) yapın, ardından **bir kez danışman olarak giriş yapın**. Ayrıntılar: [v1.3 güncelleme notları](#-v13-güncelleme-notları-takım-gizliliği-çoklu-atama-belgeler).

---

## 1. Firebase projesi oluşturun

1. [console.firebase.google.com](https://console.firebase.google.com) → **Add project**
2. Proje adı girin (örn. `jellyfish-kulubu`). Google Analytics'i kapatabilirsiniz.
3. **Build → Realtime Database → Create database** → Lokasyon: **europe-west1** → **Start in locked mode**

## 2. Anonim girişi açın

1. **Build → Authentication → Get started**
2. **Sign-in method** sekmesi → **Anonymous** → **Enable** → **Save**

> Öğrenciler e-posta hesabı açmaz. Uygulama her tarayıcıya arka planda otomatik bir kimlik verir. Öğrenci, kişisel şifresiyle bu kimliği kendi hesabına bağlar. Güvenlik kuralları bu kimliği kullanır.

## 3. Web uygulaması bilgilerini alın

1. ⚙️ **Project settings → Your apps → `</>` (Web)** → takma ad girin → **Register app**
2. Çıkan `firebaseConfig` değerlerini not alın (apiKey, authDomain, databaseURL, projectId, appId).
   Mevcut projede bu bilgiler aynı sayfada, **Your apps** bölümünde durur.

## 4. Bilgileri `index.html` içine yazın

`index.html` dosyasını Not Defteri / VS Code ile açın. `EMBEDDED_CONFIG` satırını arayın (Ctrl+F) ve tırnakların içini doldurun:

```javascript
const EMBEDDED_CONFIG = {
  apiKey: "AIzaSy...",
  authDomain: "jellyfish-kulubu.firebaseapp.com",
  databaseURL: "https://jellyfish-kulubu-default-rtdb.europe-west1.firebasedatabase.app",
  projectId: "jellyfish-kulubu",
  storageBucket: "",
  messagingSenderId: "",
  appId: "1:123456789:web:abc123"
};
```

Kaydedin. Artık uygulama açıldığında kurulum ekranı çıkmaz, doğrudan giriş ekranı gelir.

## 5. Güvenlik kurallarını yükleyin ⚠️ (önemli)

1. **Realtime Database → Rules** sekmesi
2. Mevcut içeriğin **tamamını silin**.
3. `database.rules.json` dosyasının içeriğini yapıştırın → **Publish**

> Eski kılavuzdaki `".read": true, ".write": true` kuralı veritabanını herkese açık bırakıyordu. Bu adımla o açık kapanır.
>
> `database.rules.json` her değiştiğinde (örneğin yeni sürüme geçerken) bu adımı tekrarlayın. Kurallar yüklenmezse rapor gönderme **"Bu işlem için yetkiniz yok"** hatası verir.

## 6. İlk danışman girişi

1. Uygulamayı açın → **Danışman** sekmesi
2. **Kulüp Kodu** (örn. `JELLYFISH2025`) ve en az 6 karakterli bir **Danışman Şifresi** girin.
3. Yeni kod girdiyseniz kulüp otomatik oluşturulur ve şifre o kulübe kilitlenir.

> **Eski sürümde kulübünüz varsa:** Kuralları yükledikten hemen sonra **ilk danışman girişini siz yapın**. Eski kulüplerde şifre yeni sisteme ilk danışman girişinde aktarılır. Bu sırada veritabanındaki açık metin `adminPass` alanı da otomatik silinir. İsterseniz bu girişte yeni bir şifre de belirleyebilirsiniz.

Ardından **Takım Oluştur** ile takımları kurun ve öğrencilere kulüp kodunu ve uygulama bağlantısını verin.

---

## 🔒 v1.3 güncelleme notları (takım gizliliği, çoklu atama, belgeler)

1. **Kuralları yeniden yükleyin** (5. adım). Yeni kurallar `uidMember`, `teamList` ve `taskFiles` bölümlerini ekler ve takımları birbirinden ayırır.
2. **Hemen ardından bir kez danışman olarak giriş yapın.** Uygulama, öğrencilerin giriş ekranında gördüğü takım listesini (`teamList`) bu girişte oluşturur. Bu yapılmazsa öğrenciler takım listesinde *"Takım bulunamadı"* görür.
3. Öğrencilerin bir şey yapmasına gerek yok. Açık oturumlar sayfa yenilenince yeni kurallarla çalışır.

Yenilikler:
- **Takım gizliliği:** Öğrenci yalnızca kendi takımının görevlerini görür ve yalnızca kendi takımına görev ekleyebilir. Bu, Firebase kurallarıyla da zorunlu tutulur. Başka takım yalnızca adıyla, "bitince bildirim gönder" listesinde görünür.
- **Çoklu atama:** Bir göreve birden fazla kişi atanabilir. Eski tek kişilik görevler olduğu gibi çalışır.
- **Durum değiştirme:** Görev detayında 4 durum düğmesi (Yapılacak / Devam Ediyor / Beklemede / Tamamlandı) ve bilgisayarda kartı sütunlar arasında sürükle-bırak.
- **Görev belgeleri:** Her göreve PDF, Word, Excel, PowerPoint, resim, CAD (DWG, DXF, STEP, STL, SolidWorks), ZIP gibi dosyalar eklenebilir (en fazla 10 MB). Belgeyi takım üyeleri ve danışman görür; yalnızca yükleyen kişi ve danışman siler.
- **Görev silme:** Görevi oluşturan öğrenci ve danışman silebilir. Görev silinince belgeleri de silinir.
- **"Bu görev bitince bildirim gönder":** Artık doğrudan takım seçilir. Görev tamamlanınca seçilen takımın tüm üyelerine bildirim gider.

## 📄 v1.2 güncelleme notları (rapor modülü)

- **Kuralları yeniden yükleyin** (5. adım). Yeni kurallar `memberSecrets`, `reportFiles`, `memberUids`, `reports` ve `feedback` bölümlerini ekler.
- **Öğrencilere kişisel şifre geldi.** Güncellemeden sonra uygulamayı açan öğrenciler bir kez giriş ekranına yönlendirilir. Adları ve takımları önceden doldurulur. Bir kişisel şifre belirleyip yeniden girerler. İlk yazılan şifre o öğrenciye kilitlenir.
  - Öğrencilere duyurun: *"Uygulamaya ilk girişinizde kendi şifrenizi belirleyin. Başkası sizin adınızla sizden önce giriş yaparsa bana haber verin."* Böyle bir durumda **Üyeler → Şifre sıfırla** ile hesabı serbest bırakın.
- **Dosyalar nerede saklanıyor?** Rapor dosyaları Firebase Storage'da değil, Realtime Database içinde parçalara bölünerek (`reportFiles/...`) saklanır. Böylece **kredi kartı / ücretli plan gerekmez.** Dosya sınırı 10 MB'tır.
- **Kapasite (ücretsiz Spark planı):** 1 GB veritabanı alanı ve aylık 10 GB indirme. Dosyalar %33 büyüyerek saklanır. Örneğin 2 MB'lık raporlarla yaklaşık 350–400 rapor sığar. Alan dolmaya yaklaşırsa eski dönemlerin raporlarını uygulamadan silin ya da Firebase Console'dan `reportFiles` altını yedekleyip temizleyin. Kullanımı **Realtime Database → Usage** sekmesinden izleyebilirsiniz.

---

## 👀 Görev dağılımını izleme

- **Uygulamada:** Danışman olarak girince **Genel Bakış** ekranında tüm takımları, üyeleri ve görevlerin durumunu görürsünüz. Bir takıma tıklayınca o takımın Kanban panosu açılır.
- **Raporlar:** Sol menüdeki **Raporlar** ekranında tüm öğrencilerin raporları, durumları ve verdiğiniz geri bildirimler durur.
- **Firebase Console'da:** Realtime Database → **Data** sekmesinde `clubs/KULUP_KODU/teams` altında ham veri durur.
- **Yedek:** Data sekmesi → sağ üstteki ⋮ menüsü → **Export JSON**

## 🔐 Kim ne yapabilir?

| İşlem | Danışman | Öğrenci |
|---|:---:|:---:|
| Takımları ve görevleri görme | ✅ (tümü) | Yalnızca kendi takımı |
| Takım oluşturma / takım bilgilerini düzenleme | ✅ | ❌ |
| Takıma üye ekleme | ✅ | Yalnızca kendini (katılırken) |
| Görev ekleme / düzenleme / durum değiştirme / paslama | ✅ | Yalnızca kendi takımında |
| Görev silme | ✅ | Yalnızca kendi oluşturduğu görev |
| Göreve belge ekleme / indirme | ✅ | Yalnızca kendi takımında |
| Görev belgesini silme | ✅ | Yalnızca kendi yüklediği belge |
| Rapor gönderme | — | ✅ (yalnızca kendi adına) |
| Raporları görme / indirme | ✅ (tümü) | Yalnızca kendi raporları |
| Geri bildirim yazma / dosya ekleme | ✅ | ❌ |
| Rapor silme | ✅ | Yalnızca kendi raporu, değerlendirilmeden önce |
| Öğrenci şifresini sıfırlama | ✅ | ❌ |
| Danışman / öğrenci şifresini görme | ❌ (kimse göremez) | ❌ |

## ❓ Sık sorulan sorular

**Danışman şifremi unuttum / değiştirmek istiyorum.**
Firebase Console → Realtime Database → Data → `clubSecrets/KULUP_KODU` düğümünü silin. Ardından uygulamaya **yeni şifreyle** danışman olarak girin; yeni şifre kaydedilir. Bu işlemi yaptıktan hemen sonra giriş yapın.

**Öğrenci kişisel şifresini unuttu.**
Uygulamada takımı açın → **Üyeler** → öğrencinin yanında **Şifre sıfırla**. Öğrenci bir sonraki girişinde yeni şifre belirler. Raporları silinmez.

**Bir öğrenci "Bu işlem için yetkiniz yok" hatası alıyor.**
Başka takımın görevine dokunmaya ya da başkasının oluşturduğu görevi silmeye çalışıyordur. Bu beklenen bir davranış. Kendi takımında bile bu hatayı alıyorsa sayfayı yenileyip tekrar giriş yapsın. Rapor gönderirken bu hata çıkıyorsa güncel `database.rules.json` yüklenmemiştir (5. adım).

**Uygulama "Anonim giriş kapalı" diyor.**
2. adım yapılmamış. Authentication → Sign-in method → Anonymous'u açın.

**Ücretsiz plan yeterli mi?**
Spark planında 1 GB depolama, aylık 10 GB indirme ve 100 eş zamanlı bağlantı sınırı var. Bir kulübün görevleri ve dönemlik raporları için yeterli. Kapasite hesabı için yukarıdaki v1.2 notlarına bakın.

---

*JellyFish v1.3 — Kulüp Görev Yönetimi ve Rapor Takibi*
