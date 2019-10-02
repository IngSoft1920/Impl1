<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head></head>
	<body>
		<form:form>
			<div>
				Id Usuario
				<form:input type="text" value="idUsuario" path="idUsuario" />
			</div>
			<div>
				DateReserva
				<form:input type="text" value="sdateReserva" path="sdateReserva" />
			</div>
			<div>
				Id Hotel
				<form:input type="text" value="idHotel" path="idHotel" />
			</div>
			<div>
				Id Tarifa
				<form:input type="text" value="idTarifa" path="idTarifa" />
			</div>
			<div>
				Num Habs
				<form:input type="text" value="numHabs" path="numHabs" />
			</div>
		</form:form>
	</body>
</html>
