
'''
<properties>
	<maven.compiler.source>1.8</maven.compiler.source>
	<maven.compiler.target>1.8</maven.compiler.target>
	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
	<hibernate.version>5.6.10.Final</hibernate.version>
	<h2.version>1.4.200</h2.version>
</properties>
'''

'''
<dependencies>
	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-core</artifactId>
		<version>${hibernate.version}</version>
	</dependency>
	<!-- Driver JDBC -->
	<dependency>
		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
		<version>${h2.version}</version>
	</dependency>
</dependencies>
'''

https://www.oracle.com/webfolder/technetwork/jsc/xml/ns/persistence/index.html

'''
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
<persistence>
'''

'''
<property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
<property name="hibernate.show_sql" value="true" />
<property name="hibernate.hbm2ddl.auto" value="create-drop" />
<property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
<property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:test"/>
<property name="javax.persistence.jdbc.user" value="sa"/>
<property name="javax.persistence.jdbc.password" value=""/>
 '''