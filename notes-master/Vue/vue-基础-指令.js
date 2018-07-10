------------------------
Vue-ָ��				|
------------------------
	v-if
	v-else
	v-show
	v-for	
	v-on
	v-bind
	v-model	
	v-once
	v-html 


------------------------
v-if					|
------------------------
	# �����ж�
	# ���ñ�ǩ��ʶ�Ľڵ�,ֻ���ڸ�ֵΪtrue��ʱ��,�Ż���ʾ
	# �ܽ�
		1,if����ʹ�� methods �еķ�������ֵ,����Ϊ�ж�����
			<h3 v-if="test()"></h3>
		2,���ֻ����if�������˺���,��δִ��,����Ϊ�� true
			<h3 v-if="test"></h3>
		3,ʹ�� data �е������������ж�
			<h3 v-if="name == 'Kevin'">��ȷ��</h3>
		4,����ֱ��д�ַ���"true",��Ϊ,�������ַ�������Ϊ��flase
			<h3 v-if="true"></h3>
		* ���ַ�������js�������Ͷ�ͷ��
	# ֻ������ȷ��ʱ��,����ڵ�Żᱻ���ص�DOM

------------------------
v-else					|
------------------------
	
------------------------
v-show					|
------------------------
	# �� if ���
	# ��ͬ����,������ȷ�Ƿ�,�ýڵ㶼�����,��� if ���ʽ���Ϊ:false,�����ǰDom����:display:none


------------------------
v-for					|
------------------------
	# ���ڵ�������
	# ѭ�������������
		1,�Ǳ�
			<tr v-for="(item,index) in users">
				<td>{{index}}{{item.name}}</td>
			</tr>
			* item��ĵ�һ������,�����±�,�Ǵ�0��ʼ
			* �����Ҫ��1��ʼ,�����ڱ��ʽ�н��м�1����{{index+1}}
	# �ܽ�
		1,����ֱ�ӵ��� vue ʵ���� data �����е�����
			<tr v-for="item in users">
				<td>{{item.name}}</td>
			</tr>
			* ���Ŀ�����ַ���,�����ַ�����ÿ�����Զ�����Ԫ��������
			* ���Ŀ����JSON����,�������ö����е�valueֵ
			* ���Ŀ����JSON��������,����ÿ��JSON�������л�Ϊ�ַ������е���
			* ���Ŀ�겻�ǿɵ�������,�򲻻��е���Ч��

		2,Ҳ���Ե��� methods �����ķ���ֵ
			<tr v-for="item in getUsers()">
				<td>{{item.name}}</td>
			</tr>

------------------------
v-on					|
------------------------
	# ���¼�����
	# �﷨
		v-on:[�¼�]
	# demo
		 <div id="app">
            <p>{{message}}</p>
            <button v-on:click="reverseMessage">����</button>
        </div>

		var app = new Vue({
            el:'#app',
            data:{
                message:'KevinBlandy'
            },
            methods:{
                reverseMessage:function(){		//�����ʱ��,��ת�ַ���
                    this.message = this.message.split('').reverse().join('');
                }
            }
        });


------------------------
v-bind					|
------------------------
	# �� DOM Ԫ������
	# �﷨
		v-bind:[Ԫ������]
	# demo
		<div id="app">
            <span v-bind:class="cls">
                һЩ����
            </span>
        </div>
		var app = new Vue({
            el:'#app',
            data:{
                cls:'bg_blue',
            }
        });

------------------------
v-model					|
------------------------
	# �ֱ������Ӧ��״̬֮���˫���
	# �﷨
		v-model=""
		* ���ָ���ı����͵�ǰinput���ֵ��
	# demo
		 <div id="app">
            <p>{{message}}</p>
            <input v-model="message" placeholder="����������"/>
        </div>

		 var app = new Vue({
            el:'#app',
            data:{
                message:''
            }
        });
