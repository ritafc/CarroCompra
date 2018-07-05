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
		<h1>Bienvenido ${usuarioActivo.nombre}</h1>

		<div class="articulo">
			
				<c:forEach var="unItem" items="${listaItem}" varStatus="counter">
				<form action="" method="POSt">
					<div class="item">
						<div class="imageitem">
							<img src="./img/item.jpg">
						</div>
						<div>
							<h3>${unItem.nombre}</h3>
							<p>${unItem.precio} $ ${unItem.id_Item}</p>
						</div>
						<div>
							<input type="hidden" name=id_Item iditem="${unItem.id_Item}" value="${unItem.id_Item}" />
							<button name="btn_aceptar">Añadir a la cesta</button>
						</div>
					</div>
					</form>
				</c:forEach>
			
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