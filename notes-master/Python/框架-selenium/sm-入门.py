----------------------------
����						|
----------------------------
	* ��װ
		pip install selenium


----------------------------
��������					|
----------------------------
	# ����webdriver
	from selenium import webdriver

	# ����driver����,ͨ��executable_pathָ��phantomjsִ���ļ�·��
	driver = webdriver.PhantomJS(executable_path='./phantomjs')

----------------------------
�����Ĳ���					|
----------------------------
	# ���� webdriver
	from selenium import webdriver

	# ��Ҫ���ü��̲���,��Ҫ���� keys ��
	from selenium.webdriver.common.keys import Keys

	# ���û�������ָ���� PhantomJS ������������������
	# driver = webdriver.PhantomJS()

	# ���û���ڻ�������ָ�� PhantomJS ��λ��(��ʵ����ָ�� phantomjsִ���ļ��ĵ�ַ)
	driver = webdriver.PhantomJS(executable_path='./phantomjs')

	# ger������һֱ�ȵ�ҳ����ȫ������,Ȼ��Ż���������ִ��
	driver.get('https://www.baidu.com')

	# ����ҳ�����
	driver.save_screenshot('baidu.png')

	# �ҵ�idΪkw��Ԫ��(input),������д�� "Hello"
	driver.find_element_by_id('kw').send_keys("Hello")

	# �ҵ�idΪid��Ԫ��,ִ�е����
	driver.find_element_by_id('su').click()

	# ����ҳ�����
	driver.save_screenshot('hello.png')

	# ��ӡ��ҳԴ��
	print(driver.page_source)

	# ��ȡ���е� cookie
	print(driver.get_cookies())

	# ��ȡָ�����Ƶ�cookie
	#driver.get_cookie('JESSIONID')

	# ctrl + a ȫѡ���������
	driver.find_element_by_id('kw').send_keys(Keys.CONTROL,'a')

	# ctrl + x �������������
	driver.find_element_by_id('kw').send_keys(Keys.CONTROL,'x')

	# �����������������
	driver.find_element_by_id('kw').send_keys('KevinBlandy')

	# ģ��enter�س���
	driver.find_element_by_id('su').send_keys(Keys.ENTER)

	# ������������
	driver.find_element_by_id('kw').clear()

	# ��ȡ��ǰUrl
	print(driver.current_url)

	# �رյ�ǰҳ��,���ֻ��һ��ҳ���ر������
	driver.close()

	# �ر������
	driver.quit()

----------------------------
Ԫ�ػ�ȡ					|
----------------------------
	* �����Ļ�ȡ
		# ����id����
		driver.find_element_by_id()
		# �������ּ���
		driver.find_element_by_name()
		driver.find_element_by_xpath()
		driver.find_element_by_link_text()
		driver.find_element_by_partial_link_text()
		# ���ݱ�ǩ���Ƽ���
		driver.find_element_by_tag_name()
		# ����class���Ƽ���
		driver.find_element_by_class_name()
		# ����cssѡ��������
		driver.find_element_by_css_selector()
	
	* Ҳ�������ŵ�ͨ��api����ȡ
		from selenium.webdriver.common.by import By
		# ͨ�� By ö����ָ��Ҫ���˵�����,����valuָ��ֵ
		element = driver.find_element(by=By.ID, value="coolestWidgetEvah")

		* By.CLASS_NAME
		* By.TAG_NAME
		* By.NAME
		* By.LINK_TEXT
		* By.CSS_SELECTOR
		* By.XPATH
	

----------------------------
��궯����					|
----------------------------
	from selenium import webdriver
	from selenium.webdriver import ActionChains
	driver = webdriver.PhantomJS(executable_path='./phantomjs')

	# ��ȡ�ڵ����
	photo = driver.find_element_by_id('photo')

	# ͨ��driver����Action����������
	action = ActionChains(driver)

	# �ƶ���굽ָ���Ľڵ�
	action.move_to_element(photo).perform()

	# ����ָ���ڵ�
	action.move_to_element(photo).click(photo).perform()

	# ˫��ָ���ڵ�
	action.move_to_element(photo).double_click(photo).perform()

	# �һ�ָ���ڵ�
	action.move_to_element(photo).context_click(photo).perform()

	# ���holdסָ���ڵ�
	action.move_to_element(photo).click_and_hold(photo).perform()

	# ��photo�ڵ���ק��next�ڵ�
	action.drag_and_drop(photo, driver.find_element_by_id('next')).perform()

