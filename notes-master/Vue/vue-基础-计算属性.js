----------------------------
��������					|
----------------------------
	# ��ģ���а󶨱��ʽ�Ƿǳ�������,��������ʵ����ֻ���ڼ򵥵Ĳ���
	# ��ģ���з���̫����߼�����ģ�����������ά��
		<div id="example">
			{{ message.split('').reverse().join('') }}
		</div>
		* ����̫���ڸ���
	
	# �κθ����߼����㶼Ӧ��ʹ�ü�������
	# ͨ�׽�,��ν�ļ�������,��ʵ����һ������,������ֵ����ͨ���ú���������� return �Ľ��

----------------------------
��������-�򵥵�����			|
----------------------------
	<div id="app">
		<span>{{ reverseMessage }}</span>	<!--  ydnalBniveK -->
	</div>
	var app = new Vue({
		el:'#app',
		data:{
			message:'KevinBlandy'
		},
		computed:{
			//�������� message ���Եķ�תֵ
			// reverseMessage ����һ����������
			reverseMessage:function(){
				return this.message.split('').reverse().join('');
			}
		}
	});

	console.log(app.reverseMessage);		//ydnalBniveK
	
	# '�����ṩ�ĺ������������� app.reverseMessage �� getter '

----------------------------
��������-�������Ի��� & methods|
----------------------------
	# ���Ƿ�ת�İ���,����Ҳ����ʹ�� methods �����

		{{ reverseMessage() }

		methods:{
			reverseMessage:function(){
				return this.message.split('').reverse().join('');
			}
		}
	# ���������ǻ���������������,��������ֻ��������������������ı�ʱ�Ż�����ȡֵ
	# �����ζ��ֻҪ message û�з����ı�,'��η��� reverseMessage '��������'����������֮ǰ�ļ�����',��'�����ٴ�ִ�к���'
		computed: {
			now: function () {				//������Ӧʽ����,���ʹ�� now ����,���շ��صĽ������һ����
				return Date.now()
			}
		}
	# ��������ֻ��������������������ı�ʱ�Ż�����ȡֵ
	# '��η��� reverseMessage()' ����,����message�Ƿ����仯,'����ִ��'һ�κ���
	# methods ÿ�ε��ö����������󷵻ؽ��,computed�Ỻ����,ֻ�������ı�,�Ż���������


----------------------------
��������-�������� & Watched Property|
----------------------------
	# Vue.js �ṩ��һ������ $watch ,�����ڹ۲� Vue ʵ���ϵ����ݱ䶯
	# û������ɶ�������......


----------------------------
��������-���� setter		|
----------------------------
	# ��������Ĭ��ֻ�� getter ,��������Ҫʱ��Ҳ�����ṩһ�� setter 

	var app = new Vue({
		el:'#app',
		data:{
			name:'KevinBlandy',
		},
		computed:{
			reverseName:{
				//��ʹ�� reverseName �ĵط���ִ�иú���,
				get : function(){
					return this.name.split('').reverse().join('');
				},
				//�ڿ���ִ̨��  app.reverseName = '123456' ��ִ�и÷���
				set : function(val){
					this.name = val;
					return val.split('').reverse().join('');
				},
			}
		}
	});

	* js�Ļ���֪ʶ:���ԼĴ��� getter/setter


	
----------------------------
��������-�۲� Watchers		|
----------------------------
	# ��Ȼ���������ڴ��������¸�����,����ʱҲ��Ҫһ���Զ���� watcher 
	# Vue �ṩһ����ͨ�õķ���ͨ�� watch ѡ��,����Ӧ���ݵı仯
	# ������Ҫ�����ݱ仯��Ӧʱ,ִ���첽�����򰺹����ʱ,���Ǻ����õ�

		<div id="app">
			<p>{{ message }}</p>
		</div>

		var app = new Vue({
			el:'#app',
			data:{
				message :'Hello World',
			},
			watch:{
				//���� message ����,��ֵ�����仯��ʱ��ᴥ���������
				message:function(newValue,oldValue){
					console.log("messageֵ�ı�:" + newValue)
				}
			}
		});


