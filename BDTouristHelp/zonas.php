<?php
	if ($_SERVER['REQUEST_METHOD'] == 'GET') {
		require_once("db.php");

		$idzona = $_GET["zona"];


		$query = "SELECT * FROM zonas WHERE idzona = '$idzona'";
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