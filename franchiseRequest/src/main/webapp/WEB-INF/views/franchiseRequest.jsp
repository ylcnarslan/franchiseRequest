<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<html>
<script>
	function validation() {
		var x = document.forms["form"]["tcId"].value;
		//e-mail control
		var emailRegEx = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i;
		//birthDate control
		var datePat = /^(\d{2,2})(\/)(\d{2,2})\2(\d{4}|\d{4})$/;
		
		if (isNaN(x)) {
			alert("TC Kimlik numarası sadece rakamlardan oluşmalı!");
			return false;
		} else if (x.length > 11 || x.length < 11) {
			alert("TC Kimlik numarası 11 haneli olmalı!");
			return false;
		} 
		else if (document.forms["form"]["email"].value.search(emailRegEx) == -1) {
	          alert("Geçerli bir mail adresi girin!");
	          return false;
	     }
		else if(document.forms["form"]["birthDate"].value.match(datePat) == null)
		{
		  alert("Doğum tarihiniz 01/01/2018 şeklinde olmalıdır.")
		  return false;
		}
		else if (document.forms["form"]["name"].value == ""
				|| document.forms["form"]["address"].value == ""
				|| document.forms["form"]["phone"].value == ""
				|| document.forms["form"]["beforeExperience"].value == "NONE"
				|| document.forms["form"]["city"].value == ""
				|| document.forms["form"]["district"].value == ""
				|| document.forms["form"]["neighborhood"].value == "")
		{
			alert("Lütfen gerekli alanları doldurun!");
			return false;
		}
	}
</script>

<style><%@include file="/WEB-INF/css/style.css"%></style>

<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
	<form:form name="form" method="post" modelAttribute="franchise"
		action="/franchiseRequest/franchiseRequest"
		onsubmit="return validation()">
		<table>
			<tr>
				<th colspan="3">Bayilik Ön Başvuru Formu</th>
			</tr>
			<tr>
				<td><form:label path="name"><span style="color:red">*</span>İSİM - SOYİSİM:</form:label></td>
				<td><form:input path="name" size="30"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="tcId"><span style="color:red">*</span>TC KİMLİK:</form:label></td>
				<td><form:input path="tcId" size="30"></form:input></td>
				<td><p>TC Kimlik numarası 11 haneli olmalı ve sadece rakamlardan
						oluşmalı.</p></td>
			</tr>
			<tr>
				<td><form:label path="address"><span style="color:red">*</span>ADRES:</form:label></td>
				<td><form:textarea path="address" rows="5" cols="32"
						style="resize:none" /></td>	
			</tr>
			<tr>
				<td><form:label path="phone"><span style="color:red">*</span>TELEFON:</form:label></td>
				<td><form:input path="phone" size="30"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="email">E-POSTA:</form:label></td>
				<td><form:input path="email" size="30"></form:input></td>
				<td><p>Örn: address@domain.com</p></td>
			</tr>
			<tr>
				<td><form:label path="birthDate">DOĞUM TARİHİ:</form:label></td>
				<td><form:input path="birthDate" size="30" /></td>
				<td><p>Doğum tarihiniz 01/01/2018 formatında olmalıdır.</p></td>
			</tr>
			<tr>
				<td><form:label path="beforeExperience"><span style="color:red">*</span>PERAKENDE TİCARETİ İLE UĞRAŞTINIZ MI?</form:label></td>
				<td><form:select path="beforeExperience">
						<form:option value="NONE" label="---Lütfen Seçim Yapın---" />
						<form:option value="0" label="EVET" />
						<form:option value="1" label="HAYIR" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="preferred">LOKUMCU BABA'YI TERCİH ETMENİZİN SEBEBİ NEDİR?</form:label></td>
				<td><form:input path="preferred" size="30" /></td>
			</tr>
			<tr>
				<td><form:label path="city"><span style="color:red">*</span>HANGİ İL/İLÇE/SEMT İÇİN LOKUMCU BABA İŞLETMECİLİĞİ DÜŞÜNÜYORSUNUZ?</form:label></td>
				<td><form:input path="city" size="30" placeholder="İl girin..."/></td>
			</tr>
			<tr>
				<td></td>
				<td><form:input path="district" size="30" placeholder="İlçe girin..."/></td>
			</tr>
			<tr>
				<td></td>
				<td><form:input path="neighborhood" size="30" placeholder="Mahalle girin..."/></td>
			</tr>
			<tr>
				<td><form:label path="investmentAmount">YATIRIM MİKTARINIZ NEDİR?</form:label></td>
				<td><form:input path="investmentAmount" size="30" /></td>
			</tr>
			<tr>
				<td><form:label path="addedInfo">EKLEMEK İSTEDİKLERİNİZ:</form:label></td>
				<td><form:textarea path="addedInfo" rows="5" cols="32"
						style="resize:none" /></td>
			</tr>
			<tr>
				<td colspan="3"><p>* ile belirtilen alanların doldurulması zorunludur.</p></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Başvuru Yap"
					class="blue-button" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<c:if test="${not empty message  }">
						<p class="successMessage"><b>${message}</b></p>
					</c:if>
			
					<c:if test="${not empty error}">
						<p class="errorMessage"><b>${error}</b></p>
					</c:if>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>