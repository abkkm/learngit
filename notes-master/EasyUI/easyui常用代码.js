---------------------
�ۺ�				 |
---------------------
	# �һ���ʾ�Լ��Ĳ˵�(�߱��һ��¼������������ʹ��)
		onContextMenu:function(e,node){
			//��ֹ��������һ��¼�
			e.preventDefault();
			/*
				��ʾ�����Զ���Ĳ˵�
			*/
			$('#treeMenu').menu('show',{
				//�˵���λ����������һ�����ĵط�
				left:e.pageX,
				top:e.pageY
			});
		}
		
---------------------
tree				 |
---------------------
	# �첽ȫչ��
		$('#tree').tree({
			//��̨������Ӧ�ɹ�,������������
			onLoadSuccess:function(node,data){
				/*
					ִ��չ�����нڵ�
					��ÿ��չ����Ҫ�����̨���ᴥ������¼�
					����¼����൱��'�ݹ�'ִ����
				*/
				if(data){
					//������̨��Ӧ�Ľڵ�
					$(data).each(function(index,d){
						/*
							����ǹر�״̬,��ִ�д򿪲���
							�򿪲���,�ֻ������̨������.�ֻᴥ������¼�
							��̨���߼�:������ӽڵ�,���� closed ״̬,���û�ӽڵ�,���� open ״̬
							tree�����ͨ��url���м��ص�,��ô��ִ��չ��ʱ��,���Զ����԰�idֵ���͸�������,����ȡ�ӽڵ�
						*/
						if(this.state == 'closed'){
							$('#tree').tree('expandAll');
						}
					});
				}
			}
		});
	
	# ��ѡ��ʱ��,����и����˵�,ȫ����ѡ,ȡ����ѡ��ʱ��,������Ӳ˵�,ȫ��ȡ����ѡ
		onCheck:function (node, checked) {
			if(checked){
				//��ѡ,���ڸ����˵�,��ѡ���и����˵�
				var parent = $(this).tree('getParent',node.target);
				if(parent != null){
					$(this).tree('check',parent.target);
				}
			}else {
				//ȡ����ѡ,�����Ӳ˵���ȫ��ȡ��
				var childrens = $(this).tree('getChildren',node.target);
				if(childrens != null && childrens.length != 0){
					for(var x = 0;x < childrens.length ; x++){
						$(this).tree('uncheck',childrens[x].target);
					}
				}
			}
		},

	# ˫����/�رսڵ�
		onDblClick:function (node) {
			$(this).tree('toggle',node.target);
		},

---------------------
datagrid			 |
---------------------
	# ��̬������toolbar��ť
		/*
			�ѵ�3����ť����
		*/
		$('div.datagrid-toolbar a').eq(2).hide();
		/*
			�ѵ�3����ť�ָ���('|')����
		*/
		$('.datagrid-btn-separator').eq(2).hide();
		
		* ͬ���,��Ȼ���Ի�ȡ����ť��jq����,�Ϳ���ִ��linkbutton�ķ���,���õ���
			$('div.datagrid-toolbar a').eq(2).linkbutton('disable');
