## Test Doubles
Test Doubles測試替身的種類可以分得很細：
 - Stub
 - Mock
 - Fake
 - Spy
 - Dummy


## 比較Fake，Stub，Mock：

當想要配置替換的相依物件的行為時，使用Stub。 

當想要配置替換的相依物件的行為，並且驗證待測系統與模擬物件之間的互動時，則使用Mock。 

當不想要配置替換的相依物件的行為，且不想要驗證驗證待測系統與模擬物件之間的互動；\
只用一個與真實物件一樣的Test Double替換時，則使用Fake。