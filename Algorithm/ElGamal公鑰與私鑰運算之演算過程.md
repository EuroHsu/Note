# ElGamal公鑰與私鑰運算之演算過程

## ElGamal緣起

在密碼學中，ElGamal加密系統是一個基於[迪菲-赫爾曼密鑰交換](https://zh.wikipedia.org/wiki/迪菲-赫爾曼密鑰交換)的非對稱加密算法。它在1985年由塔希爾·蓋莫爾提出。[GnuPG](https://zh.wikipedia.org/wiki/GnuPG)和[PGP](https://zh.wikipedia.org/wiki/PGP)等很多密碼學系統中都應用到了ElGamal算法。

ElGamal加密算法可以定義在任何[循環群](https://zh.wikipedia.org/wiki/循環群)G上。它的安全性取決於G上的離散對數難題。

## 算法

ElGamal加密算法由三部分組成：密鑰生成、加密和解密

### 密鑰生成

密鑰生成的步驟如下：

- Alice利用生成元g產生一個q階循環群G的有效描述。該循環群需要滿足一定的安全性質

- Alice從{1,...,q-1}中隨機選擇一個x

- Alice計算h:=g^x

- Alice公開h以及G,q,g的描述作為其公鑰，並保留x作為其私鑰。私鑰必須保密

### 加密

- Bob想要向Alice傳送一條訊息m，訊息加密的方法如下：

- Bob從{1,...,q-1}中隨機選擇一個y，計算c1:=g^y

- Bob計算共享秘密s:=h^y

- Bob把他要發送的秘密消息m映射為G上的一個元素m'

- Bob計算c2:=m'·s

- Bob將密文(c1,c2)=(g^y,m'·h^y)=(g^y,m'·(g^x)^y)發送給Alice

### 解密

- Alice收到Bob的密文(c1,c2)後，利用私鑰x進行解密，解密的方法如下：

- Alice計算共享秘密s:=c1^x=(g^y)^x

- 然後計算m':=c2·s^-1，並將其映射回明文m，其中s^-1是s在群G上的逆元

	解密算法是能夠正確解密出明文的，因為

	c2·s^-1=m'·h^y·(g^xy)^-1=m'·g^xy·g^-xy=m'

## 實際使用

ElGamal加密系統通常應用在混合加密系統中。例如：用對稱加密體制來加密消息，然後利用ElGamal加密算法傳遞密鑰。這是因為在同等安全等級下，ElGamal加密算法作為一種非對稱密碼學系統，通常比對稱加密體制要慢。對稱加密算法的密鑰和要傳遞的消息相比通常要短得多，所以相比之下使用ElGamal加密密鑰然後用對稱加密來加密任意長度的消息，這樣要更快一些。

