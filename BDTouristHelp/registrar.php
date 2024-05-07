<?php
	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		require_once("db.php");

		$name = $_POST["name"];
		$age = $_POST["age"];
		$cor = $_POST["correo"];
		$pass = $_POST["password"];

		$query = "INSERT INTO usuarios (nombre, correo, password, edad) VALUES ('$name','$cor','$pass','$age')";
		$result = $mysql->query($query);

		if ($result ===TRUE) {
			echo "Usuario registrado exitosamente";
		}else{
			echo "Error";
		}
		$mysql->close();

	}

?>