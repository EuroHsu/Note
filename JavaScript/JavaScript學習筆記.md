# JavaScript 101 ES5/ES6 學習筆記

## 前言

Java 和 JavaScript 雖然名稱相似，但卻是熱狗和狗的差別。JavaScript 是由 [網景公司](https://zh.wikipedia.org/wiki/網景) 工程師 Brendan Eich 於 1995 年為Netscape Navigator 2.0瀏覽器開發的一門名為LiveScript的程式語言，後來網景公司與[昇陽](https://zh.wikipedia.org/wiki/昇陽電腦)電腦公司組成的開發聯盟為了讓這門語言搭上java這個程式語言「熱詞」，將其臨時改名為「JavaScript」，日後這成為大眾對這門語言有諸多誤解的原因之一。

JavaScript 是一種直譯式、基於原型（prototype based）的物件導向程式語言，但又具有函數式程式設計（Functional programming）的特性。它被世界上的絕大多數網站所使用，也被世界主流瀏覽器（Chrome、IE、FireFox、Safari、Opera）支援，再加上 NodeJS 的出現，讓 JavaScript 成為程式語言的當紅巨星，目前雄據在程式語言排行榜前幾名，除了網頁開發外，在許多的領域都可以看到 JavaScript 的身影。

### ES5

大部分主流瀏覽器完整支援的語法標準，又稱ECMAScript 5，2009年12月修訂，可以看到主流瀏覽器對ES5的[支援](http://kangax.github.io/compat-table/es5/)都是十分完備的

### ES6

又稱ES6 Harmony、ECMAScript 2015、ECMAScript 6，為js實作ECMA262 standard的語法之一，在2015年6月陸續提出新的語法標準，語法上的新特性可以參考更完整的開源書教學

- [http://es6.ruanyifeng.com/](http://es6.ruanyifeng.com/)

因為ES6都還沒有完全定案，很多提案還在審查階段
根據審查進度，分為不同的stage

babel 針對 stage 有實作幾個不同的 presets，包含了

1. preset-stage-0
2. preset-stage-1
3. preset-stage-2
4. preset-stage-3

> stage 數字越大的 preset 所包含的 plugins 代表即將進入 ECMA262 standard, TC39 Process，

> 官方預設的範例 stage 0 的 preset

> 使用就是因為其包含了 stage 1, 2, 3 的 presets，

> 而許多開發者直接用 stage 0，會把全部 stage 都載入，建議花時間了解各個 preset-stage 分別載入哪些 plugins 為佳。

補充: ES7稱ES2016，也是ECMA262 standard的一部分內容

## 環境建置

JavaScript 的檔案只要使用一般的文字編輯器即可編輯（存成 .js 檔案），也可以使用 [Sublime Text](https://www.sublimetext.com/) 等編輯器進行開發，[JSBin](https://jsbin.com/) 這個線上工具進行測試。除了編輯器外，實際開發上我們也會需要用到 Node.js 開發環境 和 NPM 套件管理系統（按照 Node.js 官方指示即可安裝）。Node.js 是一個開放原始碼、跨平台的、可用於伺服器端和網路應用的執行環境。

## JavaScript 程式使用方式（HTML 中引入）

1. 內嵌於 `<head\></head\>` (因 JS 為直譯式程式語言，讀到即會執行)

	    <head\>
	    	<script\>
	    	alert(Hello JavaScript);
	    	</script\>
	    </head\>

2. 內嵌於 `<body\></body\>` 之中 (可以讓 HTML 優先載入)
	
		<body> 
		<script>
			alert(Hello JavaScript);
		</script>
		</body>

3. 外部引入檔案置於 `<head\>` 或 `<body\>` 內 (推薦使用)

		<script src="js/main.js"></script>

	注意外部引入的 `<script\></script\>` 中不可再寫 JS。

## 變數

在程式語言中變數是一個暫時儲存資料的地方，賦值給變數的值都會有對應的資料型態，然而 JavaScript 是弱型別（Weak type）所以會有自動轉型的情形。

在 JavaScript 中，全域變數將使用 `var`，而在 ES6 中為了解決變數污染或誤用情形將 `block-scope` 的變數使用 `let`，若你需要固定不變的常數則是使用 `const`。 其中變數型別又分為：Primitive Data Type：String、Number、Boolean（ true 或 false）、undefinded、null，Reference Data Types：Object 兩種，差別在於將物件變數賦值給另外一個變數時是把引用賦值給新變數，所以當新變數更改屬性時會影響到原來物件。

### Primitive Data Type：
	
	var num = 12;
	const str = 'Mark';
	
	function checkLike() {
		let isActived = true;
	}
	
	// console.log 可以讓開發者透過瀏覽器開發者工具看到訊息，方便除錯
	console.log(num);
	console.log(str);
	// 因為 let 是 function block scope，故會產生 "ReferenceError: isActived is not defined 錯誤
	console.log(isActived);

### Reference Data Types：

	// 將物件變數賦值給另外一個變數時是把引用賦值給新變數，所以當新變數更改屬性時會影響到原來物件
	let a = { name: 'Zuck' };
	console.log(a); // Zuck
	let b = a;
	b.name = 'Jack';
	console.log(a); // Jack

## 運算子/運算元

在程式語言中都需要運算子，在 JavaScript 中有賦值運算子、算數運算子、比較運算子、邏輯運算子等不同運算子。

1. 賦值運算子：使用 = 給定值給變數

		// Mark
		const name = 'Mark';

2. 算數運算子：四則運算

		// 4
		const sum = 1 + 3;

3. 比較運算子：數值比較

		const age = 23;
		// true
		const canVote = age >= 20;
		// false
		const canVote = age < 20;

4. 邏輯運算子：邏輯判斷

		const a = true;
		const b = true;
		// 且，要兩個都 true
		const result1 = a && b;
		// 或，只要有一個 true，即為 true
		const result2 = a || b;

## 流程控制（flow control）

在 JavaScript 中和許多程式語言一樣有 `if...else`、`switch` 條件判斷以及在處理陣列上很常使用的迴圈（當有明確次數時使用 `for`，當沒有明確數字時使用 `while`）

1. if…else

		// 可以投票
		if(age > 20) {
			console.log('可以投票！');
		}

2. switch：當條件很多時可以善用 switch 判斷，記得要在每個 case 後寫 break，不然會全部都執行

		const country = 'Taiwan';
		switch(grade) {
			case 'Taiwan':
				console.log('hello' + country);
				break;
			case 'Japan':
				console.log('hello' + country);
				break;
			case 'Korea':
				console.log('hello' + country);
				break;
			default:
				console.log('hello' + country);		
		}

3. for：當你知道程式需要重複執行幾次時可以使用 for 迴圈

		const arr = ['Mark', 'Zuck', 'Jack'];
		for(let i = 0; i < arr.length; arrr++) {
			console.log(arr[i]);
		}

4. while：當你程式不知道需要重複執行幾次時可以使用 while 迴圈

		// 從 1 累加到 10
		const num = 1;
		while(num <= 10) {
			let sum += num; // sum = sum + num
			num += 1;
		}

5. do…while：當迴圈次數不明確時，可以使用 while，而 do while 會至少執行一次

		let x = 0;
		while(x < 10) {
			console.log(x);
			x++;
		}
		
		let y = 0;
		do {
			console.log(y);
			y++;	
		} while(i < 10);

### JavaScript的truthy & falsey(falsy)

在JavaScript中有些值並非true或false,但在"條件式"中會被視為true或false, 因而被稱為truthy或falsey(false)。

辨識哪個是truthy或falsey: 除了`undefined`、`null`、`NaN`、`0`、`""`（空字串）和 `false` 是falsey值外, 其他皆是truthy值

## 函式/函數（function）

函數是一種可以讓一段程式區塊重複使用的程式撰寫方式，在 JavaScript 中函數屬於一級物件（first class object），可以將函數當參數或變數傳遞，其扮演非常重要的角色，也讓 JavaScript 在函數式程式設計（functional programming）上更容易發揮。
函數可以傳入參數（如下的 x, y），也有可能沒有。函數使用 return 回傳值，若沒寫則回傳 undefined

	function sum(x, y) {
		return x + y;
	}
	
	console.log(sum(12, 20));

### Arrow Function

在 ES6 簡化了函數的使用出現了箭頭函數（arrow function）：

	const sum = (x, y) => {
		return x + y;
	};
	
	console.log(sum(1, 2));

### IIFE

IIFE (Immediately Invoked Function Expression)，稱為`立即函式`

表示立即執行宣告的函式，常用在把功能獨立的程式碼給包裹起來

減少全域變數數量，建立模組化物件

#### ES5的IIFE

	(function () {
	    console.log(this.constructor.name) // Window or undefined in strict mode
	}()

#### 利用IIFE函式物件當作模組

獨體模式 (Singleton Pattern)

	var Singleton = (function () {
	    var instance
	 
	    function createInstance () {
	        var object = new Object("I am the instance")
	        return object
	    }
	 
	    return {
	        getInstance: function () {
	            if (!instance) {
	                instance = createInstance()
	            }
	            return instance
	        }
	    }
	})()

#### ES6中的IIFE

	(() => {
	  console.log(this.constructor.name) // Window or undefined in strict mode
	})()

如果沒有要傳入的context有更簡短的寫法

	{
	  console.log(this.constructor.name) // Window or undefined in strict mode
	}

需要指定的話

	((context) => {
	  console.log(context) // {a: 'a'}
	})({a: 'a'})

## 物件（object）

物件是一種儲存資料的資料結構，可以對應成真實世界的物件（有屬性值和方法），一般而言主要有三種建立方式：

1. 使用 new Object

		var obj = new Object();

2. 使用 {}

		var obj = {
			name: 'Mark',
			age: 23
		}

3. 使用建構函數

	雖然 JavaScript 並非是 class-based 的物件導向程式語言，而是 prototype-based 的物件導向程式語言，但在 JavaScript 可以透過 function 建立類別的宣告函數（）：

	**ES5中的物件**

		// 實務上建構函數命名採單字首字大寫。狗狗物件有 name 屬性，方法是 wow 
		function Dog(name) {
			// 屬性值
			this.name = name;
			// 每個實例都會有一份方法副本
			this.wow = function() {
				console.log('wow!wow');
			}
		}
		// 多個實例共用，可以減少記憶體等資源運用
		Dog.prototype.cry = function() {
			console.log('QQQ');
		}
		const dog = new Dog('lucky');
		dog.wow(); // wow!wow!
		dog.cry(); // QQQ

	**ES6中的物件**
	
	ES6語法提供了更直覺的物件宣告關鍵字(class)，如下

		class Dog {
			constructor (name) {
				this.name = name;
			}
			wow() {
				console.log('wow!wow');
			}
		}
		Dog.prototype.cry = function() {
			console.log('QQQ');
		}
		const dog = new Dog('lucky');
		dog.wow(); // wow!wow!
		dog.cry(); // QQQ

## 物件導向

物件導向強調`繼承`、`封裝`、`多型`，其實javascript是一個有物件導向性質的語言，不過因為在ES5中要寫出這樣的特性，語法上非常不直覺，因此有了Javascript是世界上最被誤解的語言一文

但關於`繼承`這件事，javascript的繼承屬於`Prototypal Inheritance`，與一般靜態語言(Java, C++)的`Class Inheritance`有著本質上的不同，ES6的關鍵字`class`也只是`Prototypal Inheritance`的語法糖，實際上背後的實作仍然是`Prototypal Inheritance`

因此有別於`Class Inheritance`類型的物件導向語言
這種差異影響著多型(多重繼承或介面實作來達到)和封裝(常透過interface了解實作的封裝)
在javascript中呈現的形式，或是本質上無法實現，此處不會講太過複雜的實作

故在講解javascript物件導向時

- 繼承: 只會說明單一繼承，多重繼承比較像混合(mixins)

- 多型: `Prototypal Inheritance`的語言實作，與繼承極為相似，且ES5/ES6並沒有支援`interface`等相關關鍵字，所以不多做說明，如果有寫Angular.js或TypeScript可能會知道`Typescript interface`，事實上`Typescript interface`只是個compile-time語法，不會被翻譯成ES5的任何實作

- 封裝: 沒有`interface`語法，資料封裝其實就會跟操作封裝很像，同為js物件的做法

此處個別針對ES5/ES6在物件上的語法特別說明其差異，希望可以幫助讀者打好基底，不要迷茫在js設計上的問題，進而造成js不支援某種特性的誤解

### Static Variable / Static Method

談到物件和實體，也要提一下靜態的成員變數與方法

注意static的變數和方法`不會被繼承`

#### ES5

	var Car = function (name) {
	  this.name = name
	}
	// 毫無反應，只是個靜態變數
	Car.staticObject = new Object()
	// 毫無反應，只是個靜態方法
	Car.staticFunction = function () {
	  return 'static'
	}
	
	var car1 = new Car('Benz')
	var car2 = new Car('BMW')
	console.log(car1.name) // Benz
	console.log(car2.name) // BMW
	console.log(Car.staticObject) // Object
	console.log(car1.staticObject) // undefined，要小心，跟Java不同
	console.log(Car.staticFunction()) // static
	console.log(car1.staticFunction()) // TypeError, car1.staticFunction is not a function

#### ES6

	class Car {
	  static staticObject = new Object()
	  static staticFunction () {
	    return 'static'
	  }
	  constructor (name) {
	    this.name = name
	  }
	}
	var car1 = new Car('Benz')
	var car2 = new Car('BMW')
	console.log(car1.name) // Benz
	console.log(car2.name) // BMW
	console.log(Car.staticObject) // Object
	console.log(car1.staticObject) // undefined，要小心，跟Java不同
	console.log(Car.staticFunction()) // static
	console.log(car1.staticFunction()) // TypeError, car1.staticFunction is not a function

### Getter / Setter

#### ES5

	var Car = function () {
	    var _privateProperty = 5
	    this.getPrivate = function () {
	      return _privateProperty
	    }
	    
	    this.setPrivate = function (value) {
	      _privateProperty = value
	    }
	}
	var c = new Car()
	console.log(c.getPrivate()) // 5
	c.setPrivate(6)
	console.log(c.getPrivate()) // 6

#### ES6

	class Car {
	    constructor () {
	      this._privateProperty = 5
	    }
	    get prop () {
	      return this._privateProperty
	    }
	    
	    set prop (value) {
	      this._privateProperty = value
	    }
	}
	var c = new Car()
	console.log(c.prop) // 5
	c.prop = 6
	console.log(c.prop) // 6

### 建構子 (Constructor) 與繼承

#### ES5

支援存取private property的繼承寫法

	var Car = function () {
	  // constructor
	  
	  // private property
	  var _wheels
	  
	  // private method
	  var initialWheels = function () {
	    _wheels = 4
	  }
	  
	  // call private method
	  initialWheels()
	  
	  // pulic property
	  this.brand = 'default'
	  
	  // public method
	  this.numberOfWheels = function () {
	    return _wheels
	  }
	}
	var Benz = function () {
	  Car.apply(this, arguments) // 相當於呼叫super(args)
	  this.brand = 'Benz'
	  this.getBrand = function () {
	    return this.brand
	  }
	}
	var BMW = function () {
	  Car.apply(this, arguments) // 相當於呼叫super(args)
	  this.getBrand = function () {
	    return this.brand
	  }
	}
	// 建立父類別實體 設定繼承關係
	Benz.prototype = Object.create(Car.prototype) // Benz.prototype.__proto__ = Car.prototype
	Benz.prototype.constructor = Benz
	BMW.prototype = Object.create(Car.prototype) // BMW.prototype.__proto__ = Car.prototype
	BMW.prototype.constructor = BMW
	var benz = new Benz() // benz.__proto__ = Benz.prototype
	var bmw = new BMW() // bmw.__proto__ = BMW.prototype
	console.log(benz.getBrand()) // Benz
	// benz.numberOfWheels() 有此方法
	// 每次呼叫Car.apply(this, arguments)時複製到子類別的物件上
	// 初始化物件時較慢，在run time想要動態改變numberOfWheels()的實作時
	// 無法影響已經創建的子類別或父類別instances
	console.log(benz.numberOfWheels()) // 4
	console.log(bmw.getBrand()) // default
	console.log(bmw.numberOfWheels()) // 4
	console.log(benz instanceof Car) // true
	console.log(bmw instanceof Car) // true
	console.log(benz.__proto__ === Benz.prototype) // true
	console.log(bmw.__proto__ === BMW.prototype) // true
	console.log(Benz.prototype.__proto__ === Car.prototype) // true
	console.log(BMW.prototype.__proto__ === Car.prototype) // true

#### ES6

Classes只是定義物件prototype的一個語法糖 (syntactic sugar)

	class Car {
	  constructor () {
	    this._wheels = 4
	    this.brand = 'default'
	  }
	  
	  // public method
	  numberOfWheels () {
	    return this._wheels
	  }
	}
	class Benz extends Car {
	  constructor () {
	    // 建立父類別實體 設定繼承關係  Benz.prototype.__proto__ == Car.prototype
	    super()
	    // 此處使用this前要先呼叫super()
	    this.brand = 'Benz'
	  }
	  
	  getBrand () {
	    return this.brand
	  }
	}
	class BMW extends Car {
	  getBrand () {
	    return this.brand
	  }
	}
	let benz = new Benz()
	let bmw = new BMW()
	console.log(benz.getBrand()) // Benz
	console.log(benz.numberOfWheels()) // 4
	console.log(bmw.getBrand()) // default
	console.log(bmw.numberOfWheels()) // 4
	console.log(benz instanceof Car) // true
	console.log(bmw instanceof Car) // true
	console.log(benz.__proto__ === Benz.prototype) // true
	console.log(bmw.__proto__ === BMW.prototype) // true
	console.log(Benz.prototype.__proto__ === Car.prototype) // true
	console.log(BMW.prototype.__proto__ === Car.prototype) // true

小節: 繼承不是萬靈丹，只是一種reuse程式碼的手段

錯誤的繼承反而會導致一場災難，所以design pattern有一個心法為

> 多用合成，少用繼承

有時候composition就能更有語意的解決程式碼的重用需求，就不需要用到繼承

## DOM & BOM

事實上 HTML 可以轉換成一棵物件樹，也稱為 Document Object Model（DOM）。在撰寫網頁應用程式時往往需要操作到瀏覽器元素，我們通常是透過選取我們想要改變的元素（選擇器），然後修改我們的物件屬性

1. 物件模型

	所謂的物件模型（Object Model）對於HTML 網頁來說，是一種規範如何存取HTML 元素、CSS 樣式和 JavaScript 程式碼的一種機制，可以將HTML元素、CSS樣式和 JavaScript 程式碼視為物件

2. BOM

	![](https://blog.kdchang.cc/2016/12/21/javascript101-tutorial/bom.jpg)

	BOM 就是 Browser Object Model 中文叫做瀏覽器物件模型，`window` 物件是瀏覽器最頂層物件，其下有 document（DOM）、history、location、navigator、screen 子物件。window 物件不須經過宣告，可直接使用，代表目前瀏覽器視窗。事實上，所有的全域變數、函式、物件，其實都是屬於 window 物件，而 BOM 物件的使用可讓我們操作包含開啟/關閉視窗，改變視窗大小，計時器與取得網址、存取瀏覽器屬性等

3. DOM

	文件物件模型（Document Object Model，DOM）是給 HTML 與 XML 文件使用的一組 API。簡單的說就是將文件（文件可以想成單一網頁）物件化，以便提供一套通用存取的方式來處理文件內容。DOM 提供 HTML 網頁一種存取的方式，可以將 HTML 元素轉換成一棵節點樹，每一個標籤和文字內容是為一個節點，讓我們可以走訪節點 (Nodes) 來存取 HTML 元素

		<!doctype html>
		<html lang="en">
		<head>
		  <meta charset="UTF-8">
		  <title>My title</title>
		</head>
		<body>
			<h1>My header</h1>
			<a href="">My link</a>
		</body>
		</html>

	![](https://blog.kdchang.cc/2016/12/21/javascript101-tutorial/DOM.gif)

	要操作 DOM 元素前要選取要操作哪個

	- 根據ID名稱選取

		`document.getElementById(elementId)`

	- 根據元素名稱選取

		`document.getElementsByTagName(tagName)`

	- 根據名稱選取

		`document.getElementsByName(name)`

	- 根據 Class 名稱選取

		`document.getElementsByClassName(classname)`

		有很多元素符合，回傳的是 `NodeList` 物件集合，使用 item() 存取 (注意 Element’s’)，迭代使用 forEach 不然就要轉陣列

		document 物件有提供使用 CSS 選擇器來選取元素，效能較好

	- document.querySelectorAll() 方法

		document 物件的 `querySelectorAll()` 方法可以取得 HTML 的節點陣列或清單，為一個 `NodeList` 物件（若要使用 map 方法需要轉陣列，不然只能用 forEach ）

	- document.querySelector() 方法

		只會回傳一個符合的元素，沒有就回傳 null

		範例：

			<body>
			  <p>An unordered list:</p>
			  <ul>
			    <li>Coffee</li>
			    <li>Tea</li>
			    <li>Milk</li>
			  </ul>
			  <!-- Good! -->
			  <div id="good"></div>
			  <!-- Not good! -->
			  <div class="info"></div>
			  <!-- Tea -->
			  <div id="danger"></div>
			  <!-- Not good! -->
			  <div class="info"></div>
			<script type="text/javascript">
				// 取得id=good的元素
			    document.getElementById('good').innerHTML = 'Good!';
				// 取得所有tag=LI的元素
			    var x = document.getElementsByTagName("LI");
				// 取得第一個id=danger的元素
			    document.querySelector('#danger').innerHTML = x[1].innerHTML;
				// 取得所有class=info的元素
			    document.querySelectorAll('.info').forEach((value, index) => {
			      value.innerHTML = 'Not good!';
			    });
			</script>
			</body>

## 事件處理（event handler）

事件處理（Event Handlers）是 JavaScript 非常重要的功能，事件是用來處理 JavaScript 與 HTML 之間的互動、建立動畫效果並和使用者互動

- 事件處理簡單說就是當一個事件發生時（網頁載入、按下右鍵等），程式會相對應做出怎樣的處理

- 例如：當使用者按下按鈕時會觸發 click 的事件（事件發生）並讓按鈕變成紅色（處理事件），這就是一種事件處理機制

### 事件處理機制

	事件處理 = 事件種類 + 事件處理方法

- 事件種類（Event Type）

	又稱事件名稱 (Event Name)，為一個字串，說明發生了什麼事件，例如：click (點擊)、mousemove (滑鼠滑過)

- 事件處理（Event Handlers）

	係指處理事件的函數名稱，當事件發生時要呼叫哪個函數進行處理

		// 當發生 click 事件，會發出 alert 
		btn.addEventListener('click', function() {
			  alert('被點了!');
		});

	完整範例：
	
		<!DOCTYPE html>
		<html>
		<head>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width">
		  <title>JS Bin</title>
		</head>
		<body>
		  <button id="btn">點我點我</button>
		  <script type="text/javascript">
			const btn = document.querySelector('#btn');
		
			btn.addEventListener('click', function() {
			  alert('被點了!');
			});  	
		  </script>
		</body>
		</html>

## 非同步處理（Ajax） / Promise

傳統上我們會使用 `<form>` 表單和後端程式作互動，然而每次提交表單送出請求給伺服器，伺服器接收並處理傳來的表單，然後送回一個新的網頁。使用 Ajax 應用可以僅向伺服器發送並取回必須的數據，並在客戶端採用JavaScript 處理來自伺服器的回應，不僅減少伺服器負擔也加快反應速度

### 同步 vs. 非同步

![](https://blog.kdchang.cc/2016/12/21/javascript101-tutorial/sync.png)

依序執行，等到上一個函數任務執行完才能執行下一個

![](https://blog.kdchang.cc/2016/12/21/javascript101-tutorial/async-1.png)

不會因為上一個函數尚未執行完（例如：回傳結果）就卡住，會往下執行下一個任務

### 什麼是同步/非同步？

- 非同步係指程式不會因為上一個函數尚未執行完（例如：回傳結果）就卡住，會往下執行下一個任務

- 同步就是要等到上一個函數任務執行完才能執行下一個，是依序執行

由於 `DOM 事件處理` 和 `Ajax` 呼叫是非同步處理，所以大部分人會為 JavaScript 貼上非同步程式設計的標籤

### 什麼是 Ajax？

- Ajax 全名：`Asynchronous Javascript And XML`，指的是一套綜合了多項技術的瀏覽器端網頁開發技術

- 雖然 Ajax 中使用 XML 為名，不過 Ajax 不是指一種單一的技術。現在許多應用都使用更輕量的 JSON 進行資料傳輸

- 可以完成不刷頁局部更新應用，使用者體驗較好。不過要小心回調地獄（callback hell）

### 簡易 Ajax 實作

	// 若需要支援跨瀏覽器，還需要額外檢驗
	if (typeof XMLHttpRequest != 'undefined') {
	    // 一般使用 XMLHttpRequest 物件
	    const xhr = new XMLHttpRequest();
	    const REQUEST_URL = 'http://163.29.157.32:8080/dataset/6a3e862a-e1cb-4e44-b989-d35609559463/resource/f4a75ba9-7721-4363-884d-c3820b0b917c/download/393625397fc043188a3f8237c1da1c6f.json';
	
	    // 監聽是否完成
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState === XMLHttpRequest.DONE) {
	            console.log(xhr.responseText);
	        }
	    }
	    
	    xhr.open('GET', REQUEST_URL);
	    xhr.send();
	}

使用setTimeout模擬ajax去server side取得message的資料後
每一個工作依賴於前一個先做完才能往下做

1. 顯示取回的資料
2. 跟之前的資料做加總
3. 最後顯示總和

	setTimeout(function () {
	  var message = 1 // 取回資料
	  console.log(message)
	  var sum = message // 加總
	  
	  // 第一個請求結束，開始下一個請求
	  setTimeout(function () {
	    var message = 1 // 取回資料
	    console.log(message)
	    sum += message // 跟之前的資料做加總
	    
	    // 第二個請求結束，開始下一個請求
	    setTimeout(function () {
	      var message = 1 // 取回資料
	      console.log(message)
	      sum += message // 跟之前的資料做加總
	      
	      // 第三個請求結束，開始下一個請求
	      setTimeout(function () {
	        // 第四個請求結束
	        console.log(message) // 取回資料
	        sum += message // 加總
	        console.log(sum) // 做最後的處理
	      }, 1000)
	    }, 1000)
	  }, 1000)
	}, 1000)

如果有幾個非同步請求彼此相依，要依照順序執行時
這種一層一層弓形的callback function就會形成沒有可讀性，難維護的程式碼
稱為`callback hell`

例如：你有三個後端API

1. 取得文章列表
2. 取得某文章的回文列表
3. 取得某回文的作者信箱

在前端就可能要依照順序呼叫這三個API就有可能寫出這樣的程式碼

如何處理?

### Promise來拯救!

	var sum = 0
	var first = function () {
	  return new Promise(function (resolve) {
	    setTimeout(function () {
	      resolve(1)
	    }, 1000)
	  })
	}
	var second = function () {
	  return new Promise(function (resolve) {
	    setTimeout(function () {
	      resolve(1)
	    }, 1000)
	  })
	}
	var third = function () {
	  return new Promise(function (resolve) {
	    setTimeout(function () {
	      resolve(1)
	    }, 1000)
	  })
	}
	var fourth = function () {
	  return new Promise(function (resolve) {
	    setTimeout(function () {
	      resolve(1)
	    }, 1000)
	  })
	}
	// 一個Promise做完之後印出Promise工作取得的資料，並開始下一個Promise工作
	first().then(function (message) {
	  // 1
	  console.log(message) // 取回資料
	  sum += message // 加總
	  return second() // 第一個請求結束，開始第二個請求
	}).then(function (message) {
	  // 1
	  console.log(message) // 取回資料
	  sum += message // 加總
	  return third() // 第二個請求結束，開始第三個請求
	}).then(function (message) {
	  // 1
	  console.log(message) // 取回資料
	  sum += message // 加總
	  return fourth() // 第三個請求結束，開始第四個請求
	}).then(function (message) {
	  // 第四個請求結束
	  // 1
	  console.log(message) // 取回資料
	  sum += message // 加總
	  // 4
	  console.log(sum) // 最後處理
	}).catch(console.error) // 如果中間發生錯誤，做錯誤處理

是沒有callback hell了，但是程式碼一堆`then`，也不是很容易看懂
有沒有更簡單的寫法?

### 先談ES6 Generator與yield

    用 `*` modifier標注function
    
    function *gen() {
      console.log('start')
      yield "first"
      yield "second"
    }
    // 還不會執行方法，而是返回一個generator物件
    var g = gen()
    console.log(g)
    // 顯示start，得到yield的值，並回傳一個物件，yield的值被存在a.value中
    // {"done": false, "value": "first"}
    var a = g.next()
    console.log(a)
    // {"done": false, "value": "second"}
    var a = g.next()
    console.log(a)
    // 再執行一次
    a = g.next()
    // 顯示{"done": true,"value": undefined}
    console.log(a)

跟Promise合作

	var sum = 0
	var first = function () {
	  return new Promise(function (resolve) {
	    setTimeout(function () {
	      resolve(1)
	    }, 1000)
	  })
	}
	var second = function () {
	  return new Promise(function (resolve) {
	    setTimeout(function () {
	      resolve(1)
	    }, 1000)
	  })
	}
	var third = function () {
	  return new Promise(function (resolve) {
	    setTimeout(function () {
	      resolve(1)
	    }, 1000)
	  })
	}
	var fourth = function () {
	  return new Promise(function (resolve) {
	    setTimeout(function () {
	      resolve(1)
	    }, 1000)
	  })
	}
	function *gen () {
	  yield first()
	  yield second()
	  yield third()
	  yield fourth()
	}
	// 改寫上方generator寫法成遞迴
	let g = gen()
	function fetch(result) {
	    if(result.done) {
	      // 全部請求結束，做最後處理
	      console.log(sum) // 4
	    } else {
	      // 請求尚未全部結束，取回請求結果，繼續執行下一個請求
	      result.value.then(function (message) {
	        console.log(message) // 1，取回結果
	        sum += message // 加總
	        // 遞迴呼叫
	        fetch(g.next()) // 做下一個請求
	      }) 
	    }
	}
	fetch(g.next()) // 執行第一個請求

這樣看起來其實語法上並沒有比較簡潔

但有其他利用generator做flow control的套件

## JSON 基礎概念

- JSON（JavaScript Object Notation）是一種由Douglas Crockford 構想設計、輕量級的資料交換語言，以文字為基礎，且易於讓人閱讀

- JSON 雖然起於 JavaScript，但資料格式與語言無關，目前很多程式語言都支援 JSON 格式資料的生成和解析

- JSON 的官方 MIME 類型是 `application/json`，其副檔名是 `.json`

- 基本格式 `{ "key": "value" }`、`{ "key": ["value1", "value2"] }`

### JSON 長這樣

	{
	     "name": "John Smith",
	     "address": 
	     {
	         "streetAddress": "21 2nd Street",
	         "city": "New York",
	         "state": "NY",
	         "postalCode": "10021"
	     },
	     "phoneNumber": 
	     [
	         {
	           "type": "home",
	           "number": "212 555-1234"
	         },
	         {
	           "type": "fax",
	           "number": "646 555-4567"
	         }
	     ]
	 }

## 資料來源

[Benjamin Lu | 技術站](https://benjaminlu.github.io/blog/tags/)

[JavaScript 101 快速入門教學](https://blog.kdchang.cc/2016/12/21/javascript101-tutorial/)