------------------------
�ַ���ģ��				|
------------------------
	# ��ͳ�� JavaScript �������ģ��ͨ��������д��
		$('#result').append(
			'There are <b>' + basket.count + '</b> ' +
			'items in your basket, ' +
			'<em>' + basket.onSale +
			'</em> are on sale!'
		);
	
	# ��������д���൱����������,ES6 ������ģ���ַ�������������
		$('#result').append(
			`
			  There are <b>${basket.count}</b> items
			   in your basket, <em>${basket.onSale}</em>
			  are on sale!
			`
		);

	# ģ���ַ���
		* ģ���ַ���(template string)����ǿ����ַ���,�÷�����(`)��ʶ
		* '�����Ե�����ͨ�ַ���ʹ��,Ҳ����������������ַ���,�������ַ�����Ƕ�����'

			// ��ͨ�ַ���
			`In JavaScript '\n' is a line-feed.`

			// �����ַ���
			`In JavaScript this is
			 not legal.`

			console.log(`string text line 1
			string text line 2`);

			// �ַ�����Ƕ�����
			let name = "Bob", time = "today";
			`Hello ${name}, how are you ${time}?`

		* �����ģ���ַ�������Ҫʹ�÷����ţ���ǰ��Ҫ�÷�б��ת�塣
			let greeting = `\`Yo\` World!`;
		
		* ���ʹ��ģ���ַ�����ʾ�����ַ���,���еĿո���������ᱻ���������֮��
			let str = `
				ǰ��Ŀո��ж���������
			`;
			console.log(str);

			* ����㲻��Ҫ�������,�ո����ʹ��trim����������
				console.log(str.trim());
			
		* ģ���ַ�����Ƕ�����,��Ҫ��������д��${}֮��
			function authorize(user, action) {
				  if (!user.hasPrivilege(action)) {
					throw new Error(
					  // ��ͳд��Ϊ
					  // 'User '
					  // + user.name
					  // + ' is not authorized to do '
					  // + action
					  // + '.'
					  `User ${user.name} is not authorized to do ${action}.`);
				  }
			}

		* ${}�ڲ����Է�������� JavaScript ���ʽ,���Խ�������,�Լ����ö�������
			let x = 1;
			let y = 2;
		
			`${x} + ${y} = ${x + y}`
			// "1 + 2 = 3"
		
			`${x} + ${y * 2} = ${x + y * 2}`
			// "1 + 4 = 5"
		
			let obj = {x: 1, y: 2};
			`${obj.x + obj.y}`
			// "3"
		
		* ģ���ַ���֮�л��ܵ��ú�����
			function fn() {
			  return "Hello World";
			}

			`foo ${fn()} bar`
			// foo Hello World bar
		
		* ����������е�ֵ�����ַ���,������һ��Ĺ���תΪ�ַ�������,����������һ������,��Ĭ�ϵ��ö����toString����

		* ���ģ���ַ����еı���û������,������

			// ����placeû������,����
			let msg = `Hello, ${place}`;
			
		* ����ģ���ַ����Ĵ������ڲ�,����ִ�� JavaScript ����,�������������ڲ���һ���ַ�������ԭ�����
			`Hello ${'World'}`
			// "Hello World"
		
		* ģ���ַ�����������Ƕ�ס�
			const tmpl = addrs => 
			`
			  <table>
			  ${addrs.map(addr => 
			  `
				<tr><td>${addr.first}</td></tr>
				<tr><td>${addr.last}</td></tr>
			  `
			  ).join('')}
			  </table>
			`;

			* ������  `��ð� ${getNameById(`747692844`)}`
		
		* �����Ҫ����ģ���ַ�������,����Ҫʱִ��,��������������д
			// д��һ
			let str = 'return ' + '`Hello ${name}!`';
			let func = new Function('name', str);
			func('Jack') // "Hello Jack!"

			// д����
			let str = '(name) => `Hello ${name}!`';
			let func = eval.call(null, str);
			func('Jack') // "Hello Jack!"

------------------------
ģ�����				|
------------------------
	# һ��ͨ��ģ���ַ���,������ʽģ���ʵ��

	1,����ģ��
		let template = `
			<ul>
				<%for (let i of users){%>
					<li><%=i.name%>,<%=i.age%></li>
				<%}%>
			</ul>
		`;

		* ���������ģ���ַ���֮��,������һ������ģ��
		* ��ģ��ʹ��<%...%>���� JavaScript ����,ʹ��<%= ... %>��� JavaScript ���ʽ
	
	2,����ģ�淽��
		function compile(template){
			const evalExpr = /<%=(.+?)%>/g;
			const expr = /<%([\s\S]+?)%>/g;

			template = template
			.replace(evalExpr, '`); \n  echo( $1 ); \n  echo(`')
			.replace(expr, '`); \n $1 \n  echo(`');

			template = 'echo(`' + template + '`);';

			let script =
			`	(function parse(data){
				let output = "";
				
				function echo(html){
				  output += html;
				}
				
				${ template }
				
				return output;
				})
			`;

			return script;
		}
	
	3,ִ�б������Ⱦ
		
		//��ȡ������ģ��
		let parse = eval(compile(template));
		
		//�����������
		var users = [{name:'Kevin',age:23},{name:'Litch',age:25}];
		
		//ִ��ģ����Ⱦ,������Ⱦ���
		console.log(parse(users));


------------------------
ģ���ǩ				|
------------------------
	# ģ���ַ���,���Խ�����һ������������,�ú��������������������ģ���ַ���,�ⱻ��Ϊ"��ǩģ��"����(tagged template)
		alert`Hello`
	
	# ��ǩģ����ʵ����ģ��,���Ǻ������õ�һ��������ʽ,"��ǩ"ָ�ľ��Ǻ���,�����ں����ģ���ַ����������Ĳ���

	# ����,���ģ���ַ������б���,�Ͳ��Ǽ򵥵ĵ�����,���ǻὫģ���ַ����ȴ���ɶ������,�ٵ��ú���
		let a = 5;
		let b = 10;

		tag`Hello ${ a + b } world ${ a * b }`;

		// ��ͬ��   ===== ���� ${} ���ַ����зֿ���,��ÿ�ζ�������һ�������ﴫ�ݸ���һ������,Ȼ���${}�����ֵ,����д�����Ĳ���
		//
		tag(['Hello ', ' world ', ''], 15, 50);

		* ����tag���λ���յ��������
			function tag(stringArr, value1, value2){
			  // ...
			}
			// ��ͬ��
			function tag(stringArr, ...values){
			  // ...
			}
			* tag�����ĵ�һ��������һ������,������ĳ�Ա��ģ���ַ�������Щû�б����滻�Ĳ���
			* Ҳ����˵,�����滻ֻ����������ĵ�һ����Ա��ڶ�����Ա֮��,�ڶ�����Ա���������Ա֮��,�Դ�����
			* Ҳ����˵��tag����ʵ�������������ʽ����(��һ������������һ����һ�����ַ���(''))
				tag(['Hello ', ' world ', ''], 15, 50)
	
		* ���ǿ��԰�����Ҫ��дtag�����Ĵ���
			let a = 5;
			let b = 10;

			function tag(s, v1, v2) {
			  console.log(s[0]);	// "Hello "
			  console.log(s[1]);	// " world "
			  console.log(s[2]);	// ""
			  console.log(v1);		// 15
			  console.log(v2);		// 50
			  return "OK";
			}
			tag`Hello ${ a + b } world ${ a * b}`;
		
		* �����ӵ�����
			function passthru(literals) {
				let result = '';
				let i = 0;
				while (i < literals.length) {
					result += literals[i++];
					if (i < arguments.length) {		//ͨ��arguments����ȡ���ݽ�����ģ�����
						result += arguments[i];
					}
				}
				return result;
			}
		
		* rest �����ĺ�������
			function passthru(literals, ...values) {
				let output = "";
				let index;
				for (index = 0; index < values.length; index++) {		//����ģ�����
					output += literals[index] + values[index];
				}
				output += literals[index]
				return output;
			}

		* "��ǩģ��"��һ����ҪӦ��,���ǹ��� HTML �ַ���,��ֹ�û������������
			function SaferHTML(templateData) {
				let s = templateData[0];
				for (let i = 1; i < arguments.length; i++) {
					let arg = String(arguments[i]);
					// Escape special characters in the substitution.
					s += arg.replace(/&/g, "&amp;")
					.replace(/</g, "&lt;")
					.replace(/>/g, "&gt;");

					// Don't escape special characters in the template.
					s += templateData[i];
				}
				return s;
			}

			let message = SaferHTML`<p>${sender} has sent you a message.</p>`;

			* ender�����������û��ṩ��,���� SaferHTML ��������,����������ַ����ᱻת��

		* ��ǩģ�����һ��Ӧ��,���Ƕ�����ת��(���ʻ�����)
			i18n`Welcome to ${siteName}, you are visitor number ${visitorNumber}!`
			// "��ӭ����xxx�����ǵ�xxxxλ�����ߣ�"
		
		* ģ�崦�����ĵ�һ������(ģ���ַ�������),����һ��raw����
			console.log`123`
			// ["123", raw: Array[1]]

			* console.log���ܵĲ���,ʵ������һ������,��������һ��raw����
			
			* tag�����ĵ�һ������,��һ��raw����,Ҳָ��һ������,������ĳ�Ա���һ��������ȫһ��
				tag`First line\nSecond line`
				function tag(strings) {
					console.log(strings.raw[0]);
					// strings.raw[0] Ϊ		"First line\\nSecond line"
					// ��ӡ���				"First line\nSecond line"
				}
				* ���� strings ������		["First line\nSecond line"]
				* ��ô strings.raw �������	["First line\\nSecond line"]
				* ����Ψһ������,�����ַ��������б�ܶ���ת����,\
				* ����,strings.raw ����Ὣ\n��Ϊ\\��n�����ַ�,�����ǻ��з�
				  ����Ϊ�˷���ȡ��ת��֮ǰ��ԭʼģ�����Ƶ�
		
		* String.raw() ����
			* ���ǰ� `` ת��Ϊ������ַ���,Ȼ���``���濴��������Щ���а�֮��ķ���,������ַ�����ת�����
			* ES6 ��Ϊԭ���� String ����,�ṩ��һ��raw����
			* String.raw����,���������䵱ģ���ַ����Ĵ�����,����һ��б�ܶ���ת��(��б��ǰ���ټ�һ��б��)���ַ�����Ӧ���滻�������ģ���ַ���
				String.raw`Hi\n${2+3}!`;
				// ���� "Hi\\n5!"

				String.raw`Hi\u000A!`;
				// ���� "Hi\\u000A!"

			* ���ԭ�ַ�����б���Ѿ�ת��,��ôString.raw������ٴ�ת��
				String.raw`Hi\\n`
				// ���� "Hi\\\\n"
			
			* String.raw����������Ϊ����ģ���ַ����Ļ�������,���Ὣ���б����滻,���Ҷ�б�ܽ���ת��,'������һ����Ϊ�ַ�����ʹ��'
			* String.raw����Ҳ������Ϊ�����ĺ���ʹ��,��ʱ,���ĵ�һ������,Ӧ����һ������raw���ԵĶ���,'��raw���Ե�ֵӦ����һ������'

				String.raw({ raw: 'test' }, 0, 1, 2);
				// 't0e1s2t'

				// ��ͬ��
				String.raw({ raw: ['t','e','s','t'] }, 0, 1, 2);
			
			* ��Ϊ����,String.raw�Ĵ���ʵ�ֻ�������
				String.raw = function (strings, ...values) {
					let output = '';
					let index;

					for (index = 0; index < values.length; index++) {
					  output += strings.raw[index] + values[index];
					}
					
					output += strings.raw[index]
					return output;
				}

------------------------
�ַ���ģ�������		|
------------------------
	* ��ǩģ������,������Ƕ��������,����,ģ���ַ���Ĭ�ϻὫ�ַ���ת��,�����޷�Ƕ����������
	* Ϊ�˽���������,ES2018 �����˶Ա�ǩģ��������ַ���ת�������
	* ����������Ϸ����ַ���ת��,�ͷ���undefined,�����Ǳ���,���Ҵ�raw����������Եõ�ԭʼ�ַ���
		function tag(strs) {
		  strs[0] === undefined							//�ǲ��Ϸ����ַ���ת��
		  strs.raw[0] === "\\unicode and \\u{55}";		//���Ի�ȡ��ԭʼ�ַ���
		}
		tag`\unicode and \u{55}`
		
		* ���������,ģ���ַ���ԭ����Ӧ�ñ����,�������ڷ����˶��ַ���ת�������,���Բ�������
		* JavaScript ���潫��һ���ַ�����Ϊundefined,����raw������Ȼ���Եõ�ԭʼ�ַ���,���tag�������ǿ��Զ�ԭ�ַ������д���

		* ע��,���ֶ��ַ���ת��ķ���,ֻ�ڱ�ǩģ������ַ���ʱ��Ч,���Ǳ�ǩģ��ĳ���,��Ȼ�ᱨ��
			let bad = `bad escape sequence: \unicode`; // ����