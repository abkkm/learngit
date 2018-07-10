--------------------
fetch				|
--------------------
	# 语法
		fetch(url,options)
	
	# options 
		credentials
			* 默认仨值
				"omit",
				"same-origin"
				"include"
			* Fetch 请求默认是不带 cookie 的,需要设置 credentials: 'include' 
			* fetch(url, {credentials: 'include'})

		body
			* 请求体数据,可以是FormData,URLSearchParams或者字符串

		method
			* 以字符串形式指定请求方法

		headers
			* 对象,请求头

		mode
			* 关于跨域的一些配置
				"same-origin"	
					* 只有来自同域的请求才能成功,其它的均将被拒绝
				"cors"			
					* 允许不同域的请求,但要求有正确的 CORS 头信息
				"cors-with-forced-preflight" 
					* 在执行真正的调用前先执行preflight check
				"no-cors" 
					* 目前这种模式是无法执行的。
			
		cache
			
	
	# 返回对象是 Promise 对象
		fetch('/login') instanceof Promise

	# 服务器返回 400,500 错误码时并不会 reject,只有网络错误这些导致请求不能完成时,fetch 才会被 reject

--------------------
Headers				|
--------------------
	# Headers接口是一个简单的多映射的名-值表
		let reqHeaders = new Headers();
		reqHeaders.append("Content-Type", "text/plain");
		reqHeaders.append("X-Custom-Header", "ProcessThisImmediately");
	
	# 也可以通过构造函数传一个多维数组或者json来创建
		reqHeaders = new Headers({
			"Content-Type": "text/plain",
			"Content-Length": content.length.toString(),
			"X-Custom-Header": "ProcessThisImmediately",
		});
		
	# Headers对象有一个特殊的 guard 属性
		* 这个属性没有暴露给Web,但是它影响到哪些内容可以在Headers对象中被改变
		"none"				默认的
		"request"			从Request中获得的Headers只读
		"request-no-cors"	从不同域的Request中获得的Headers只读
		"response"			从Response获得的Headers只读
		"immutable"			在ServiceWorkers中最常用的,m所有的Headers都只读

	
	# Headers实例的api
		has(key)
			* 判断指定的请求头是否存在
		
		set(key,value)
			* 设置新的请求头,会覆盖掉同名的
		
		append(key,value)
			* 设置新的请求头,如果存在同名,不会覆盖,会添加
		
		get(key)
			* 获取指定名称请求头的值
		
		getAll(key)
			* 获取指定名称请求头的所有值,返回[]
		
		delete(key)
			* 删除指定的请求头

--------------------
Request				|
--------------------
	# Request接口定义了通过HTTP请求资源的request格式
		* 语法
			Request(url,options)
		* 参数需要
			URL
			method
			headers

		* 同时Request也接受一个特定的 body,mode,credentials以及cache hints
	
		var req = new Request("/index.html");
		console.log(req.method); 	// "GET"
		console.log(req.url); 		// "http://example.com/index.html"
	
	# 也可以将一个建好的Request对象传给构造函数,这样将复制出一个新的Request
		var copy = new Request(req);
		console.log(copy.method);	// "GET"
		console.log(copy.url);		// "http://example.com/index.html"
	
	# URL以外的其他属性的初始值能够通过第二个参数传给Request构造函数
		var uploadReq = new Request("/uploadImage", {
			method: "POST",
			headers: {
				"Content-Type": "image/png",
			},
			body: "image data"
		});
	
	# options 参数(跟fetch的options一样)
		credentials
			* 默认仨值
				"omit",
				"same-origin"
				"include"
			* Fetch 请求默认是不带 cookie 的,需要设置 credentials: 'include' 
			* fetch(url, {credentials: 'include'})
		method
			* 请求方法
		headers
			* 请求头,对象
		body
			* 请求体,可以是字符串,formData,URLSearchParams
		mode
			* 关于跨域的一些配置
				"same-origin"	
					* 只有来自同域的请求才能成功,其它的均将被拒绝
				"cors"			
					* 允许不同域的请求,但要求有正确的 CORS 头信息
				"cors-with-forced-preflight" 
					* 在执行真正的调用前先执行preflight check
				"no-cors" 
					* 目前这种模式是无法执行的。

	# 属性
		method
		url

