# 项目说明
## 1. 实现功能
     实现WebApp与服务器接口交互获取令牌校验
## 2. 环境及框架
     dev framework : Spring 3.1.1 + hibernate 3.3.2 + spring-security 3.2.5 + spring-security-oauth2 2.0.2  
     dev env : MyEclipse 10.5 + Maven 3.0.4
## 3. Postman运行
     步骤1:  
     url: http://localhost:8080/demo4ssh-security-oauth2/oauth/token?client_id=mobile_1&client_secret=secret_1&grant_type=password&username=admin&password=1  
     方法: get  
     返回值: {"access_token":"d6d493ae-6045-465d-8f0e-68e94cd6b62c","token_type":"bearer","refresh_token":"edcb3be6-10f8-4381-80e8-e56aeebd74f0","expires_in":604799,"scope":"read trust write"}  
     jQuery代码:  
     ```javascript
     var settings = {
	  "async": true,
	  "crossDomain": true,
	  "url": "http://localhost:8080/demo4ssh-security-oauth2/oauth/token?client_id=mobile_1&client_secret=secret_1&grant_type=password&username=admin&password=1",
	  "method": "GET",
	  "headers": {
	    "cache-control": "no-cache",
	    "postman-token": "8bb1a385-df93-6800-4a52-bc34f18b5fdf"
	  }
	};
	$.ajax(settings).done(function (response) {
	  console.log(response);
	});
     ```  
     步骤2:  
     url: http://localhost:8080/demo4ssh-security-oauth2/webapi/json?access_token=d6d493ae-6045-465d-8f0e-68e94cd6b62c
     方法: get  
     返回值: [{"id":1,"username":"admin","password":"4DFF4EA340F0A823F15D3F4F01AB62EAE0E5DA579CCB851F8DB9DFE84C58B2B37B89903A740E1EE172DA793A6E79D560E5F7F9BD058A12A280433ED6FA46510A"},{"id":2,"username":"wangwu","password":"4DFF4EA340F0A823F15D3F4F01AB62EAE0E5DA579CCB851F8DB9DFE84C58B2B37B89903A740E1EE172DA793A6E79D560E5F7F9BD058A12A280433ED6FA46510A"}]  
     jQuery代码:  
     ```javascript
	 var settings = {
	  "async": true,
	  "crossDomain": true,
	  "url": "http://localhost:8080/demo4ssh-security-oauth2/webapi/json?access_token=d6d493ae-6045-465d-8f0e-68e94cd6b62c",
	  "method": "GET",
	  "headers": {
	    "cache-control": "no-cache",
	    "postman-token": "9c881972-60ec-68eb-a070-95db859bc52c"
	  }
	};
	$.ajax(settings).done(function (response) {
	  console.log(response);
	});
     ```
