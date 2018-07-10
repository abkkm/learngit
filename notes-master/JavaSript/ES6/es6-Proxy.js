----------------------------
Proxy						|
----------------------------
	1,����
	2,Proxy ʵ���ķ���
	3,Proxy.revocable()
	4,this ����
	5,ʵ��:Web ����Ŀͻ���


----------------------------
����						|
----------------------------
	# ��Java��Proxyһ��,AOP���
	# ����Proxyʵ������

		new Proxy(target,handler)

		* target,Ŀ�����(����ǿ����)
		* handler,���������(һ������)
	
	# Hello World
		let obj = {name:'Kevin',age:23};
		let proxyObj = new Proxy(obj,{
			//��ȡ����ʱ����
			get:function(target,key,receiver){
				console.log(`��ȡ����:${key}`);
				return Reflect.get(target, key, receiver);
			},
			//��������ʱ����
			set:function(target, key, value, receiver){
				console.log(`��������:${key},${value}`);
				return Reflect.set(target, key, value, receiver);
			}
		});
		
		proxyObj.name;			//��ȡ����:name
		proxyObj.age = 25;		//��������:age,25

	
	# ���handlerû�������κ�����,�Ǿ͵�ͬ��ֱ��ͨ��ԭ����
		let obj = {name:'Kevin',age:23};
		let proxyObj = new Proxy(obj,{});
		* handler��һ���ն���,û���κ�����Ч��,����proxyObj�͵�ͬ�ڷ���obj

--------------------------------
Proxy.revocable					|
--------------------------------
	# Proxy.revocable��������һ����ȡ���� Proxy ʵ��
		* Proxy.revocable��������һ������,�ö����proxy������Proxyʵ��,revoke������һ������
			let target = {};
			let handler = {};

			let {proxy, revoke} = Proxy.revocable(target, handler);

			proxy.foo = 123;
			proxy.foo // 123

			revoke();
			proxy.foo // TypeError: Revoked
			//���������,��ִ��revoke����֮��,�ٷ���Proxyʵ��,�ͻ��׳�һ������

--------------------------------
this							|
--------------------------------
	# Ŀ������ڲ���this�ؼ��ֻ�ָ�� Proxy ����
		const target = {
			m: function () {
				console.log(this === proxy);
			}
		};
		
		const handler = {};
		const proxy = new Proxy(target, handler);
		target.m() // false
		proxy.m()  // true
	
	# ��Щԭ��������ڲ�����,ֻ��ͨ����ȷ��this�����õ�,���� Proxy Ҳ�޷�������Щԭ�����������
		const target = new Date();
		
		const handler = {};
		
		const proxy = new Proxy(target, handler);
		
		console.log(target.getDate());		//29(��)
		console.log(proxy.getDate());		// TypeError: this is not a Date object.
	
		* getDate����ֻ����Date����ʵ�������õ�,���this����Date����ʵ���ͻᱨ��
		* ��ʱ,this��ԭʼ����,�Ϳ��Խ���������
			const target = new Date('2015-01-01');
			const handler = {
				get(target, prop) {
					if (prop === 'getDate') {
						//���������ִ�� getDate ����,������������������Ϊԭʼ����
						return target.getDate.bind(target);
					}
					return Reflect.get(target, prop);
				}
			};
			const proxy = new Proxy(target, handler);
			
			proxy.getDate() // 1

