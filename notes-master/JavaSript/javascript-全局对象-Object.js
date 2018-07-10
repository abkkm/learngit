----------------------------
Object						|
----------------------------
	# ���ж���������Object
		* Ҳ����˵,����ʵ������,�����ж��󶼾߱���
	
	# ʵ������
		constructor
			* ���ص�ǰ����Ĺ��캯��
			* ���Ǵ����˵�ǰ�������ĺ���
		
	# ʵ������
		hasOwnProperty();
			* ��ǰ�����Ƿ�߱�ָ�����Ƶ�����/����
			* �����ܻ�ȥ���ԭ�Ͷ���
			* ˵����,����ָ�������ǲ������Լ�������
			* ���� boolean 
		
		isPrototypeOf();
			* �жϵ�ǰ����,�Ƿ���ָ�������ԭ������,���ڼ��ԭ��,�� instanceof һ���Ĺ���ԭ��
			* ��������,�Ƿ��� this(ԭ�Ͷ���) ��ԭ������
			* ���� boolean
		
		propertyIsEnumerable();
			* �жϵ�ǰ����ָ�����Ƶ�����,�Ƿ���Ա� for int ö��
			* ����������ǰ���������,����ȥԭ����������
			* ���� boolean
	
		toLocaleString();
			* ���ַ�������ʽ���ص�ǰ����,�ַ�����ʽ����ǰִ�л����ĵ�����Ӧ
		
		toString();
			* ���ַ�������ʽ���ص�ǰ����
		
		valueOf();
			* ���ض�����ַ���,

	# ��̬����
		create();
			* ֱ�Ӵ�����һ������
			* ��һ�������������ø��ö����ԭ�Ͷ���
			* �ڶ�������,���ڶԶ������Խ��и���ϸ������(��ѡ)
				writable		:�Ƿ������д
				configurable	:�Ƿ��ܹ�ɾ�����Ƿ��ܹ����޸�
				enumerable		:�Ƿ��ö��,Ĭ��Ϊ false
				value			:ֵ,'�����ú�������get��set'	
				get				:�������Ե�ʱ�򴥷�,��סǧ����ʹ�� this.��ǰ��������
				set				:�������Ե�ʱ�򴥷�,��סǧ����ʹ�� this.��ǰ��������
			* var o = Object.create({x:1,y:2});		//o �̳�������,x��y
			* var o = Object.create(obj,{
									z:{		//z���Կ���
										value:'yupeng',		//ֵ
										writable:true		//��д
									},
									k: {	//k���Կ���
										configurable: false,				//��������
										get: function() { return bar; },	//��ȡ
										set: function(value) { bar=value }	//����
										}
								})

		getPrototypeOf(obj);
			* ��ȡָ������ԭ�Ͷ���
		
		keys(obj);
			* ��ȡָ���������������
			* ��ö��,���������
			* �����Բ�����ԭ�Ͷ���������Լ�����ö������
			* ��������
		
		getOwnPropertyNames(obj);
			* ���ض������������,�����ǿ�ö�ٵĻ��ǲ���ö�ٵ�,��һ������
			* ��������Ծ�OK,�����Ƿ����ö��
			* ���ص����Բ�����ԭ�Ͷ��������
		
		getOwnPropertySymbols(obj);
			* ����һ������,����������������� Symbol ���Եļ���
			

		defineProperty(); 
			* ��ָ���Ķ�����������
			* ��������
				1,Ҫ�������ԵĶ���
				2,����ʲô����(���ַ�����ʾ���Ե�����)
				3,Options������({})
						configurable	�����ܷ�ɾ���������¶���,Ĭ�� false	
						enumerable		���������ʱ�������Ƿ�ɼ�	
							* Ŀǰ,���ĸ����������enumerableΪfalse������
								for...inѭ��	:ֻ������������ĺͼ̳еĿ�ö�ٵ�����
								Object.keys()	:���ض�����������п�ö�ٵ����Եļ���
								JSON.stringify():ֻ���л���������Ŀ�ö�ٵ�����
								Object.assign()	:����enumerableΪfalse�����ԣ�ֻ������������Ŀ�ö��
						value			����ֵ��'�����ú�������get��set'	
						writable		�����ܷ�ı�	
						get				����ȡ���Ե�ʱ�򴥷�,��סǧ����ʹ�� this.��ǰ��������	
						set				���������Ե�ʱ�򴥷�,��סǧ����ʹ�� this.��ǰ��������
		
		defineProperties();
			* ������һ��,ֻ����������
			* �Զ�������������������,����
			* ��һ���������Ƕ���,�ڶ�������,������һ�Ѷ���,key����������,value����һ������,�������Ե�����
				Object.defineProperties(user,{
					x:{
						value:3
					},
					y:{
						value:2
					}
				});
		
		getOwnPropertyDescriptor(obj,prop);		
			* ��ȡָ������,ָ�����Ե�...����
			* ���ǲ���1�������Ĳ���2�����Ե�һЩ����(ֻ��...�ȵ�)
			* ���ܼ���ԭ�ͼ̳е�����
			* Object.getOwnPropertyDescriptor(user,"name")
		
		getOwnPropertyDescriptors(obj)
			* ����һ������,����ԭ��������������Ǹö����������,��Ӧ������ֵ���Ǹ����Ե���������
			* �Լ�ʵ��
				function getOwnPropertyDescriptors(obj) {
					const result = {};
					for (let key of Reflect.ownKeys(obj)) {
						result[key] = Object.getOwnPropertyDescriptor(obj, key);
					}
					return result;
				}
		
		freeze(obj);
			* ����һ������,������֮��,�ö��������ֵ���ܽ����޸�
				'use strict';
				const foo = Object.freeze({name:'Kevin'});
				foo.name = 'Litch'	//Uncaught TypeError: Cannot assign to read only property 'name' of object '#<Object>'
				foo.age = 23;		//Uncaught TypeError: Cannot add property age, object is not extensible
			* ���Ƕ�������Զ����������޸ĵ�
				const foo = Object.freeze({user:{name:'Kevin'}});
				foo.user.name = 'Litch';
			
			* ����������������
				var constantize = (obj) => {
					Object.freeze(obj);
					Object.keys(obj).forEach( (key, i) => {
						if ( typeof obj[key] === 'object' ) {
							constantize( obj[key] );
						}
					});
				};

		is(t,o);
			* ��ʵ���� ==== �ж�
			* �� === ��֮ͬ��ֻ������:һ��+0������-0,����NaN��������
				+0 === -0 		//true
				NaN === NaN 	// false
			
				Object.is(+0, -0) 	// false
				Object.is(NaN, NaN) // true

		assign(target,...source)
			* ��Դ����(source)�����п�ö������,���Ƶ�Ŀ�����(target)

		setPrototypeOf(obj,prototype)
			* ����ָ�������ԭ�Ͷ���

		getPrototypeOf(obj)
			* ��ȡָ�������ԭ�Ͷ���

		keys()
			* ���������������ļ���

		values()
			* �������е�ֵ�ļ���

		entries()
			* ���ؼ�ֵ�Եļ���[[k,v],[k,v]]
		
		preventExtensions()
			* ������һ�������Ϊ������չ
			* ������һ������ֵ,��ʾ�Ƿ�����ɹ�
		isExtensible()
			* ����һ������ֵ,��ʾ��ǰ�����Ƿ����չ
			


				


		
		
	
