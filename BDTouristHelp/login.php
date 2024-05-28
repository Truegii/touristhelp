<?php
	if ($_SERVER['REQUEST_METHOD'] == 'GET') {
		require_once("db.php");

		$cor = $_GET["correo"];
		$pass = $_GET["password"];

		$query = "SELECT * FROM usuarios WHERE correo = '$cor' AND password = '$pass'";
		$result = $mysql->query($query);

		if ($mysql->affected_rows>0) {

			while ($row = $result -> fetch_assoc()) {
				$array = $row;
			}
			echo json_encode($array);
		}else{
			echo "Incorrecto";
		}


		$result->close();

		$mysql->close();

	}
?>