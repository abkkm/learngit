
������������������������������������������������
1,maven����				|
������������������������������������������������	
	* ���е���������ͨ����������λ��
		GAV
		GroupId
		ArtifactId
		Version
	* �����м����Ƚ���Ҫ�ĸ���
	* <dependency>
		  <groupId>junit</groupId>
		  <artifactId>junit</artifactId>
		  <version>4.10</version>
		  <scope>
			provided	//����Ͳ��Ե�ʱ������jar��,�����ʱ�򲻻����jar��
			test		//�����ڲ��Ե�ʱ������,����ʹ����ʱ������

			compie		//�����ʱ�����jar��,�����ʱ��Ҳ��ӽ�ȥ[Ĭ��]
			runtime		//�����кͲ��Ե�ʱ������jar,�����ʱ�򲻻�����
		  </scope>
	  </dependency>

		test
			* �ڲ��Է�Χ��Ч,����ʹ����ʱ�򲻻��õ��������
			* ����:junit,���Ե�ʱ��ʹ�õ��Ķ���
		compile		//Ĭ��
			* �ڱ��뷶Χ��Ч,�ڱ���ʹ��ʱ����������洢��ȥ
		provided
			* �ڱ���Ͳ��ԵĹ�����Ч,�������war����ʱ�򲻻����
			* ����:servlrt,��jslt��,��ΪTomcat������Ǽ�
		runtime
			* �����е�ʱ������,�ڱ����ʱ������
			* ����:MySQL����!
	
	* �����Ĵ���
		<dependency>
		  <groupId>${project.groupId}</groupId>
		  <artifactId>user-core</artifactId>
		  <version>${project.version}</version>
		  <!-- �ų�ָ�������� -->
		  <exclusions>
			<exclusion>
				<groupId>commons-logging</groupId>
				<artifactId>commons-logging</artifactId>
			</exclusion>
		  </exclusions>
		</dependency>                       
		* ֻ�ᴫ��scopeΪcompile�İ�
		* ������������ͬ��ʱ��,˭����������˭
		* �����ְ���ͻ��ʱ��,��ʹ������������ų�

--------------------

	<dependency>
			<groupId></groupId>
			<artifactId></artifactId>
			<version></version>
			<type></type>
			<scope>
				
			</scope>
	</dependency>
	* spoce,������������ʲôʱ��
	* maven�ڲ�ͬ��ʱ����в�ͬ��classpath
	* scope,��ȷ������Щ������������Щclasspath
	1,compile[Ĭ��]
		* ����,����,����
	2,provided
		* ����,����
		* ServletAPI
	3,runtime
		* ����,����
		* JDBC
	4,test
		* ����
		* Junit
	5,system
		* ����,����
		* ���������
	6,import
		* ����ķ�Χ,����ʹ����dependencyManagerment��,��ʾ,��������pom�е���dependecy������


�����Եĳ�ͻ����
1,A ���� B --> �汾��1.0(B��lo4j�汾)
2,C ���� B --> �汾��1.1
3,D ���� A �� B
	* ��ʱ��,��D��,˭��д.������˭�İ汾!

------------------------
2,����ѡ��������		|
------------------------
	* A ���� B 
	* B ��������C ,��������D .���Ǿ��ǲ��ܶ�����
		* ����:B��һ�����ݿ⹤����,Ҫôѡ��mysql��Ҫôѡ��Oracle
	��Ҫ�����������һ����ǩ


	<dependency>
		....			mysql��jdbc
		<optionale>true</optinale>
	</dependency>
	<dependency>
		....			Oracle��jdbc
		<optionale>true</optinale>
	</dependency>

	* ��ʱ��Ҫע���ʱ��,B���˴����������󣡣���ôA������B!!�������������ᱻ���ݹ�ȥ��������
	* ������Ҫ��A��Ҫ����ѡ��,Ҫô�Լ����mysql��������b��!Ҫô���oracle��������b��
	* ͨ�׵�˵����
		* ������ѡ��,�����Ҳ�ѡ!˭Ҫ������!�����ѡ��һ����
	


------------------------
2,��������				|
------------------------
	1,����Ŀ·�����½� lib Ŀ¼(���ڴ�ŵ���������)
		application
			lib
			src/main/...
			src/test/...

	2,�������
		<dependency>
			<groupId>icbcClient</groupId>
			<artifactId>icbcClient</artifactId>
			<version>1.0</version>
			<scope>system</scope>
			<systemPath>${basedir}/lib/icbcClient-1.0.jar</systemPath> 
		</dependency>

	3,�����Դ�������
		* <scope>system</scope> Ĭ�ϲ�������jar
		<!-- ���� jar -->
            <resource>
                <directory>${basedir}/lib</directory>
                <targetPath>BOOT-INF/lib/</targetPath>
                <includes>	
                    <include>**/*.jar</include>					**/
                </includes>
            </resource>
            <resource>
                 <directory>src/main/resources</directory>
                 <includes>
                     <include>**/*</include>					**/
                 </includes>
            </resource>


	
	4,war�����ʽ�ı���lib
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-war-plugin</artifactId>
			<version>3.0.0</version>
			<configuration>
				<webResources>
					<resource>
						<directory>${project.basedir}/src/main/resources/lib/net/pusuo</directory>
						<targetPath>WEB-INF/lib</targetPath>
						<filtering>false</filtering>
						<includes>
							<include>**/*.jar</include>
						</includes>
					</resource>
				</webResources>
			</configuration>
		</plugin>