----------------------------
�����					|
----------------------------
	* �Ѿ�֪�����������ı�������������
	* ������ʱ�����ǻ�����<select> </select>��ǩ��������,ֱ�ӵ���������е�ѡ�һ������
	* Seleniumר���ṩ��Select��������������
		# ���� Select ��
		from selenium.webdriver.support.ui import Select

		# �ҵ� name ��ѡ�
		select = Select(driver.find_element_by_name('status'))

		# �����������λ��ѡ��
		select.select_by_index(1)
		# ����ѡ���ֵѡ��
		select.select_by_value("0")
		# ����option��ǩ�ı���ֵѡ��
		select.select_by_visible_text("δ���")

		# ȡ��ѡ��
		select.deselect_all()

----------------------------
��������					|
----------------------------
	* ����ҳ���alert����
		alert = driver.switch_to_alert()

----------------------------
ҳ���л�					|
----------------------------
	* ����ҳ��
		driver.switch_to_window('ҳ������')

	* Ҳ����ʹ�� window_handles ��������ȡÿ�����ڵĲ�������
		for handle in driver.window_handles:
			driver.switch_to_window(handle)

----------------------------
ҳ��ǰ���ͺ���				|
----------------------------
	driver.forward()	# ǰ��
	driver.back()		# ����
	
----------------------------
ִ��js�ű�					|
----------------------------
	driver.execute_script('alert("����")')

----------------------------
cookie						|
----------------------------
	* ��ȡ���е� cookie
		driver.get_cookies()

	* ��ȡָ�����Ƶ�cookie
		driver.get_cookie('JESSIONID')
	
	* ɾ��cookie
		driver.delete_cookie('name')
	
	* ɾ������cookie
		driver.delete_all_cookies()

	
----------------------------
ҳ��ȴ�					|
----------------------------
	* ��վ�������в���ajax�첽����,��ЩԪ����ͨ���첽���زŻᱻ����dom�ڴ�
	* �����ַ�ʽ�����������
	* .... ...

	* ��ʾ�ȴ�,��ʾָ��ĳ������,Ȼ��������ȴ�ʱ��,�����ʱ��δ�ҵ�Ԫ��,�׳��쳣
		from selenium import webdriver
		from selenium.webdriver.common.by import By
		# WebDriverWait ��,����ѭ���ȴ�
		from selenium.webdriver.support.ui import WebDriverWait
		# expected_conditions �ฺ����������
		from selenium.webdriver.support import expected_conditions as expected_conditions

		driver = webdriver.Chrome()
		driver.get("http://www.xxxxx.com/loading")
		try:
			# ҳ��һֱѭ����ֱ�� id="myDynamicElement" ����
			element = WebDriverWait(driver, 10).until(
				expected_conditions.presence_of_element_located((By.ID, "myDynamicElement"))
			)
		finally:
			driver.quit()
	
	* ����Ĭ�ϻ� 0.5s ����һ�����鿴Ԫ���Ƿ��Ѿ����ɣ��������Ԫ�ؾ��Ǵ��ڵģ���ô���������ء�
	* ������һЩ���õĵȴ�����,����ֱ�ӵ�����Щ����,�������Լ�дĳЩ�ȴ�������
		title_is
		title_contains
		presence_of_element_located
		visibility_of_element_located
		visibility_of
		presence_of_all_elements_located
		text_to_be_present_in_element
		text_to_be_present_in_element_value
		frame_to_be_available_and_switch_to_it
		invisibility_of_element_located
		element_to_be_clickable �C it is Displayed and Enabled.
		staleness_of
		element_to_be_selected
		element_located_to_be_selected
		element_selection_state_to_be
		element_located_selection_state_to_be
		alert_is_present

	* ��ʽ�ȴ��Ƚϼ�,���Ǽ򵥵�����һ���ȴ�ʱ��,��λΪ��
		from selenium import webdriver
		driver = webdriver.Chrome()
		driver.implicitly_wait(10) # seconds
		driver.get("http://www.xxxxx.com/loading")
		myDynamicElement = driver.find_element_by_id("myDynamicElement")
		
		* ��Ȼ���������,Ĭ�ϵȴ�ʱ��Ϊ0