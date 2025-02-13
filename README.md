How to implement RxJava with Kotlin project:
1 -> include maven { url = URI("https://jitpack.io") } to setting.gradle to allow maven.
2 -> put rxJava 3 to dependency in version tom.
     #RxJava (Observable -> Speaker, Operator -> Transfer, Observer -> Lister)
     rxjava = "3.1.5"
     rxandroid = "3.0.2"
     rxandroid = { module = "io.reactivex.rxjava3:rxandroid", version.ref = "rxandroid" }
     rxjava = { module = "io.reactivex.rxjava3:rxjava", version.ref = "rxjava" }
3 -> implement those dependencies into gradle module.
     implementation(libs.rxjava)
     implementation(libs.rxandroid)

// =====>
