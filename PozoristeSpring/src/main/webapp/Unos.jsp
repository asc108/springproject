<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos Predstave</title>
</head>
<body>
	<form action="/Pozoriste/Predstave/sacuvajPredstavu" method="post">
		<table>
			<tr>
				<td>Naziv:</td>
				<td><input type="text" name="naziv"></td>
			</tr>
			<tr>
				<td>Opis:</td>
				<td><input type="text" name="opis"></td>
			</tr>
			<tr>
				<td>Zanr :</td>
				<td><select name="idZanr">
						<c:forEach items="${zanrovi}" var="z">
							<option value="${z.idZanr}">${z.naziv}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Reziser:</td>
				<td><select name="idReziser">
						<c:forEach items="${reziseri}" var="r">
							<option value="${r.idReziser} ">${r.ime}${r.prezime}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Sacuvaj predstavu"></td>
			</tr>
		</table>
	</form>
	<c:if test="${!empty p}">
	Predstava ${p.idPredstava} je uspesno sacuvana!
	</c:if>
	<a href="/Pozoriste">Pocetna strana</a>

</body>
</html>