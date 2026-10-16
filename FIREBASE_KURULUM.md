# 🪼 JellyFish — Firebase Kurulum Kılavuzu (Danışman)

Bu kurulum **bir kez** yapılır. Öğrencilerin hiçbir ayar yapmasına gerek kalmaz.

> **Firebase projeniz zaten varsa** 1. ve 3. adımları atlayın. 2, 4, 5 ve 6. adımları mutlaka yapın.

---

## 1. Firebase projesi oluşturun

1. [console.firebase.google.com](https://console.firebase.google.com) → **Add project**
2. Proje adı girin (örn. `jellyfish-kulubu`). Google Analytics'i kapatabilirsiniz.
3. **Build → Realtime Database → Create database** → Lokasyon: **europe-west1** → **Start in locked mode**

## 2. Anonim girişi açın

1. **Build → Authentication → Get started**
2. **Sign-in method** sekmesi → **Anonymous** → **Enable** → **Save**

> Öğrenciler hesap açmaz. Uygulama her tarayıcıya arka planda otomatik bir kimlik verir. Güvenlik kuralları bu kimliği kullanır.

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

## 6. İlk danışman girişi

1. Uygulamayı açın → **Danışman** sekmesi
2. **Kulüp Kodu** (örn. `JELLYFISH2025`) ve en az 6 karakterli bir **Danışman Şifresi** girin.
3. Yeni kod girdiyseniz kulüp otomatik oluşturulur ve şifre o kulübe kilitlenir.

> **Eski sürümde kulübünüz varsa:** Kuralları yükledikten hemen sonra **ilk danışman girişini siz yapın**. Eski kulüplerde şifre yeni sisteme ilk danışman girişinde aktarılır. Bu sırada veritabanındaki açık metin `adminPass` alanı da otomatik silinir. İsterseniz bu girişte yeni bir şifre de belirleyebilirsiniz.

Ardından **Takım Oluştur** ile takımları kurun ve öğrencilere kulüp kodunu ve uygulama bağlantısını verin.

---

## 👀 Görev dağılımını izleme

- **Uygulamada:** Danışman olarak girince **Genel Bakış** ekranında tüm takımları, üyeleri ve görevlerin durumunu görürsünüz. Bir takıma tıklayınca o takımın Kanban panosu açılır.
- **Firebase Console'da:** Realtime Database → **Data** sekmesinde `clubs/KULUP_KODU/teams` altında ham veri durur.
- **Yedek:** Data sekmesi → sağ üstteki ⋮ menüsü → **Export JSON**

## 🔐 Kim ne yapabilir?

| İşlem | Danışman | Öğrenci |
|---|:---:|:---:|
| Tüm takımları ve görevleri görme | ✅ | ✅ (uygulamada yalnızca kendi takımı gösterilir) |
| Takım oluşturma | ✅ | ❌ |
| Takıma üye ekleme | ✅ | Yalnızca kendini (katılırken) |
| Görev ekleme / tamamlama / paslama | ✅ | ✅ |
| Görev düzenleme ekranı | ✅ | ❌ |
| Görev silme | ✅ | ❌ |
| Danışman şifresini görme | ❌ (kimse göremez) | ❌ |

## ❓ Sık sorulan sorular

**Danışman şifremi unuttum / değiştirmek istiyorum.**
Firebase Console → Realtime Database → Data → `clubSecrets/KULUP_KODU` düğümünü silin. Ardından uygulamaya **yeni şifreyle** danışman olarak girin; yeni şifre kaydedilir. Bu işlemi yaptıktan hemen sonra giriş yapın.

**Bir öğrenci "Bu işlem için yetkiniz yok" hatası alıyor.**
Görev silmek gibi danışmana ait bir işlem deniyordur. Bu beklenen bir davranış.

**Uygulama "Anonim giriş kapalı" diyor.**
2. adım yapılmamış. Authentication → Sign-in method → Anonymous'u açın.

**Ücretsiz plan yeterli mi?**
Spark planında 1 GB depolama, aylık 10 GB indirme ve 100 eş zamanlı bağlantı sınırı var. Bir kulüp için fazlasıyla yeterli.

---

*JellyFish v1.1 — Kulüp Görev Yönetimi*
