<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pretraga predstava</title>
</head>
<body>
	<form action="/Pozoriste/Predstave/pretraziPredstave">
		Naziv: <input type="text" name="naziv"> <input type="submit"
			value="Pretrazi">
	</form>
	<c:if test="${!empty izvodjenja}">
		Prikaz izvodjenja za predstavu ${predstava}
		<table border="1">
			<tr>
				<th>Datum izvodjenja</th>
				<th>Scena</th>
				<th>Rezervacija</th>
			</tr>
			<c:forEach items="${izvodjenja}" var="i">
				<tr>
					<th>${i.datum}</th>
					<th>${i.scena.naziv}</th>
					<td><a href="/Pozoriste/Predstave/Rezervacija?idIzvodjenje?=${i.idIzvodjenje}">Rezervisi</a></td>
					
				</tr>
			</c:forEach>


		</table>


	</c:if>

</body>
</html>