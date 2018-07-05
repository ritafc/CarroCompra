<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Tienda On-line</title>
<link rel="stylesheet" href="./styles.css" />
</head>
<body>


	<header>
		<div class="header">
			<img src="./img/compra.png">
			<nav class="menu">
				<a href="./principal">Home</a> <a href=" ./">Ofertas</a> <a href="./micarro">Mi
					Carrito</a> <a href="./logout">LogOut</a>
			</nav>
		</div>
	</header>

	<section>
		<h1>Bienvenido ${usuarioActivo.nombre} ::tus pedidos</h1>

		<div class="articulo">
			<form action="" method="POSt">
				<table>
					<tr>
						<th>ID-Producto</th>
						<th>Nombre</th>
						<th>Precio</th>
					</tr>
					<c:forEach var="unItem" items="${listamisItem}" varStatus="counter">

						<tr>
							<td>${unItem.id_Item}</td>
							<td>${unItem.nombre}</td>
							<td>${unItem.precio}</td>
						</tr>

					</c:forEach>
				</table>
				<div class="item">
					<div>
						<input type="hidden" name="id_Item" value="" />
						<button name="btn_aceptar">Pagar...</button>
					</div>
				</div>
			</form>
		</div>

	</section>
	<footer>
		<div>
			<a>Enlace1</a><br> <a>Enlace2</a><br> <a>Enlace3</a>
		</div>
		<div>
			<a>Enlace1</a><br> <a>Enlace2</a><br> <a>Enlace3</a>
		</div>
	</footer>
</body>
</html>