--------------------
Response			|
--------------------
	# Response有个接收两个可选参数的构造器,第一个参数是返回的body,第二个参数是一个json,设置status、statusText以及headers
	# 静态方法Response.error()简单返回一个错误的请求,类似的，Response.redirect(url, status)返回一个跳转URL的请求
	# 属性
		ok
			* 是否成功,根据http状态码决定
		bodyUsed
			* 是否已经使用过
		headers
			* 返回 Headers 实例对象
		redirected
		status
		statusText
		type
			* 类型,枚举字符串值
			"basic"		正常的,同域的请求,包含所有的headers除开"Set-Cookie"和"Set-Cookie2"
			"cors"		Response从一个合法的跨域请求获得,一部分header和body可读。
			"error"		网络错误:Response的status是0,Headers是空的并且不可写,当Response是从Response.error()中得到时,就是这种类型
			"opaque"	Response从"no-cors"请求了跨域资源,依靠Server端来做限制。
			"error"		类型会导致fetch()函数的Promise被reject并回调出一个TypeError
		url


	# 方法
		arrayBuffer()
		blob()
		json()
		text()
		formData()

		* 对响应结果的处理,以上都返回 Promise 对象

--------------------
URLSearchParams		|
--------------------
	# 表单参数构造器
		let u = new URLSearchParams();
		u.append('method', 'flickr.interestingness.getList');
		u.append('api_key', '<insert api key here>');
		u.append('format', 'json');
		u.append('nojsoncallback', '1');

		u.toString();
		//"method=flickr.interestingness.getList&api_key=%3Cinsert+api+key+here%3E&format=json&nojsoncallback=1"
	
	# api
		append(k,v)
			* 添加kv,不会覆盖,已经存在,则多添加一个键值对
		set(k,v)
			* 添加kv,同名属性会发生覆盖
	
	# 实例对象可以直接作为 fetch的options的body属性,或者Request实例的options的body属性
		* 会自动添加 ContentType头

--------------------
流和克隆			|
--------------------
	# Request和Response的body只能被读取一次,它们有一个属性叫bodyUsed读取一次之后设置为true,就不能再读取了
		var res = new Response("one time use");

		console.log(res.bodyUsed); // false

		res.text().then(function(v) {
			console.log(res.bodyUsed); // true
		});

		console.log(res.bodyUsed); // true

		res.text().catch(function(e) {
			console.log("Tried to read already consumed Response");
		});
	
	# 让body能经得起多次读取,API提供了一个clone()方法
		* 调用这个方法可以得到一个克隆对象
		* 不过要记得,clone()必须要在读取之前调用,也就是先clone()再读取

		addEventListener('fetch', function(evt) {
			var sheep = new Response("Dolly");
			console.log(sheep.bodyUsed); // false
			var clone = sheep.clone();
			console.log(clone.bodyUsed); // false
			
			clone.text();
			console.log(sheep.bodyUsed); // false
			console.log(clone.bodyUsed); // true
			
			evt.respondWith(cache.add(sheep.clone()).then(function(e) {
				return sheep;
			});
		});

--------------------
Demo				|
--------------------
	let requestBody = new URLSearchParams();
	requestBody.set('account','KevinBlandy');
	requestBody.set('password','123456');
	
	fetch(new Request('/login',{
		method:'POST',
		headers:new Headers({
			'X-Requested-With':'XMLHttpRequest'
		}),
		body:requestBody
	})).then(function(response){
		if(response.ok){
			response.json().then(function(rep){
				console.log(rep);
			});
		}
	}).catch(function(error){
		console.log(error);
	});