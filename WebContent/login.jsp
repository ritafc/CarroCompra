<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String error_mess=(String)request.getAttribute("error");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="UTF-8">
<title>Tienda On-line</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<H1>Entra o registrate!!</H1>
	<section>
		<div class="articulo">
			<form method="POST" action="" novalidate>
				<div class="error" id="showError"><%=(error_mess != null ? error_mess : "")%></div>
				<div>
					<label>Login </label>
					<input type="email" name="login" placeholder="escribe tu login" required>
				</div>
				<div>
					<label>Password </label>
					<input type="password" name="pass" placeholder="escribe tu password" required minlength="3">
				</div>
				<button id="btn_Login">Entrar</button>
			</form>
		</div>
	</section>
</body>
<script type="text/javascript" src="./script.js"></script>
</html>