--------------------------------
Proxy ֧�ֵ����ز���һ��(13 ��)	|
--------------------------------
	# ��ʵ���� hanlder ������
	
	get(target, propKey, receiver)
		* ���ض������ԵĶ�ȡ,����proxy.foo��proxy['foo']
		* 'get�����ĵ���������receiver,����Ϊ��ǰ�� Proxy ʵ��'
			const proxy = new Proxy({}, {
				get: function(target, property, receiver) {
					return receiver;
				}
			});
			proxy.getReceiver === proxy // true
		* ���һ�����Բ�������(configurable)�Ͳ���д(writable),������Բ��ܱ�����,ͨ�� Proxy ������ʸ����Իᱨ��
	
	set(target, propKey, value, receiver)
		* ���ض������Ե�����,����proxy.foo = v �� proxy['foo'] = v
		* ���Ŀ����������ĳ������,����д�򲻿�����,��ôset��������������
		* ���ز���ֵ
		
	has(target, propKey)
		* ����propKey in proxy�Ĳ���
		* �����������Ч,���͵Ĳ�������in�����
		* ԭ���󲻿����û��߽�ֹ��չ,��ʱhas���ػᱨ��
		* has�������ص���HasProperty����,������HasOwnProperty����,��has�������ж�һ�������Ƕ������������,���Ǽ̳е�����
		* ��Ȼfor...inѭ��Ҳ�õ���in�����,����has���ض�for...inѭ������Ч
		* ���ز���ֵ
		
	deleteProperty(target, propKey)
		* ����delete proxy[propKey]�Ĳ���
		* �����������׳�������߷���false,��ǰ���Ծ��޷���delete����ɾ��
		* Ŀ���������Ĳ�������(configurable)������,���ܱ�deleteProperty����ɾ��,���򱨴�
		* ����һ������ֵ
		
	ownKeys(target)
		* ����Object.getOwnPropertyNames(proxy),Object.getOwnPropertySymbols(proxy),Object.keys(proxy)
		* ����һ������,�÷�������Ŀ�����������������Ե�������,��Object.keys()�ķ��ؽ��������Ŀ���������Ŀɱ�������
		* ownKeys�������ص������Ա,ֻ�����ַ����� Symbol ֵ,������������͵�ֵ,���߷��صĸ�����������,�ͻᱨ��
		* ���Ŀ�������������������õ�����,������Ա��뱻ownKeys��������,���򱨴�
		* ������˵,�������²���
			Object.getOwnPropertyNames()
			Object.getOwnPropertySymbols()
			Object.keys()
			* ʹ��Object.keys����ʱ,���������ԻᱻownKeys�����Զ�����,���᷵��
				Ŀ������ϲ����ڵ�����
				������Ϊ Symbol ֵ
				���ɱ���(enumerable)������
		
	getOwnPropertyDescriptor(target, propKey)
		* ����Object.getOwnPropertyDescriptor(proxy, propKey)
		* �������Ե���������
		
	defineProperty(target, propKey, propDesc)
		* ����Object.defineProperty(proxy, propKey, propDesc��,Object.defineProperties(proxy, propDescs)
		* defineProperty��������false,�ᵼ����������Ի��׳�����
		* ���Ŀ����󲻿���չ(extensible),��defineProperty��������Ŀ������ϲ����ڵ�����,����ᱨ��
		* ���Ŀ������ĳ�����Բ���д(writable)�򲻿�����(configurable),��defineProperty�������øı�����������
		* ���ز���ֵ
				
	preventExtensions(target)
		* ����Object.preventExtensions(proxy)
		* �÷������뷵��һ������ֵ,����ᱻ�Զ�תΪ����ֵ
		* ���ز���ֵ
		
	getPrototypeOf(target)
		* ����Object.getPrototypeOf(proxy)
		* ������˵,����������Щ����
			Object.prototype.__proto__
			Object.prototype.isPrototypeOf()
			Object.getPrototypeOf()
			Reflect.getPrototypeOf()
			instanceof
		* getPrototypeOf�����ķ���ֵ�����Ƕ������null,���򱨴�
		* ���Ŀ����󲻿���չ(extensible), getPrototypeOf�������뷵��Ŀ������ԭ�Ͷ���
		* ����һ������
			
	isExtensible(target)
		* ����Object.isExtensible(proxy)
		* �÷���ֻ�ܷ��ز���ֵ,���򷵻�ֵ�ᱻ�Զ�תΪ����ֵ
		* ���������һ��ǿ����,���ķ���ֵ������Ŀ������isExtensible���Ա���һ��,����ͻ��׳�����
		* ��������ֵ
			
	setPrototypeOf(target, proto)
		* ����Object.setPrototypeOf(proxy, proto)
		* �÷���ֻ�ܷ��ز���ֵ,����ᱻ�Զ�תΪ����ֵ
		* ���Ŀ����󲻿���չ(extensible),setPrototypeOf�������øı�Ŀ������ԭ��
		* ���ز���ֵ,���Ŀ������Ǻ���,��ô�������ֶ��������������
		
	apply(target, object, args)
		* ���� Proxy ʵ����Ϊ�������õĲ���,����proxy(...args),proxy.call(object, ...args),proxy.apply(...)
		* ��������,�ֱ���Ŀ�����,Ŀ�����������Ķ���(this),Ŀ�����Ĳ�������
		* ֱ�ӵ���Reflect.apply����,Ҳ�ᱻ����
		
	construct(target, args)
		* ���� Proxy ʵ����Ϊ���캯�����õĲ���,����new proxy(...args)
		* ������������,target:Ŀ�����,args:���������Ĳ�������
		* construct�������صı�����һ������,����ᱨ��
